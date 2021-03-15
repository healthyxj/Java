# 面向对象

面向过程：当需要实现一个功能的时候，每一个具体的步骤都要详细地处理细节。

面向对象，不需要考虑具体步骤，而是找一个已经具有该功能的模块来实现。

~~~java
package com.github.day01.demo04;

import java.util.Arrays;	//IDEA会自动导入

public class Demo04Compare {
    public static void main(String[] args) {
        //要求用[]输出一个数组里的内容
        int[] array = new int[]{155, 4566, 897, 46, 323};

        //面向过程的解决方法
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }

        System.out.println("----------------------------");

        //面向对象的解决方法
        System.out.println(Arrays.toString(array));
    }
}
~~~

面向对象更符合思考的习惯，可以将复杂事物简单化。面向对象的语言中包含了三大基本特征，封装、继承、多态。

## 1、类和对象的关系

类是一组<b>相关属性和行为</b>的集合，是一类事物的模板，使用事物的属性特征和行为特征来描述该类事物。

<b>属性是指事物的状态信息，行为是指该事物能够做什么</b>。例如，洗衣机的属性有质量、体积等等，洗衣机的行为有洗涤、干燥、消毒等等。

<b>类是对一类事物的描述，是总体的抽象的概念，对象是一类事物的具体实例</b>。类是对象的模板，对象是类的实体。

## 2、类的定义

加入定义一个类“学生”，那么“学生”这个类的属性有姓名、年龄，行为有吃饭、睡觉、学习。对应到java中是成员<b>变量</b>（属性）和成员<b>方法</b>（行为）。

<b>注意事项</b>

* 成员变量定义在类当中，成员方法外
* <b>成员方法不需要写static</b>
* 类中也不需要写public static void main(String[] args)

如下所示定义了一个学生类

~~~java
package com.github.day01.demo04;

public class Student {
    //定义成员变量
    String name;
    int name;

    //定义成员方法
    public void study(){
        System.out.println("学生需要学习！");
    }

    public void eat(){
        System.out.println("学生需要吃饭。");
    }

    public void sleep(){
        System.out.println("学生更需要睡觉！");
    }
}
~~~

通常情况下，类不能直接使用，需要根据类创建一个对象才能使用。

## 3、类的使用

具体步骤是

* 导包，即指出需要使用的，在什么位置
  * 格式： import 包名称.类名称. 如import  com.github.day01.Student
  * 对于和当前的类属于同一个包的情况下，可以省略导包语句
* 创建
  * 格式:	<b>类名称 对象名称 = new 类名称()</b>; 如 Student ZhangSan = new Student();
* 使用
  * 使用成员变量： 对象名.成员变量名
  * 使用成员方法： <b>对象名.成员方法名(参数)</b>

注意事项：如果成员变量没有进行赋值，将会有默认值，规则同数组。

~~~java
package com.github.day01.demo04;

//1、导包，要放在最外面
import com.github.day01.demo04.Student;

public class Demo04Student {
    public static void main(String[] args) {
        //2、创建
        Student stu1 = new Student();

        //3、使用成员变量
        System.out.println(stu1.name);
        System.out.println(stu1.age);

        System.out.println("-------------------");
        //对成员变量进行赋值
        stu1.name = "zhangsan";
        stu1.age = 21;

        System.out.println(stu1.name);
        System.out.println(stu1.age);

        //4、使用成员方法
        stu1.eat();
        stu1.sleep();
        stu1.study();
    }
}
~~~

以手机为类进行练习

~~~java
package com.github.day01.demo04;

//定义类不需要main和static
public class Phone {
    //1、定义成员变量
    String brand;
    double price;
    String color;

    //2、定义成员方法，也不需要static
    public void toWho(String who){
        System.out.println("给" + who + "打电话");
    }
    public void sendMessage(){
        System.out.println("群发了一条短信");
    }
}
~~~

使用手机

~~~java
package com.github.day01.demo04;

import com.github.day01.demo04.Phone;

