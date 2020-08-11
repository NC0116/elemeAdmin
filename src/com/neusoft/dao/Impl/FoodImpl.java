package com.neusoft.dao.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domin.Business;
import com.neusoft.domin.Food;
import com.neusoft.untils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodImpl implements FoodDao {
    PreparedStatement pstmt = null;
    Connection  conn = null;
    ResultSet rs=null;
    @Override
    public List<Food> listFood(Integer businessId)  {
        ArrayList<Food> list = new ArrayList<>();
        try{
             conn = JDBCUtils.getConnection();
            String sql = "select * from food  where businessId= ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            rs= pstmt.executeQuery();
            while (rs.next()){
                Food f = new Food();
                f.setFoodId(rs.getInt("foodId"));
                f.setFoodName(rs.getString("foodName"));
                f.setFoodExplain(rs.getString("foodExplain"));
                f.setFoodPrice(rs.getDouble("foodPrice"));
                f.setBusinessId(rs.getInt("BusinessId"));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);
        }
        return list;
    }

    @Override
    public int  saveFoodAll(Food food) {
        int  result= 0;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into  food values(null,?,?,?,?) ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,food.getFoodName());
            pstmt.setString(2,food.getFoodExplain());
            pstmt.setDouble(3,food.getFoodPrice());
            pstmt.setInt(4,food.getBusinessId());
          result= pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,null);
        }
        return result;
    }

    @Override
    public int updateFoodAll(Food food) {
        int  result= 0;

        try{
            conn = JDBCUtils.getConnection();
            String sql = " update food set foodName=?,foodExplain=?,foodPrice=? where foodId=?";
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,food.getFoodName());
            pstmt.setString(2,food.getFoodExplain());
            pstmt.setDouble(3,food.getFoodPrice());
            pstmt.setInt(4,food.getFoodId());
            result = pstmt.executeUpdate();
            // 获取自增长的列
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,null);
        }
        return result;
    }

    @Override
    public int  removeFoodAll(Integer foodId) {
        int  result= 0;
        try{
            conn = JDBCUtils.getConnection();
            String sql = " delete from food where foodId=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,foodId);
            result= pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,null);
        }
        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId=?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, foodId);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn, rs);
        }
        return food;

    }
}
