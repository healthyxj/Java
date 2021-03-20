package com.github.demo10;

public class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("键盘连接成功！");
    }

    @Override
    public void close() {
        System.out.println("键盘断开连接。");
    }

    public void type(){
        System.out.println("在键盘上打字");
    }
}
