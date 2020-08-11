package com.neusoft.dao;

import com.neusoft.domin.Admin;
import com.neusoft.domin.Business;

import java.util.List;

public interface BusinessDao {
    //管理员登录显示所有商家列表 可选输入businessName和businessAddress
    public List<Business> listBusiness();
    public  List<Business> listBusinessBySearch(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public int deleteBusiness(Integer businessId);
//商家登录操作
    public Business getBusinessByNameByPass(Integer businessId , String passWord);
    public  Business BusinessByBusinessId(Integer businessId);
    //修改商家信息
    public int updateBusiness(Business business);
    public int updateBusinessID(String password,Integer businessId);



}
