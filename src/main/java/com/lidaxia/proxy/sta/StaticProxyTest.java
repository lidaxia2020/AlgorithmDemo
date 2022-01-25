package com.lidaxia.proxy.sta;

/**
 * 静态代理模式在不改变目标对象的前提下，实现了对目标对象的功能扩展。
 * 不足：
 *  静态代理实现了目标对象的所有方法，
 *  一旦目标接口增加方法，代理对象和
 *  目标对象都要进行相应的修改，增加维护成本。
 *
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/25 19:28
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy proxy = new AdminServiceProxy(adminService);
        proxy.update();
        System.out.println("=============================");
        proxy.find();
    }
}
