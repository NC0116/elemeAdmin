package com.neusoft.dao;

import com.neusoft.domin.Business;
import com.neusoft.domin.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    public List<Food> listFood(Integer businessId);
    //新增食物
    public int   saveFoodAll(Food food);
    //修改食物
    public int  updateFoodAll(Food food);
    //删除食物
    public int  removeFoodAll(Integer foodId);
    public Food getFoodById(Integer foodId);
}
