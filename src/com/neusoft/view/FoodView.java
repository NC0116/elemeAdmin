package com.neusoft.view;

import com.neusoft.domin.Food;

public interface FoodView {
    //查看食物列表
    public void listFoodBySearchAll(Integer businessId);
    //新增食物
    public void saveFood(Integer businessId);
    //修改食物
    public void updateFood(Integer businessId);
    //删除食物
    public void removeFood(Integer foodId);

}