public class Demo04Phone {
    public static void main(String[] args) {
        //2、创建对象
        Phone pho1 = new Phone();

        //3、使用成员变量
        System.out.println(pho1.brand); //null
        System.out.println(pho1.color); //null
        System.out.println(pho1.price); //0.0

        //给成员变量进行赋值
        pho1.brand = "荣耀";
        pho1.color = "蓝色";
        pho1.price = 4399.0;

        System.out.println("------------------");
        System.out.println(pho1.brand);
        System.out.println(pho1.color);
        System.out.println(pho1.price);

        //4、使用成员方法
        pho1.toWho("father");
        pho1.sendMessage();
    }
}
~~~


## 4、内存图

### 一个对象的内存图

成员变量和成员方法存储在堆中，成员方法指向了方法区中的成员方法。方法在栈中运行会入栈，运行结束时会立刻出栈。此后可以继续运行栈底的main函数，直到main函数结束。



### 两个对象的内存图

方法区最先有内容。首先把类对象(包括成员变量和成员方法)存储到方法区中。程序继续执行，将main放入到栈中，main进入到栈中，按内容进行执行。

main中new了一个对象，对象存储在堆当中。对象中的成员变量有默认值，成员方法是指向方法区中成员方法的地址值。存储在堆中的对象自己的地址会被复制存储在栈中的main里。

程序继续执行，遇到方法则将方法存储到栈中。方法执行完则出栈。继续运行，可能会遇到下一个方法。



~~~java
package com.github.day01.demo04;

import com.github.day01.demo04.Phone;

public class Demo04Phone {
    public static void main(String[] args) {
        //2、创建对象
        Phone pho1 = new Phone();

        //3、使用成员变量
        System.out.println(pho1.brand); //null
        System.out.println(pho1.color); //null
        System.out.println(pho1.price); //0.0

        //给成员变量进行赋值
        pho1.brand = "荣耀";
        pho1.color = "蓝色";
        pho1.price = 4399.0;

        System.out.println("------------------");
        System.out.println(pho1.brand);
        System.out.println(pho1.color);
        System.out.println(pho1.price);

        //4、使用成员方法
        pho1.toWho("father");
        pho1.sendMessage();

        //2、创建对象
        Phone pho2 = new Phone();

        //给成员变量进行赋值
        pho2.brand = "redmi";
        pho2.color = "粉色";
        pho2.price = 2199.0;

        System.out.println("------------------");
        System.out.println(pho2.brand);
        System.out.println(pho2.color);
        System.out.println(pho2.price);

        //4、使用成员方法
        pho2.toWho("mother");
        pho2.sendMessage();
    }
}
~~~

### 两个引用指向同一个对象的内存图

![](https://github.com/healthyxj/Java/blob/main/images/%E4%B8%A4%E4%B8%AA%E5%BC%95%E7%94%A8%E6%8C%87%E5%90%91%E5%90%8C%E4%B8%80%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%86%85%E5%AD%98%E5%9B%BE.png)

## 5、局部变量和成员变量的区别

主要有

* 定义的位置不同【重点】

  * 局部变量定义在**方法内部**
  * 成员变量定义在**方法外部**，直接写在类当中
* 作用范围不一样【重点】
  * 局部变量：只有在方法中才可以使用
  * 成员变量：整个类都可以使用
* 默认值不一样【重点】
  * 局部变量：没有默认值；使用前必须手动赋值
  * 成员变量：会自带默认值，规则和数组一样
* 内存位置不一样
  * 局部变量：位于栈内存中
  * 成员变量：位于堆内存中
* 生命周期不一样
  * 局部变量：随方法进栈而诞生，随方法出栈而消失
  * 成员变量：随对象的产生而诞生，随对象被垃圾回收而消失

## 6、封装

封装的体现

* 方法就是一种封装
* 关键字private也是一种封装

~~~java
package com.github.demo;

public class encapusalation {
    public static void main(String[] args) {
        int[] arrayA = {10, 15, 25, 35};
        System.out.println(Max(arrayA));
    }

    public static int Max(int[] array){
        int Max = array[0];

        for (int i = 1; i < array.length; i++) {
            if(array[i] > Max){
                Max = array[i];
            }
        }
        return Max;
    }
}
~~~

### private引导的封装

定义一个Person类

~~~java
package com.github.demo01;

public class Person {
    int age;
    String name;

    public void show(){	//不用static
        System.out.println("我是" + name + "， 我" + age + "岁了。");
    }
}
~~~

创建一个对象，修改对象的name和age

~~~java
package com.github.demo01;

public class PrivateName {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        person.name = "三观";
        person.age = 20;    
        person.show();

    }
}
~~~

