package com.neusoft.view.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.Impl.FoodImpl;
import com.neusoft.domin.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    @Override
    public void listFoodBySearchAll() {
        Integer business = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("是否输入商家编号查看食物（y/n）");
        String bh = input.next();
        if (bh.equals("y")) {
            System.out.println("请输入商家编号：");
            business = input.nextInt();
        } else {
            System.out.println("输入错误！");
        }
        FoodDao dao = new FoodImpl();
        List<Food> list = dao.listFood(business);
        System.out.println("食物编号\t\t食物名称\t\t食物介绍\t\t食物价格\t\t商家编号");
        for (Food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" + f.getFoodExplain() + "\t" + f.getFoodPrice() + "\t" + f.getBusinessId());
        }

    }

}