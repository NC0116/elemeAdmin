package com.neusoft.dao;

import com.neusoft.domin.Business;
import com.neusoft.domin.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    public List<Food> listFood(Integer businessId);


}
