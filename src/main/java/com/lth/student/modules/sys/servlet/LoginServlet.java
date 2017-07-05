package com.lth.student.modules.sys.servlet;

import com.lth.student.modules.sys.entity.SysUser;
import com.lth.student.modules.sys.service.ISysUserService;
import com.lth.student.modules.sys.service.impl.SysUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private ISysUserService sysUserService = new SysUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt.equals("login")){
            login(req,resp);
        }else if (opt.equals("loginOut")){
            req.getSession().invalidate();
        }
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        String loginPass = request.getParameter("loginPass");
        SysUser sysUser = sysUserService.login(loginId,loginPass);
        if (sysUser == null){
            String message = "用户名或密码错误，请重新输入！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("sysUser",sysUser);
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }
    }
}
