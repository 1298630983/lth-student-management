package com.lth.student.commons.persistent;

import java.sql.ResultSet;

/**
 * Created by 阳光里的时光梯 on 2016/10/22.
 */
public class CommonService {
    private CommonDao commonDao = new CommonDao();

    public int insert(String sql, String... params) {
        return commonDao.insert(sql, params);
    }

    public int delete(String sql, String... params) {
        return commonDao.delete(sql, params);
    }

    public int update(String sql, String... params) {
        return commonDao.update(sql, params);
    }

    public ResultSet query(String sql, String... params){
        return commonDao.query(sql,params);}
    }
