package com.neusoft;

import com.neusoft.domin.Admin;
import com.neusoft.domin.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewImpl;

import java.util.Scanner;

public class BusinessAdmin {
    public static void main(String[] args) {work();}
        public static  void  work(){
            Scanner input = new Scanner(System.in);

            System.out.println("-----------------------------------------------------------");
            System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
            System.out.println("-----------------------------------------------------------");

            // 调用登录方法
            BusinessView businessView = new BusinessViewImpl();
           Business business = businessView.login();

           if (business!=null){
                int menu = 0;
                System.out.println("~欢迎来到饿了么商家管理系统~");
                while (menu!= 5){

                    // 创建一个菜单
                    System.out.println("========= 一级菜单（商家管理）==1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
                    System.out.println("请选择相应的菜单编号");
                    menu = input.nextInt();
                    switch (menu){
                        case 1:

                            break;
                        case 2:


                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:
                            System.out.println("========= 欢迎下次光临饿了么系统 =========");
                            break;
                        default:
                            System.out.println("没有这个菜单项");
                            break;
                    }
                }
            }else {
                System.out.println("账号或密码有误请重新输入");
            }

        }

    }

