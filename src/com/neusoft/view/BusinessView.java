package com.neusoft.view;

import com.neusoft.domin.Business;

public interface BusinessView {

    public void listBusinessAll();
    public void listBusinessBySearchAll();
    public void saveBusinessAll();
    public  void  deleteBusinessAll();

    //商家登录
    public Business login();
    //显示商家信息
    public void showBusinessInfo();
}
