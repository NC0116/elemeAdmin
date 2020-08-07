package com.neusoft.dao;

import com.neusoft.domin.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName,String passWord);
    public Admin save(Integer id,String adminName,String passWord);
    public Admin update(Integer id,String adminName,String passWord);
    public Admin delete(Integer id);



}
