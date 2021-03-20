package com.github.demo10;

public class Laptop {
    public void powerOn(){
        System.out.println("打开笔记本电脑！");
    }

    public void powerOff(){
        System.out.println("关闭笔记本电脑。");
    }

    public void useDevice(USB usb){
        //usb.open();

        if(usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }else if(usb instanceof  Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            keyboard.type();
        }

        //usb.close();
    }
}
