package com.github.demo10;

public class Mouse implements USB{

    @Override
    public void open() {
        System.out.println("鼠标连接成功！");
    }

    @Override
    public void close() {
        System.out.println("鼠标断开连接！");
    }

    public void click(){
        System.out.println("点击一次鼠标");
    }
}
