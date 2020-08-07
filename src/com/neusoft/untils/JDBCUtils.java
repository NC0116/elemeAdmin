package com.neusoft.untils;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //定义成员变量DateSource, 可以切换不同的连接池
    private static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds =DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 连接
    public  static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    // close
    public static void close(Statement stmt, Connection conn, ResultSet rs){

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void close(Statement stmt, Connection conn){

        close(stmt, conn, null);

    }

    //


    public static DataSource getDs() {
        return ds;
    }
}
