package com.lth.student.modules.sys.api;

import com.lth.student.modules.sys.entity.SysUser;
import com.lth.student.modules.sys.service.ISysUserService;
import com.lth.student.modules.sys.service.impl.SysUserServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class SysUserServletApi extends HttpServlet {
    private ISysUserService sysUserService = new SysUserServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        List<SysUser> sysUserList = new ArrayList<SysUser>();
        if (name != null && name.length() > 0) {
            sysUserList = sysUserService.findListByName(name);
        }
        PrintWriter out = resp.getWriter();
        out.println(objectMapper.writeValueAsString(sysUserList));
    }
}
