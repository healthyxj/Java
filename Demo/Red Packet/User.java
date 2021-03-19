package com.github.demo07;

public class User {
    private String name;
    private int leftmoney;  //表示余额

    public User() {
    }

    public User(String name, int leftmoney) {
        this.name = name;
        this.leftmoney = leftmoney;
    }

    public void show(){
        System.out.println("我是" + name + "， 我的余额是" + leftmoney);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeftmoney() {
        return leftmoney;
    }

    public void setLeftmoney(int leftmoney) {
        this.leftmoney = leftmoney;
    }
}
