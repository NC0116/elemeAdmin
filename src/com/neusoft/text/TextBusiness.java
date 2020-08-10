package com.neusoft.text;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessImpl;
import com.neusoft.domin.Business;

import java.util.List;

public class TextBusiness {
    public static void main(String[] args) {
       BusinessDao dao = new BusinessImpl();
//        List<Business> businesses = dao.listBusiness();
//        for (Business bus:businesses) {
//            System.out.println(businesses);
////        }
//        List<Business> list = dao.listBusinessBySearch("米饭","沈阳");
//        for (Business bs:list) {
//            System.out.println(bs);
//        }
       dao.getBusinessByNameByPass(10001,"123");

    }
}