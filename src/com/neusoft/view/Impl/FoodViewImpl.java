package com.neusoft.view.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.Impl.FoodImpl;
import com.neusoft.domin.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    @Override
    public void listFoodBySearchAll(Integer businessId) {
        Integer business = 0;

        FoodDao dao = new FoodImpl();
        List<Food> list = dao.listFood(businessId);
        System.out.println("食物编号\t\t食物名称\t\t食物介绍\t\t食物价格\t\t商家编号");
        for (Food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" + f.getFoodExplain() + "\t" + f.getFoodPrice() + "\t" + f.getBusinessId());
        }

    }

    @Override
    public void saveFood(Integer businessId) {
        Food fd = new Food();

        Scanner input= new Scanner(System.in);
        System.out.println("请输入食品名称：");
        fd.setFoodName(input.next());
        System.out.println("请输入食品介绍：");
        fd.setFoodExplain(input.next());
        System.out.println("请输入食品价格：");
        fd.setFoodPrice(input.nextDouble());
        fd.setBusinessId(businessId);
        FoodDao f = new FoodImpl();
        int i = f.saveFoodAll(fd);
        if (i>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao dao = new FoodImpl();
        Scanner input = new Scanner(System.in);
        List<Food> list = dao.listFood(businessId);
        if(list.size()==0) {
            System.out.println("没有任何食品！");
        }else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新食品价格(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(input.nextDouble());
            }

            int result = dao. updateFoodAll(food);
            if(result>0) {
                System.out.println("\n修改食品成功！\n");
            }else {
                System.out.println("\n修改食品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        FoodDao dao = new FoodImpl();
        List<Food> list = dao.listFood(businessId);
        for (Food food:list){
            System.out.println(food);
        }
        Scanner input = new Scanner(System.in);
        if(list.size()==0) {
            System.out.println("没有任何食品！");
        }else {
            System.out.println("请选择要删除的食品编号：");
            int foodId = input.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            if(input.next().equals("y")) {
                int result = dao.removeFoodAll(foodId);
                if(result>0) {
                    System.out.println("\n删除食品成功！\n");
                }else {
                    System.out.println("\n删除食品失败！\n");
                }
            }
        }
    }
}


