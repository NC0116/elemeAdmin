package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domin.Admin;
import com.neusoft.domin.Business;
import com.neusoft.untils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessImpl implements BusinessDao {
    Connection conn =null;
    PreparedStatement pstmt=null;
    ResultSet rs =null;

    @Override
    public List<Business> listBusiness() {
        ArrayList<Business> list = new ArrayList<>();

        try{
           conn = JDBCUtils.getConnection();
            String sql = "select * from business ";
          pstmt = conn.prepareStatement(sql);
           rs = pstmt.executeQuery();
          while (rs.next()){
              Business business = new Business();
              business.setBusinessId(rs.getInt("businessId"));
              business.setPassword(rs.getString("password"));
              business.setBusinessName(rs.getNString("businessName"));
              list.add(business);

          }

      } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        JDBCUtils.close(pstmt,conn,rs);
      }
      return list;
    }

    @Override
    public  List<Business> listBusinessBySearch(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%' ");
        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了商家名
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");
        }
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return list;
    }

    @Override
    public int saveBusiness(String businessName) {
        int businessId = 0;
        try{
            Connection conn = JDBCUtils.getConnection();
            String sql ="insert into  business(businessName,password) values(?,'123456')";
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,businessName);
            pstmt.executeUpdate();

            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                businessId = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return  businessId;
    }

    @Override
    public int deleteBusiness(Integer businessId) {
        int count = 0;
        try{

            Connection conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql ="delete from  business where  businessid= ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            count = pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            // 进入了异常的代码区要给result置为
            count =0;
            try{
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return count;
    }

    @Override
    public Business getBusinessByNameByPass(Integer businessId, String passWord) {
        Business business1 = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from business where businessId = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            pstmt.setString(2, passWord);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                business1 = new Business();
                business1.setBusinessId(rs.getInt("businessId"));
                business1.setPassword(rs.getString("password"));
                business1.setBusinessName(rs.getString("businessName"));
                business1.setBusinessAddress(rs.getString("businessAddress"));
                business1.setBusinessExplain(rs.getString("businessExplain"));
                business1.setStartPrice(rs.getDouble("starPrice"));
                business1.setDeliveryPrice(rs.getDouble("deliveryPrice"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn, rs);
        }

        return business1;
    }

    @Override
    public Business BusinessByBusinessId(Integer businessId) {
        Business business = null;
        ArrayList<Business> list= null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from business where businessId =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            rs = pstmt.executeQuery();
             list = new ArrayList<>();
            while (rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn, rs);
        }
        return business;
    }

    @Override
    public int updateBusiness(Business business) {
        int result = 0;
        String sql = "update business set businessName = ?, " +
                "businessAddress =?,businessExplain=?" +
                ",starPrice=?,deliveryPrice=? where businessId = ? ";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, business.getBusinessName());
            pstmt.setString(2, business.getBusinessAddress());
            pstmt.setString(3, business.getBusinessExplain());
            pstmt.setDouble(4, business.getStartPrice());
            pstmt.setDouble(5, business.getDeliveryPrice());
            pstmt.setInt(6, business.getBusinessId());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt, conn, rs);
        }
        return result;
    }

    @Override
    public int updateBusinessID(String password,Integer businessId) {
        int count = 0;
        try{
            Connection conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql ="update  business set password= ? where  businessId= ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, businessId);
            count = pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            // 进入了异常的代码区要给result置为
            count =0;
            try{
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return count;

    }


}




