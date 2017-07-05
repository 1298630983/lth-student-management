package com.lth.student.modules.student.service.impl;

import com.lth.student.commons.persistent.CommonService;
import com.lth.student.modules.student.dao.IStudentSystemDao;
import com.lth.student.modules.student.dao.impl.StudentSystemDaoImpl;
import com.lth.student.modules.student.entity.StudentSystem;
import com.lth.student.modules.student.service.IStudentSystemService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSystemServiceImpl extends CommonService implements IStudentSystemService {

    private static final String STUDENT_SYSTEM_INSERT = "INSERT INTO student_system (student_name,student_department,student_competition,student_copyright,student_patent,student_paper,student_project)VALUES(?,?,?,?,?,?,?)";
    private static final String STUDENT_SYSTEM_UPDATE= "UPDATE student_system SET  student_name= ?, student_department= ? ,student_competition = ? ,student_copyright=?,student_patent=? ,student_paper = ?,student_project=? WHERE id = ?";
    private static final String STUDENT_SYSTEM_DELETE = "DELETE FROM student_system WHERE id = ?";
    private static final String STUDENT_SYSTEM_QUERY = "SELECT * FROM student_system WHERE student_name = ?";

    private IStudentSystemDao studentSystemDao = new StudentSystemDaoImpl();

    public StudentSystem get(int id) {
        return studentSystemDao.get(id);
    }

    public List<StudentSystem> findList() {
        return studentSystemDao.findList();
    }

    public int insert(StudentSystem studentSystem) {
        return insert(STUDENT_SYSTEM_INSERT,studentSystem.getStudent_name(),studentSystem.getStudent_department(),studentSystem.getStudent_competition(),studentSystem.getStudent_copyright(),studentSystem.getStudent_patent(),studentSystem.getStudent_paper(),studentSystem.getStudent_project());
    }

    public int delete(StudentSystem studentSystem) {
        return delete(STUDENT_SYSTEM_DELETE, String.valueOf(studentSystem.getId()));
    }

    public int update(StudentSystem studentSystem) {
        return update(STUDENT_SYSTEM_UPDATE,studentSystem.getStudent_name(),studentSystem.getStudent_department(),studentSystem.getStudent_competition(),studentSystem.getStudent_copyright(),studentSystem.getStudent_patent(),studentSystem.getStudent_paper(),studentSystem.getStudent_project(), String.valueOf(studentSystem.getId()));
    }

    public List<StudentSystem> query(StudentSystem studentSystem) {
        List<StudentSystem> studentSystems = new ArrayList<StudentSystem>();
            try {
                ResultSet resultSet = query(STUDENT_SYSTEM_QUERY,studentSystem.getStudent_name());
                if (resultSet != null) {
                    while (resultSet.next()) {
                        StudentSystem student = new StudentSystem();
                        student.setId(resultSet.getInt("id"));
                        student.setStudent_name(resultSet.getString("student_name"));
                        student.setStudent_department(resultSet.getString("student_department"));
                        student.setStudent_competition(resultSet.getString("student_competition"));
                        student.setStudent_copyright(resultSet.getString("student_copyright"));
                        student.setStudent_patent(resultSet.getString("student_patent"));
                        student.setStudent_paper(resultSet.getString("student_paper"));
                        student.setStudent_project(resultSet.getString("student_project"));
                        studentSystems.add(student);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        return studentSystems;
    }
}
