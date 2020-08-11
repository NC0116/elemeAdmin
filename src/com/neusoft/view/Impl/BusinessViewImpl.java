package com.neusoft.view.Impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.dao.Impl.BusinessImpl;
import com.neusoft.domin.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {


    @Override
    public void listBusinessAll() {
        BusinessDao dao = new BusinessImpl();
        List<Business> businesses = dao.listBusiness();
        for (Business business : businesses) {
            System.out.println(business);
        }

    }

    @Override
    public void listBusinessBySearchAll() {
        String businessName = "";
        String inputStr = "";
        String businessAddress = "";
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要输入商家名称关键字:（y/n）");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键字：");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(y/n): ");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键字：");
            businessAddress = input.next();
        }
        BusinessImpl dao = new BusinessImpl();
        List<Business> list = dao.listBusinessBySearch(businessName, businessAddress);
        if (list.equals(null)) {
            System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
            for (Business b : list) {
                System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
            }

        } else {
            System.out.println("太遥远了，信号连接不上......");
        }
    }

    @Override
    public void saveBusinessAll() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商家名称:");
        String businessName = input.next();
        BusinessDao business = new BusinessImpl();
        int businessId = business.saveBusiness(businessName);
        if (businessId > 0) {
            System.out.println("新建商家成功！ 商家编号为：" + businessId);
        } else {
            System.out.println("新建商家失败！");
        }

    }

    @Override
    public void deleteBusinessAll() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商家编号:");
        int businessId = input.nextInt();
        System.out.println("确认要删除吗？（y/n）:");
        String in = input.next();
        if (in.equals("y")) {
            BusinessDao dao = new BusinessImpl();
            int i = dao.deleteBusiness(businessId);
            if (i > 0) {
                System.out.println("删除商家成功！");
            } else {
                System.out.println("无此商家！");
            }

        } else {
            System.out.println("删除商家失败！");
        }


    }

    @Override
    public Business login() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商家编号：");
        Integer businessId = input.nextInt();
        System.out.println("请输入商家的密码：");
        String password = input.next();
        BusinessDao dao = new BusinessImpl();
//        Admin admin = dao.getAdminByNameByPass(adminName, password);
//        return admin;
        return dao.getBusinessByNameByPass(businessId, password);

    }

    @Override
    public void showBusinessInfo(Integer businessID) {
        BusinessDao dao = new BusinessImpl();
//        dao.g
        Business business = dao.BusinessByBusinessId(businessID);
        System.out.println(business);
    }

    @Override
    public void updateBusinessInfo(Integer businessID) {
        BusinessDao dao = new BusinessImpl();
//        dao.g
        Business business = dao.BusinessByBusinessId(businessID);
        System.out.println(business);
        Scanner input = new Scanner(System.in);
        String inputStr = null;
        System.out.println("是否修改商家名称（y/n）");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家姓名：");
            business.setBusinessName(input.next());
        }
        System.out.println("是否修改商家地址(y/n)：");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家地址：");
            business.setBusinessAddress(input.next());
        }
        System.out.println("是否修改商家介绍(y/n)：");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家介绍：");
            business.setBusinessExplain(input.next());
        }
        System.out.println("是否修改起送费(y/n)：");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的起送费：");
            business.setStartPrice(input.nextDouble());
        }
        System.out.println("是否修改配送费(y/n)：");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的配送费：");
            business.setDeliveryPrice(input.nextDouble());
        }
        int i = dao.updateBusiness(business);
        if (i > 0) {
            System.out.println("修改商家信息成功！");
        } else {
            System.out.println("修改商家信息失败！");
        }


    }
    //显示商家信息


//修改商


    @Override
    public void updateBusinessID(Integer businessID) {
        BusinessDao dao = new BusinessImpl();
//        dao.g
        Business business = dao.BusinessByBusinessId(businessID);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商家旧的密码:");
        String inputS = input.next();
        System.out.println("请输入商家新密码：");
        String in = input.next();
        System.out.println("请再次输入商家新密码:");
        String IN = input.next();
        if (!business.getPassword().equals(inputS)) {
            System.out.println("旧密码输入错误!");
        } else if (in.equals(IN)) {
            int i = dao.updateBusinessID(in, businessID);
            if (i > 0) {
                System.out.println("修改密码成功！");
            } else {
                System.out.println("修改密码失败！");
            }

        } else {
            System.out.println("两次密码输入不一致！");
        }


    }
}