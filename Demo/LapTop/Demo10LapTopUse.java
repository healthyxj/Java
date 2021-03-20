package com.github.demo10;

public class Demo10LapTopUse {

    public static void main(String[] args) {
        Laptop computer = new Laptop();

        computer.powerOn();

        USB usb1 = new Mouse();
        usb1.open();
        USB usb2 = new Keyboard();
        usb2.open();

        computer.useDevice(usb1);
        computer.useDevice(usb2);

        computer.powerOff();

        usb1.close();
        usb2.close();
    }

}
