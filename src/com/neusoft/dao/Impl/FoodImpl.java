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
                f.setFoodPrice(rs.getInt("foodPrice"));
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
}
