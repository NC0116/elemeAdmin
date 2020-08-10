package com.neusoft.text;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.Impl.FoodImpl;
import com.neusoft.domin.Food;

import java.sql.SQLException;
import java.util.List;

public class TextFood {
    public static void main(String[] args){
        FoodDao dao = new FoodImpl();
        List<Food> list = dao.listFood(10001);
        for (Food food:list){
            System.out.println(food);
        }
    }
}
