# 一、Java概述

## 1、Java平台与工具包

Java三大平台

* JavaSE 标准版
* JavaEE 企业版
* JavaME 微型版

Java开发工具包(Java Development Kit)

Java可以做

* 面向对象的应用开发
* 网络应用程序的开发
* 计算过程的可视化
* 动态画面/交互操作
* Internet的系统管理
* 数据库操作

## 2、Java运行机制

Java三种核心机制

* Java虚拟机(Java Virtual Machine, JVM)
* 代码安全性检测(Code Security)
* 垃圾收集机制(Garbage collection)

### JVM

java程序经过**javac编译**后生成**字节码文件（bytecode）**，字节码文件与平台无关。

JVM 能够读取并处理编译过的字节码class文件。

Java虚拟机规范定义了： 

* 指令集 
* 寄存器集 
* 类文件结构 
* 堆栈 
* 垃圾收集堆 
* 内存区域

### JRE

JRE(java runtime environment) = JVM+API (lib)

JRE运行程序时主要有三项功能

* 加载代码：由class loader完成
* 校验代码：由bycode vertifier完成过
* 执行代码：由runtime interpreter完成

### 自动垃圾回收技术

Java语言自动垃圾回收 

* 系统级线程跟踪存储空间的分配情况 
* 在JVM的空闲时，检查并释放那些可被释放的存储器空间 
* 程序员无须也无法精确控制和干预该回收过程

## 3、JDK

JDK=JRE+Tools 

JRE=JVM+API

**开发**Java程序，需要下载JDK；**运行**Java程序，只需要下载JRE



JDK的工具：

* java编译器 javac.exe 
* java执行器 java.exe 
* 文档生成器 javadoc.exe 
* java打包器 jar.exe 
* java调试器 jdb.exe

## 4、Java与面向对象(object)

类(class)：有共同属性和行为的对象的集合

* 属性：变量(**字段, field**)
* 行为：函数(**方法, method**) 

类与对象的关系 

* 类是对象的抽象(模板) 
* 对象是类的实例

### 面向对象的三大特征

* 封装
  * **模块化**：将属性和行为封装在类中，程序定义很多类
  * **信息隐蔽**：将类的细节部分隐藏起来 用户只通过受保护的接口访问某个类
* 继承(inheritance)
  * 父类和子类之间共享数据和方法
  * 更好地进行抽象与分类，增强代码的**重用率**，提高**可维护性**
* 多态(polymorphism)
  * 不同的对象收到同一个消息（调用方法）可产生完全不同的效果，实现细节由接收对象自己决定

关键

* 有哪些对象类 
* 每个类有哪些属性、哪些方法 
* 类之间的关系（继承、关联等） 
* 对象之间发送消息（调用方法）

## 5、Java程序

### 1、Application和Applet程序

Java程序主要有Application和Applet程序。

**Application**是**独立**的程序，需要执行器也就是JVM来运行；Applet是嵌入在HTML网页中的非独立的程序(由专门的appletviewer来运行or由web浏览器调用Java虚拟机来运行)。

~~~java
//Application程序主体
public class HelloWorldApp{	//class是主体，public类名与文件同名
    public static void main(String args[]){
        System.out.println("Hello, world!");
    }
}
~~~

Applet已过时

### 2、JDK

JDK安装后的文件夹

* Bin 该目录存放工具文件 
* Jre 该目录存放与java 运行环境相关的文件  
  * 注：该 Jre与从http://java.com 下载的JRE略有区别 
* Demo 该目录存放一些示例文件 
* Include 该目录存放与C相关的头文件 
* Lib 该目录存放程序库 
* Db 数据库相关

### 3、编辑、编译和运行

程序编辑：编辑器

文件名要与public class的类名一致。区分大小写 

程序编译——转换为字节码（bytecode)文件，扩展名.class 

* （.class文件中包含 java虚拟机的指令） 
* 编译可以使用JDK工具javac.exe。 
* 如 javac Hello.java 

程序的运行——执行 .class文件中的指令的过程。 

如 java Hello 

(注意：不要写成 java Hello.class， 因为这里需要的是类名，不是文件名)

### 4、jar打包

语句

jar cvfm A.jar A.man A.class

c表示创建(create), v表示显示详情(verbose), f表示指定文件名, m表示清单文件。

A.man是清单文件(manifest)。

### 5、javaDoc生成文档

javadoc -d 目录名 xxx.java

/**/其中可以使用以下标记

