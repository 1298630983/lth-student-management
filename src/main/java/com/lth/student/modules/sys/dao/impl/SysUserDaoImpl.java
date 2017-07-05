package com.lth.student.modules.sys.dao.impl;

import com.lth.student.commons.persistent.CommonDao;
import com.lth.student.modules.sys.dao.ISysUserDao;
import com.lth.student.modules.sys.entity.SysUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SysUserDaoImpl extends CommonDao implements ISysUserDao {

    private static final String SQL_LOGIN = "SELECT * FROM sys_user WHERE loginId = ? AND loginPass = ?";
    private static final String SQL_GET = "SELECT * FROM sys_user WHERE id = ?";
    private static final String SQL_LIST = "SELECT * FROM sys_user";
    private static final String SQL_LIST_NAME = "SELECT * FROM sys_user WHERE loginId LIKE ?";

    public SysUser login(String loginId, String loginPass) {
        SysUser sysUser = null;
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_LOGIN,loginId,loginPass);
            sysUser = getSysUser(sysUser,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sysUser;
    }

    public SysUser get(int id) {
        SysUser sysUser = null;
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_GET, String.valueOf(id));
            sysUser = getSysUser(sysUser,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sysUser;
    }

    public List<SysUser> findList() {
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_LIST);
            if (resultSet != null) {
                while (resultSet.next()) {
                    SysUser sysUser = new SysUser();
                    sysUser.setId(resultSet.getInt("id"));
                    sysUser.setLoginId(resultSet.getString("loginId"));
                    sysUser.setLoginPass(resultSet.getString("loginPass"));
                    sysUsers.add(sysUser);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sysUsers;
    }

    /**
     * 封装用户属性
     * @param sysUser
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private SysUser getSysUser(SysUser sysUser,ResultSet resultSet) throws SQLException {
        if (resultSet != null){
            while (resultSet.next()){
                sysUser = new SysUser();
                sysUser.setId(resultSet.getInt("id"));
                sysUser.setLoginId(resultSet.getString("loginId"));
                sysUser.setLoginPass(resultSet.getString("loginPass"));

            }
        }
        return sysUser;
    }

    public List<SysUser> findListByName(String name) {
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        try {
            ResultSet resultSet = jdbcHelper.query(SQL_LIST_NAME, name.concat("%"));
            if (resultSet != null) {
                while (resultSet.next()) {
                    SysUser sysUser = new SysUser();
                    sysUser.setId(resultSet.getInt("id"));
                    sysUser.setLoginId(resultSet.getString("loginId"));
                    sysUser.setLoginPass(resultSet.getString("loginPass"));
                    sysUsers.add(sysUser);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sysUsers;
    }
}
