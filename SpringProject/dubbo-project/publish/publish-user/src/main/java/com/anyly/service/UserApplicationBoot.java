package com.anyly.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lishengrong
 * 服务启动类 只做本地环境启动
 */
public class UserApplicationBoot {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/provider.xml"});
        context.start();
        System.out.println("User Servuce publish successs!");
        System.in.read(); // 按任意键退出
    }
}
