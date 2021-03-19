package com.github.demo07;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Random;

public class Member extends User{
    public Member(){

    }

    public Member(String name, int money){
        super(name, money);
    }

    //收红包
    public void receive(ArrayList<Integer> hongbao){
        Random r = new Random();

        //从多个红包中抽出一个给自己
        //得到红包个数，随机取值，获得
        int money = hongbao.remove(r.nextInt(hongbao.size()));

        //余额增加
        super.setLeftmoney(getLeftmoney() + money);
    }
}
