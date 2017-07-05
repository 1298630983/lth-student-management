package com.lth.student.modules.student.service;

import com.lth.student.modules.student.entity.StudentSystem;

import java.util.List;

/**
 * Created by 阳光里的时光梯 on 2016/10/22.
 */
public interface IStudentSystemService {
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

    /**
     * 添加信息
     * @param studentSystem
     * @return
     */
    public int insert(StudentSystem studentSystem);

    /**
     * 删除信息
     * @param studentSystem
     * @return
     */
    public int delete(StudentSystem studentSystem);

    /**
     * 修改信息
     * @param studentSystem
     * @return
     */
    public int update(StudentSystem studentSystem);

    /**
     * 查询信息
     * @param studentSystem
     * @return
     */
    public List<StudentSystem> query(StudentSystem studentSystem);
}
