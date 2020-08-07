package com.neusoft.dao.Impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.domin.Admin;
import com.neusoft.untils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private  Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    @Override
    public Admin getAdminByNameByPass(String adminName, String possWord) {
        Admin ad =null;
            try{
                conn = JDBCUtils.getConnection();
                String sql="select * from admin where adminName = ? and password = ?";
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1,adminName);
              pstmt.setString(2,possWord);
              rs = pstmt.executeQuery();
              while (rs.next()){
                  ad = new Admin();
                  ad.setAdminId(rs.getInt("adminId"));
                  ad.setAdminName(rs.getNString("adminName"));
                  ad.setPossWord(rs.getNString("password" ));
              }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        return ad;
    }
}