* @author 对类的说明 标明开发该类模块的作者 
* @version 对类的说明 标明该类模块的版本 
* @see 对类、属性、方法的说明 参考转向，也就是相关主题 
* @param 对方法的说明 对方法中某参数的说明 
* @return 对方法的说明 对方法返回值的说明 
* @exception 对方法的说明 对方法可能抛出的异常进行说明

## 6、Java的API文档

在线(http://docs.oracle.com/javase/8/docs/api/index.html)或者chm格式(JDK_API_1_6_zh_CN.CHM)

## 7、输入和输出(重点！！！！！！)

可以有文本界面和图形界面。

### 文本界面

* 输入

输入使用scanner类，**scanner有nextInt()**方法，可以读入下一个整数。

~~~java
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int a = scanner.nextInt();
        System.out.println(a + "的平方为" + a * a);
    }
}
~~~

或者用**System.in.read()**读入

~~~java
import java.io.IOException;

public class AppCharInOut {
    public static void main(String[] args) {
        char c = ' ';
        System.out.println("请输入一个字符：");

        try{    //try catch是异常处理
            c = (char)System.in.read();
        }catch(IOException exception){}

        System.out.println("你输入了" + c);
    }
}
~~~

再或者用**IO流**读入

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppLineInOut {
    public static void main(String[] args) {
        String s;
        System.out.println("Please input something:");

        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
            System.out.println("Your word is " + s);    //要放在try内部
        }catch(IOException e){}

    }
}
~~~

其中

* InputStreamReader(System.in)能创建一个使用默认字符集的InputStremReader.

* ```java
  public BufferedReader(Reader in)
  //是创建一个使用默认大小输入缓冲区的缓冲字符输入流
  ```



* 输出

Java中主要是System.out.print和System.out.prinln。内容的输出主要是用**字符串拼接**。



### 图形界面

在图形界面下,可以

* 使用**文本框对象（TextField)** 获取用户输入的数据。 
* 使用**标签对象(Label)**或文本框对象输出数据。 
* 使用命令按纽(Button)来执行命令。

首先创建一个Frame，用它创建自己的用户界面。在构件AppFrame时，设定该frame的大小，并且使用setVisible(true)方法显示出来

~~~java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGraphicInOut {
    public static void main(String[] args) {
        new AppFrame();
    }
}

class AppFrame extends JFrame {
    JTextField in = new JTextField(10);
    JButton btn = new JButton("Yes, I'm sure!");
    JLabel out = new JLabel("Your input is ");

    public AppFrame(){
        setLayout(new FlowLayout());

        getContentPane().add(in);   //加入对象
        getContentPane().add(btn);
        getContentPane().add(out);

        btn.addActionListener(new BtnActionAdapter());  //处理事件
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class BtnActionAdapter implements ActionListener{
        public void actionPerformed(ActionEvent e){ //具体处理事件
            String s = in.getText();
            double d = Double.parseDouble(s);
            double sq = d * d;
            out.setText(d + "'s square is " + sq);
        }
    }
}
~~~

其中

* JTextfield是创建文本框，构造方法中可以输入整数，表示可以输入的列数，也就是一行能够有多少个单词

* JButton是创建按钮，构造方法中输入字符串表示是一个带文本的按钮；这个类的**addActionListener**的方法是发生**操作时调用**

* FlowLayOut()，创建一个新的FlowLayOut，居中对齐，默认水平和垂直间隙为5个单位

* ```java
  public int getDefaultCloseOperation()
  //返回用户在此窗体上发起close时执行的操作
  ```




# 二、数据运算、流程控制和数组

## 1、数据类型

Java中的数据类型主要分为基本数据类型(primitive types)和**引用数据类型(reference types)**。

数值型、字符型和布尔型都是基本数据类型，存放的是值。引用数据类型，例如类、接口、数组存放的是**地址**。

四类/八种基本数据类型

* 整数型
  * byte、short、int、long
* 浮点数型
  * float、double
* 逻辑型
  * **boolean**
* 字符型
  * char
  * Java字符采用Unicode编码，每个字符占2个字节
  * 可以使用十六进制编码形式表示，如char c1 = '\u0061'

~~~
转义符
• \ddd 1到3位八进制数所表示的字符(ddd)
• \uxxxx 1到4位十六进制数所表示的字符(xxxx)
• \' 单引号字符
• \" 双引号字符
• \\ 反斜杠字符
• \r 回车
• \n 换行
• \f 走纸换页
• \t 横向跳格
• \b 退格
~~~



