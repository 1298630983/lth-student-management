package com.lth.student.commons.jdbc;


import java.sql.*;

public class JDBCHelper {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "student";
    private static final String USERNAME = "root";
    private static final String PASSWROD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    private Connection connection;

    /**
     * JDBC构造器，用于数据库连接的初始化操作
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public JDBCHelper() {
        try {
            // 1.加载驱动程序
            Class.forName(DRIVER);
            // 2.获取数据库的连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWROD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行SQL的方法，用于增、删、改
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public int executeSQL(String sql, String... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 1 ; i <= params.length ; i++) {
                preparedStatement.setString(i, params[i - 1]);
            }
        }
        return preparedStatement.executeUpdate();
    }

    /**
     * 获取查询结果集
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public ResultSet query(String sql, String... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 1 ; i <= params.length ; i++) {
                preparedStatement.setString(i, params[i - 1]);
            }
        }
        return preparedStatement.executeQuery();
    }
}



