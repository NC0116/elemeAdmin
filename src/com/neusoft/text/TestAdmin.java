package com.neusoft.text;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domin.Admin;

public class TestAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin= adminDao.getAdminByNameByPass("zhangsan","123");
        System.out.println(admin);

    }
}
