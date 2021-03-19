package com.github.demo07;

import java.util.ArrayList;

public class Manager extends User{
    //管理员也需要构造方法
    public Manager(){

    }

    public Manager(String name, int money){
        super(name, money); //由于是继承，这里用super来创建
    }

    //管理员发红包,参数是总金额和红包的个数
    public ArrayList<Integer> deliver(int totalmoney, int count){
        ArrayList<Integer> hongbao = new ArrayList<>();

        //首先，进行判断，如果要发送的金额大于余额，就发送失败
        int leftmoney = super.getLeftmoney();
        if(totalmoney > leftmoney){
            System.out.println("余额不足！");
            return hongbao; //返回一个空的红包
        }

        //扣钱
        super.setLeftmoney(leftmoney - totalmoney);

        //塞红包
        int avg = totalmoney / count;
        int mod = totalmoney % count;

        for (int i = 0; i < count - 1; i++) {
            hongbao.add(avg);
        }

        hongbao.add(avg + mod); //把剩余的钱塞到红包里

        return hongbao;
    }

}
