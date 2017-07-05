package com.lth.student.modules.sys.servlet;

import com.lth.student.modules.sys.entity.SysUser;
import com.lth.student.modules.sys.service.ISysUserService;
import com.lth.student.modules.sys.service.impl.SysUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SysUserServlet extends HttpServlet {
    private ISysUserService sysUserService = new SysUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt.equals("list")) {
            list(req, resp);
        }else if (opt.equals("add")) {
            resp.sendRedirect("/sys_user_add.jsp");
        }else if (opt.equals("edit")) {
            edit(req, resp);
        } else if (opt.equals("insert")) {
            insert(req, resp);
        } else if (opt.equals("update")) {
            update(req, resp);
        } else if (opt.equals("delete")) {
            delete(req, resp);
        } else if (opt.equals("search")) {
            search(req, resp);
        }
    }
    /**
     * 用户列表页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<SysUser> sysUserList = sysUserService.findList();
        request.setAttribute("sysUserList",sysUserList);
        request.getRequestDispatcher("/sys_user_list.jsp").forward(request,response);
    }

    /**
     * 编辑用户页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SysUser sysUser = sysUserService.get(id);
        request.setAttribute("sysUser",sysUser);
        request.getRequestDispatcher("/sys_user_edit.jsp").forward(request,response);
    }

    /**
     * 新增用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insert(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        String loginPass = request.getParameter("loginPass");
        SysUser sysUser = new SysUser();
        sysUser.setLoginId(loginId);
        sysUser.setLoginPass(loginPass);
        sysUserService.insert(sysUser);

        //跳转到列表页
        list(request,response);
    }

    /**
     * 修改用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String loginId = request.getParameter("loginId");
        String loginPass = request.getParameter("loginPass");
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setLoginId(loginId);
        sysUser.setLoginPass(loginPass);
        sysUserService.update(sysUser);

        //跳转到列表页
        list(request,response);
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUserService.delete(sysUser);

        // 跳转页面
        list(request, response);
    }

    /**
     * 模糊查询用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void search(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<SysUser> sysUserList = sysUserService.findListByName(name == null ? "" : name);
        request.setAttribute("sysUserList",sysUserList);
        request.getRequestDispatcher("/sys_user_search.jsp").forward(request,response);

    }
}
