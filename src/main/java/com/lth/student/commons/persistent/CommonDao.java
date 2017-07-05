package com.lth.student.commons.persistent;

import com.lth.student.commons.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CommonDao {
    protected JDBCHelper jdbcHelper = new JDBCHelper();

    public int insert(String sql,String... params){
        try {
            return jdbcHelper.executeSQL(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String sql,String... params){
        try {
            return jdbcHelper.executeSQL(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(String sql,String... params){
        try {
            return jdbcHelper.executeSQL(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet query(String sql, String... params) {
        try {
            return jdbcHelper.query(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
