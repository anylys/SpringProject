package com.anyly.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lishengrong
 */
public class OrderApplicationBoot {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/provider.xml"});
        context.start();
        System.out.println("Order Servuce publish successs!");
        System.in.read(); // 按任意键退出
    }
}
