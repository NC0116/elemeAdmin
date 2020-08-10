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
        String inputStr="";
        String businessAddress="";
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
            if (list.equals(null)){
                System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
                for (Business b : list) {
                    System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
                }

            } else {
                System.out.println("太遥远了，信号连接不上......");
            }
    }
        @Override
        public void saveBusinessAll () {
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
        public void deleteBusinessAll () {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入商家编号:");
            int businessId = input.nextInt();
            System.out.println("确认要删除吗？（y/n）:");
            String in = input.next();
            if (in.equals("y")) {
                BusinessDao dao = new BusinessImpl();
                int i = dao.deleteBusiness(businessId);
                if (i >0){
                    System.out.println("删除商家成功！");
                }else{
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
        return dao.getBusinessByNameByPass( businessId,password);

    }

    @Override
    public void showBusinessInfo() {

    }


}