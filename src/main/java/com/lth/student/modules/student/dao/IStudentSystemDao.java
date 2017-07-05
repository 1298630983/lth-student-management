package com.lth.student.modules.student.dao;

import com.lth.student.modules.student.entity.StudentSystem;

import java.util.List;

/**
 * Created by 阳光里的时光梯 on 2016/10/22.
 */
public interface IStudentSystemDao {

    /**
     * 根据ID获取信息
     * @param id
     * @return
     */
    public StudentSystem get(int id);

    /**
     * 信息合集
     * @return
     */
    public List<StudentSystem> findList();

}
