package com.lth.student.modules.student.servlet;

import com.lth.student.modules.student.entity.StudentSystem;
import com.lth.student.modules.student.service.IStudentSystemService;
import com.lth.student.modules.student.service.impl.StudentSystemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class StudentSystemServlet extends HttpServlet {
    private IStudentSystemService studentSystemService =new StudentSystemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt.equals("list")){
            list(req,resp);
        }else if (opt.equals("add")) {
            resp.sendRedirect("/student_system_add.jsp");
        }else if (opt.equals("edit")) {
            edit(req, resp);
        } else if (opt.equals("insert")) {
            insert(req, resp);
        } else if (opt.equals("update")) {
            update(req, resp);
        } else if (opt.equals("delete")) {
            delete(req, resp);
        } else if (opt.equals("query")){
            query(req,resp);
        }else if (opt.equals("queryInfo")){
            resp.sendRedirect("/student_system_queryInfo.jsp");
        }else if (opt.equals("queryResult")){
            queryResult(req,resp);
        }
    }

    /**
     * 信息列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<StudentSystem> studentSystemList = studentSystemService.findList();
        request.setAttribute("studentSystemList",studentSystemList);
        request.getRequestDispatcher("/student_system_list.jsp").forward(request,response);
    }

    /**
     * 查询结果页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void queryResult(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/student_system_query.jsp").forward(request, response);
    }

    /**
     * 编辑信息页
     * @param request
     * @param response
     */
    private void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentSystem studentSystem = studentSystemService.get(id);
        request.setAttribute("studentSystem",studentSystem);
        request.getRequestDispatcher("/student_system_edit.jsp").forward(request,response);
    }

    /**
     * 新增信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insert(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String student_name = request.getParameter("student_name");
        String student_department = request.getParameter("student_department");
        String student_competition = request.getParameter("student_competition");
        String student_copyright = request.getParameter("student_copyright");
        String student_patent = request.getParameter("student_patent");
        String student_paper = request.getParameter("student_paper");
        String student_project = request.getParameter("student_project");
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.setStudent_name(student_name);
        studentSystem.setStudent_department(student_department);
        studentSystem.setStudent_competition(student_competition);
        studentSystem.setStudent_copyright(student_copyright);
        studentSystem.setStudent_patent(student_patent);
        studentSystem.setStudent_paper(student_paper);
        studentSystem.setStudent_project(student_project);
        studentSystemService.insert(studentSystem);

        //跳转到列表页
        list(request,response);
    }

    /**
     * 修改信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String student_name = request.getParameter("student_name");
        String student_department = request.getParameter("student_department");
        String student_competition = request.getParameter("student_competition");
        String student_copyright = request.getParameter("student_copyright");
        String student_patent = request.getParameter("student_patent");
        String student_paper = request.getParameter("student_paper");
        String student_project = request.getParameter("student_project");
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.setId(id);
        studentSystem.setStudent_name(student_name);
        studentSystem.setStudent_department(student_department);
        studentSystem.setStudent_competition(student_competition);
        studentSystem.setStudent_copyright(student_copyright);
        studentSystem.setStudent_patent(student_patent);
        studentSystem.setStudent_paper(student_paper);
        studentSystem.setStudent_project(student_project);
        studentSystemService.update(studentSystem);

        //跳转到列表页
        list(request,response);
    }

    /**
     * 删除信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.setId(id);
        studentSystemService.delete(studentSystem);

        //跳转到列表页
        list(request,response);
    }

    /**
     * 查询信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String student_name = request.getParameter("student_name");
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.setStudent_name(student_name);
        List<StudentSystem> studentSystems = studentSystemService.query(studentSystem);

        //跳转到查询页
        request.setAttribute("studentSystems",studentSystems);
        queryResult(request,response);
    }

}
