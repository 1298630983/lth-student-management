package com.lth.student.modules.sys.dao;

import com.lth.student.modules.sys.entity.SysUser;

import java.util.List;


public interface ISysUserDao {

    /**
     * 登录
     * @param loginId
     * @param loginPass
     * @return
     */
    public SysUser login(String loginId,String loginPass);

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    public SysUser get(int id);

    /**
     * 用户集合
     * @return
     */
    public List<SysUser> findList();

    /**
     * 根据名字模糊查询用户
     * @param name
     * @return
     */
    public List<SysUser> findListByName(String name);

}
