package com.lidaxia.proxy.sta;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/25 19:26
 */
public class AdminServiceImpl implements AdminService{
    @Override
    public void update() {
        System.out.println("修改管理系统数据");
    }

    @Override
    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}
