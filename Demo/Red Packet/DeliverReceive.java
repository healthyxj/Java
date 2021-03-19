package com.github.demo07;

import java.util.ArrayList;

public class DeliverReceive {
    public static void main(String[] args) {
        Manager manager = new Manager("管理员", 100);
        Member mem1 = new Member("张三", 0);
        Member mem2 = new Member("李四", 0);
        Member mem3 = new Member("王五", 0);
        Member mem4 = new Member("朱六", 0);

        manager.show();
        mem1.show();
        mem2.show();
        mem3.show();
        mem4.show();
        System.out.println("-----------------------------");

        ArrayList<Integer> hongbao = manager.deliver(25, 4);
        mem1.receive(hongbao);
        mem2.receive(hongbao);
        mem3.receive(hongbao);
        mem4.receive(hongbao);

        manager.show();
        mem1.show();
        mem2.show();
        mem3.show();
        mem4.show();

        //验证红包是否为空
//        for (int i = 0; i < hongbao.size(); i++) {
//            System.out.println(hongbao.get(i));
//            System.out.println("执行了");
//        }
    }
}