如果在Person类中修改为private int age，就无法在新的对象中进行修改了。private体现了一种封装的特性。只有在本类中才可以访问，超出本类范围就不能直接访问了。

如果需要**间接访问private成员变量**，就需要**setter/getter方法**

~~~java
package com.github.demo01;

public class Person {
    private int age;
    String name;

    public void show(){
        System.out.println("我是" + name + "， 我" + age + "岁了。");
    }
    
	//定义了方法，用于设定年龄
    public void setAge(int num){
        if(num < 120 && num > 0){
            age = num;
        }else{
            System.out.println("你输入了错误的年龄");
        }
    }

    //定义方法用于返回年龄
    public int getAge(){
        return age;
    }
}
~~~

输出姓名和年龄的程序

~~~java
package com.github.demo01;


public class PrivateName {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        person.name = "三观";
        person.setAge(-1);
        person.show();

    }
}
~~~

注意private对应的设置必然有set和get两种形式，但是对于boolean类型的get换成了is

### this关键字的作用

在之前的student中添加下面这方法

~~~java
   public void sayhello(String name){
        System.out.println(name + ", 你好！ " + "我是" + this.name);
        System.out.println(this);
    }
~~~

加入形参与成员变量名一致，需要添加**this加以区分**。其中，this和自己定义的对象的地址相同

~~~java
package com.github.demo01;

public class Demo01SayHello {
    public static void main(String[] args) {
        Student person = new Student();
        person.setName("李四");
        person.sayhello("张三");
        System.out.println(person);
        /*
        张三, 你好！ 我是李四
com.github.demo01.Student@6e8cf4c6	这是this的地址值
com.github.demo01.Student@6e8cf4c6	这是person的地址值
        */
    }
}
~~~

## 7、构造方法

构造方法是专门用于创建对象法方法，new就是一个构造方法的过程。

格式

public 类名称(参数类型 参数名称){

​		方法体

}

注意事项

* 构造方法要求与类的名称一致
* 构造方法**不能写返回值类型**，void也不写
* 构造方法**不能return**一个具体的返回值
* 如果没有编写任何构造方法，编译器将会默认赠送一个方法，只有方法的框架，没有方法的内容

例如构造一个学生类

~~~java
public class Student{
    //定义成员变量
    private int name;
    private String name;
    
    //定义无参构造方法
    public Student(){
        System.out.println("无参构造方法调用了！");
    }  
    
    //定义全参构造方法
    public Student(int age, String name){
        System.out.println("全参构造方法调用了！");
        this.name = name;
        this.age = age;
    }
    
    //Setter
    public void setAge(int age){
        this.age = age;
    }
    
    //Getter
    public int getAge(){
        return age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
~~~

创建一个新的对象

~~~java
public static void main(String[] args){
    Student stu1 = new Student();
    Student stu2 = new Student("张三", 20);
    System.out.println("姓名：" + stu2.getName() + "年龄：" + stu2.getAge());
}
~~~

## 8、标准的类

一个标准的类通常由4部分组成

* 所有的成员变量都要使用private关键字修饰
* 需要为每一个成员变量编写一对getter/setter方法
*  编写一个无参数的构造方法
* 编写一个有参数的构造方法

code-generate-getter and setter，按shift进行全选

code-generate-constructor，select none构造无参数的方法

