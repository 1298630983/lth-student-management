package com.lth.student.modules.student.dao.impl;

import com.lth.student.commons.persistent.CommonDao;
import com.lth.student.modules.student.dao.IStudentSystemDao;
import com.lth.student.modules.student.entity.StudentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentSystemDaoImpl extends CommonDao implements IStudentSystemDao {
    private static final String SQL_GET = "SELECT * FROM student_system WHERE id = ?";
    private static final String SQL_LIST = "SELECT * FROM student_system";

    public StudentSystem get(int id) {
        StudentSystem studentSystem = null;
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_GET, String.valueOf(id));
            studentSystem = getStudentSystem(studentSystem,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentSystem;
    }

    public List<StudentSystem> findList() {
        List<StudentSystem> studentSystems = new ArrayList<StudentSystem>();
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_LIST);
            if (resultSet != null) {
                while (resultSet.next()) {
                    StudentSystem studentSystem = new StudentSystem();
                    studentSystem.setId(resultSet.getInt("id"));
                    studentSystem.setStudent_name(resultSet.getString("student_name"));
                    studentSystem.setStudent_department(resultSet.getString("student_department"));
                    studentSystem.setStudent_competition(resultSet.getString("student_competition"));
                    studentSystem.setStudent_copyright(resultSet.getString("student_copyright"));
                    studentSystem.setStudent_patent(resultSet.getString("student_patent"));
                    studentSystem.setStudent_paper(resultSet.getString("student_paper"));
                    studentSystem.setStudent_project(resultSet.getString("student_project"));
                    studentSystems.add(studentSystem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentSystems;
    }

    /**
     * 封装学生属性
     * @param studentSystem
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public StudentSystem getStudentSystem(StudentSystem studentSystem,ResultSet resultSet)throws SQLException{
        if (resultSet != null){
            while (resultSet.next()){
                studentSystem = new StudentSystem();
                studentSystem.setId(resultSet.getInt("id"));
                studentSystem.setStudent_name(resultSet.getString("student_name"));
                studentSystem.setStudent_department(resultSet.getString("student_department"));
                studentSystem.setStudent_competition(resultSet.getString("student_competition"));
                studentSystem.setStudent_copyright(resultSet.getString("student_copyright"));
                studentSystem.setStudent_patent(resultSet.getString("student_patent"));
                studentSystem.setStudent_paper(resultSet.getString("student_paper"));
                studentSystem.setStudent_project(resultSet.getString("student_project"));
            }
        }
        return studentSystem;
    }
}
