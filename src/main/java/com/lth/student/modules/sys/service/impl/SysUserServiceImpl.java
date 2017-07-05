package com.lth.student.modules.sys.service.impl;

import com.lth.student.commons.persistent.CommonService;
import com.lth.student.modules.sys.dao.ISysUserDao;
import com.lth.student.modules.sys.dao.impl.SysUserDaoImpl;
import com.lth.student.modules.sys.entity.SysUser;
import com.lth.student.modules.sys.service.ISysUserService;

import java.util.List;


public class SysUserServiceImpl extends CommonService implements ISysUserService {

    private static final String SYS_USER_INSERT = "INSERT INTO sys_user (loginId ,loginPass)VALUES(?,?)";
    private static final String SYS_USER_UPDATE = "UPDATE sys_user SET loginId = ?,loginPass = ? WHERE id = ?";
    private static final String SYS_USER_DELETE = "DELETE FROM sys_user WHERE id = ?";

    private ISysUserDao sysUserDao = new SysUserDaoImpl();

    public SysUser login(String loginId, String loginPass) {
        return sysUserDao.login(loginId,loginPass);
    }

    public SysUser get(int id) {
        return sysUserDao.get(id);
    }

    public List<SysUser> findList() {
        return sysUserDao.findList();
    }

    public int insert(SysUser sysUser) {
        return insert(SYS_USER_INSERT,sysUser.getLoginId(),sysUser.getLoginPass());
    }

    public int update(SysUser sysUser) {
        return update(SYS_USER_UPDATE,sysUser.getLoginId(),sysUser.getLoginPass(), String.valueOf(sysUser.getId()));
    }

    public int delete(SysUser sysUser) {
        return delete(SYS_USER_DELETE, String.valueOf(sysUser.getId()));
    }

    public List<SysUser> findListByName(String name) {
        return sysUserDao.findListByName(name);
    }
}
