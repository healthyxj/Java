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
  * byte、short、int、long(依次占1、2、4、8个字节)
  * 八进制整数以0开头，十六进制数以0x开头
  * 整型常量默认是int类型的，声明long类型要在后面增加一个L
  * Java中没有无符号数
* 浮点数型
  * float占4个字节，double占8个字节
  * 浮点常量默认是double类型的
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



## 2、标识符(identifier)

名字就是标识符：任何一个变量、常量、方法、对象和类都需要有名字

标识符满足的要求

* 标识符可以由字母、数字和下划线(_)、美元符号($)组合而成
* 标识符必须**以字母、下划线或美元符号**开头，不能以数字开头
* 最好与其意义相符，以增加程序的可读性

类名首字母要大写(Pascal)，其余的首字母小写(camel)

少用下划线，变量、常量随用随定义。

## 3、运算符和表达式

基本与c语言类似，多了字符串连接运算符。

**^不是乘方**

运算符分为

* 算术运算符
  * 整除/
* 关系运算符
* 逻辑运算符
  * ! 逻辑非 	& 逻辑与	| 逻辑或
  * **短路逻辑运算符&& 和||**，表示第一个操作数能确定整体的状态就不对第二个操作数进行判断
* 位运算符
  * ~取反、^按位异或
  * 左移：a<<b 将二进制的a逐位左移b位，空出的补0
  * 右移a >> b 将二进制的a逐位右移b位，最高位补原来的符号位
  * 无符号右移a >>> b 将二进制的a逐位右移b位，最高位补0
* 赋值运算符
  * =两侧类型不一致，会发生类型转换
* 字符串连接运算符
  * 只要+运算符的两侧**有一个是字符串**，就会将另一个操作数转换为字符串进行拼接

## 4、表达式

表达式的值的数据类型就是表达式的类型。

类型转换

*  int->long->float->double
* 所有的byte, short, char 参与算术运算等**转为int**

## 5、注释

// 用于单行注释，/* ……*/ 用于多行注释， /** …… */是Java特有的doc注释

JavaDoc中常用的标记

* @see：引用其他类。 
* @version：版本信息。 
* @author：作者信息。 
* @param：参数名说明。 
* @return：说明。 
* @exception：异常说明。

## 6、数组

声明的方式：方括号写到变量名之前，也可以写到变量名之后。

注意**数组定义与为数组分配空间是分开**进行的。

数组有静态初始化和动态初始化。

静态初始化

* 在定义数组的同时就为数组元素分配空间并赋值
  * 例如int[] a = new int[]{ 3, 9, 8,  };	也可以简化地写成int[] a = {3, 9, 8, };



默认初始化

* 数组一经分配空间，其中的每个元素就按照成员变量的方式进行了隐式初始化。
  * int[] a = new int[5];	表示为数组分配了空间，并且其中的元素均为0

数组可以按照元素进行索引，并且有属性length表示数组的长度。

数组可以进行复制

System.arraycopy方法提供了数组元素复制的功能

~~~java
int[] source = {1, 2, 3, 4, 5, 6};
int[] dest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
System.arraycopy(source, 0, dest, 0, source.Length);
~~~



## 7、增强的for语句

例如

~~~java
int[] ages = new int[10];

for(int age : ages){
    System.out.println(age);
}
~~~

这种语句是只读式的遍历



## 8、二维数组

二维数组就是数组的数组。



~~~java
public class Rnd7Of36 {
    public static void main(String[] args)
    {
        int a[] = new int[7];
        for( int i=0;i<a.length;i++)
        {
            one_num:
            while(true)
            {
                a[i] = (int)( Math.random()*36 ) +1;

                for( int j=0;j<i;j++ ){
                    if( a[i]==a[j] ) continue one_num;
                }
                break;
            }
        }
        for( int num: a) System.out.print( num+" " );
        System.out.println();
    }
}
~~~

# 三、类、包和接口

## 1、类

类包括了字段和方法。

* 字段(field)
  * 类的属性，是用变量来表示的
* 方法(method)
  * 类的功能和操作, 是用函数来表示的

### 构造方法

**构造方法(constructor)**是一种特殊的方法，用于初始化该类的一个新的对象。

构造方法与类名同名，不写返回数据类型。

~~~java
Person(String name, int a){
    name = "Amiya";
    age = 18;
}
~~~

如果没有定义任何构造方法，系统会自动产生一个构造方法，**默认构造方法**(default constructor)

默认构造方法不带参数，并且方法体为空。

### 使用对象

访问对象的字段或方法，需要使用算符"."

### 方法重载

方法重载(overloading)，指多个方法有相同的名字，编译时能识别出来。方法的签名(signature)不同，参数列表不同。

通过方法重载可以实现多态(polymorphism)

~~~java
class MethodOverloadingTest
{
	public static void main( String[] argv ){
		Person p1 = new Person("Tom", 20);
		Person p2 = new Person("Marry", 18);
		p1.sayHello();
		p1.sayHello(p2);
	}
}
class Person
{
	String name;
	int age;
	Person( String name, int age ){
		this.name = name;
		this.age = age;
	}

	void sayHello(){
		System.out.println("Hello! My name is " + name );
	}

	void sayHello( Person another ){
		System.out.println("Hello, " + another.name + "! My name is " + name );
	}

}
~~~

### this的使用

* 方法和构造方法中使用this来访问字段及方法。

* this可以解决局部变量和域同名的问题。

~~~java
Person(int age, String name){
    this.age = age;
    this.name = name;
}
~~~

* 在构造方法中，可以使用this来调用另一个构造方法。但是调用时必须要放在第一句。

## 2、继承

继承(inheritance)是面向对象的程序设计的重要特征之一。

Java支持单继承，一个类只能有**一个直接父类**。

子类能够继承父类的状态和行为，使用**extends实现**。没有extends语句，该类默认是java.lang.Object类的，这一个类也是祖宗类。

* 能够修改父类的状态或重载父类的行为
* 可以添加新的状态和行为。

---

可以对字段和方法进行继承

### 字段的继承

子类可以继承父类的所有字段。也可以添加一些父类没有的字段。



### 方法的继承

方法可以直接继承，也可以覆盖重写。



### 使用super

覆盖父类的同名方法的同时，又要**调用父类**的方法，就必须使用super。

但是构造方法不能继承。只能用super来调用父类的构造方法，同样构造方法要放在第一句。

## 3、包

包是为了解决名字空间、名字冲突的。实际上，一个子类与其父类可以位于不同的包中。

Java的JDK提供了很多包。为了能够使用Java中的类，需要使用导包语句。import



## 4、访问控制符

modifier分为访问修饰符(access modifiers)和其他修饰符(例如abstract)。

|           | 同一个类中 | 同一个包中 | 不同包中的子类 | 不同包中的非子类 |
| :-------: | :--------: | :--------: | :------------: | :--------------: |
|  private  |    Yes     |            |                |                  |
| (default) |    Yes     |    Yes     |                |                  |
| protected |    Yes     |    Yes     |      Yes       |                  |
|  public   |    Yes     |    Yes     |      Yes       |       Yes        |

使用private修饰符进行修饰，能更好地将信息进行封装和隐藏。相应地，就需要使用**setter和getter**进行存取。



## 5、其他修饰符



|          | 基本含义               | 修饰类           | 修饰成员 | 修饰局部变量 |
| -------- | ---------------------- | ---------------- | -------- | ------------ |
| static   | 静态的、非实例的、类的 | 可以修饰内部的类 | Yes      |              |
| final    | 最终的、不可改变的     | Yes              | Yes      | Yes          |
| abstract | 抽象的、不可实例化的   | Yes              | Yes      |              |

### static

~~~java
class Person{
    static long totalNum;
    int age;
    String name;
}
~~~

totalNum代表人类的总人数，它与具体对象实例无关。可以有两种方法来 访问：Person.totalNum和p.totalNum (假定p是Person对象)

一定意义上，可以表示全局变量。

~~~
注意
1)非static的方法是属于某个对象的方法，在这个对象创建时，对象的方法在内存中拥有自己专用的代码段。而static的方法是属于整个类的，它在内存中的代码段将随着类的定义而进行分配和装载，不被任何一个对象专有。
2)static方法只能处理本类中的static域或调用static方法。
3)static方法中，不能访问实例变量，不能使用this 或super。
4)调用static方法时，要用类名直接调用。
~~~

### final

* 如果一个类被final修饰符所修饰和限定，说明这个类**不能被继承**，即不可能有子类。
* final修饰符所修饰的方法，是**不能被子类所覆盖**的方法
* final字段、final局部变量(方法中的变量) ，它们的值一旦给定，就不能更改。 是只读量，它们能且**只能被赋值一次**，而不能被赋值多次。
* 一个字段被static final两个修饰符所限定时，它可以表示常量，如果不赋值，就会按照默认情况进行初始化。



### abstract

抽象方法的作用在为所有子类定义一个统一的接口。对**抽象方法只需声明，而不需实现**，即用分号（；）而不是用{}

抽象方法在子类中必须被实现，否则子类仍然是abstract的

## 6、接口

接口是某种特征的约定。

public abstract interface定义接口。用implements来实现接口。



## 7、枚举

enum 类{a, b, c, d}

~~~java
enum Light{Red, Yellow, Grey, Blue}
Light light = Light.Red;
switch(light){
    case Red:
        System.out.println("The light is Red!");
        break;
    case Blue:
        break;
}
~~~



# 四、深入理解Java语言

## 1、变量及其传递

变量有基本类型(primitive type)和引用类型(reference type)。基本类型的值直接存在于变量中，而引用类型的变量除占据一定的内存空间外，所引用的对象实体也要占据一定的空间。

~~~java
public class Mydate {
    int year;
    int month;
    int day;

    public Mydate() {
    }

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addYear(int n){
        year = year + n;
    }

    public void display(){
        System.out.println(year + "-" + month + "-" + day);
    }
}
~~~

~~~java
public class addYear {
    public static void main(String[] args) {
        Mydate mydate = new Mydate(2021, 4, 17);
        Mydate n = mydate;

        n.addYear(5);
        n.display();
        mydate.display();
    }
}
~~~



### 字段变量与局部变量

字段变量field和局部变量local variable，前者在类中，后者在方法中定义的变量或是方法的变量。

* 存储位置看，字段变量为对象的一部分，存在于堆中，而局部变量存在于栈中
* 生命周期不同
* 初始值，字段变量可以自动赋初值，局部变量需要显式赋值
* 语法角度，字段变量属于类，**局部变量不能被static修饰**，都可以被final进行修饰

对于引用型变量，传递的值是引用值，而不是复制对象实体，因此对于引用型的变量传递可以修改对象的属性

~~~java
public class TransByValue {
    public static void main(String[] args) {
        int a = 0;
        modify(a);
        System.out.println(a);  //0

        int[] b = new int[1];
        modify(b);
        System.out.println(b[0]);   //1
    }

    public static void modify(int a){
        a++;
    }

    public static void modify(int[] b){
        b[0]++;
        b = new int[5];
    }
}
~~~



## 2、多态和虚方法调用

多态(Polymorphism)是一个程序中相同的名字表示不同的含义的情况。

多态的两种情形

* 编译时多态
  * 重载overload
* 运行时多态
  * 覆盖override
  * 动态绑定(dynamic binding)-虚方法调用(virtual method invoking)

### 上溯造型(upcasting)

将派生类当作基本类进行处理。

例如 Person p = new Student();

### 虚方法调用

虚方法调用时，可以实现运行时的多态。

子类重载父类方法，运行时根据调用该方法的实例的类型决定选择哪个方法调用。

~~~java
class Shape
{
	void draw(){ System.out.println("Shape Drawing"); }
}
class Circle extends Shape
{
	void draw(){ System.out.println("Draw Circle"); }
}

class Triangle extends Shape
{
	void draw(){ System.out.println("Draw Three Lines"); }
}

class Line extends Shape
{
	void draw(){ System.out.println("Draw Line"); }
}
~~~

~~~java
public class TestVirtualInvoke {
    public static void main(String[] args) {
        Circle c = new Circle();
        Triangle t = new Triangle();
        Line l = new Line();

        dostuff(c);
        dostuff(t);
        dostuff(l);
    }

    public static void dostuff(Shape s){
        s.draw();
    }
}
~~~

三种非虚方法

* static，以声明的类型为准，与实例无关
* private方法，子类看不见，不会被虚化
* final方法子类不能覆盖，不存在虚化的问题

在之前的类的方法中增加static

~~~java
public class TestStaticInvoke {
    public static void main(String[] args) {
        StaticCircle c = new StaticCircle();
        StaticLine l = new StaticLine();
        StaticTriangle t = new StaticTriangle();

        dostuff(c); //Static Shape drawing!
        dostuff(l); //同上
        dostuff(t); //同上

        StaticShape s = new StaticCircle();
        dostuff(s); //同上
        s.draw();   //同上

        StaticCircle c2 = new StaticCircle();
        c2.draw();  //Static Circle drawing!

    }

    static void dostuff(StaticShape s){
        s.draw();
    }
}
~~~

可见**添加了static后，此时方法的调用参照的是左边的声明**。

### 动态类型确定

使用instanceof类型，结果为boolean

~~~java
public class instanceOf {
    public static void main(String[] args) {
        Object[] num = new Object[3];
        num[0] = new Integer(5);
        num[1] = new Double(3.14);
        num[2] = new String("Hello, world");

        double sum = 0;

        for (int i = 0; i < 3; i++) {
            if(num[i] instanceof Integer){
                sum += ((Integer)num[i]).intValue();
            }else if(num[i] instanceof Double){
                sum += ((Double)num[i]).doubleValue();
            }
        }

        System.out.println(sum);

    }
}
~~~

## 3、对象构造与初始化

构造方法（constructor) ，对象都有构造方法，如果没有，编译器加一个default构造方法。

调用本类或父类的构造方法

* this调用本类的其他构造方法
* super调用直接父类的构造方法
* this或super要放在第一条语句,且只能够有一条

~~~java
public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("In Person(String name, int age)");
    }
}
~~~

~~~java
public class Student extends Person{
    String school;

    public Student(){
        this(null, 0, null);
        System.out.println("In Student()");
    }

    public Student(String name, int age, String school){
        super(name, age);
        this.school = school;
        System.out.println("In Student(String, int, String)");
    }
}
~~~

~~~java
public class Graduate extends Student{
    String teacher = " ";
    public Graduate(){
        System.out.println("In Graduate()");
    }
}
~~~

~~~java
public class ContructCallThisAndSuper {
    public static void main(String[] args) {
        Person p = new Graduate();
        /*
        结果：先是构造祖先类
        In Person(String name, int age)
        In Student(String, int, String)
        In Student()
        In Graduate()
         */
    }
}
~~~



注意

~~~java
class A{
    void A(int a){
        
    }
}

class B extends A{
    void B(String s){
        
    }
}
~~~

这样的情况不会通过，因为会自动调用B(String s){super();}出错 

解决方法

* 在B的构造方法中,加入super(3); 
* 在A中加入一个不带参数的构造方法,A(){} 
* 去掉A中全部的构造方法,则编译器会自动加入一个不带参数的构造方法,称为默认的构造方

### 创建对象时初始化

Person p = new Person{{age = 18; name = "李明";}};

可以针对没有相应构造函数，但又需要赋值的情况



### 实例初始化与静态初始化

实例初始化，先于构造方法{}中的语句执行。静态初始化只在第一次使用这个类时执行。**静态初始化总是先于实例初始化**

实例初始化{语句}

静态初始化{static 语句}

顺序是

1)调用本类或父类的构造方法，直至最高一层（Object）

2)按照声明顺序执行字段的初始化赋值

3)执行构造函数中的各语句

~~~java
public class InitialTest1 {
    int n = 10;

    {
        n++;
        System.out.println("InitialTest1: " + n);
    }

    static int x;
    static {
        x++;
        System.out.println("Static: " + x);
    }
}
~~~

~~~java
public class InitialTest2 extends InitialTest1{
    public InitialTest2(int a){
        this.a = a;
        System.out.println("this.a = " + a);
    }

    int a;

    {
        System.out.println("InitialTest2: " + this.a);
    }

    static {
        x++;
        System.out.println("Static2: " + x);
    }

}
~~~

~~~java
public class InitialTest {
    public static void main(String[] args) {
        new InitialTest2(6);
        /*
        结果：必然是静态初始化在前，实例初始化在后
        Static: 1
        Static2: 2
        InitialTest1: 11
        InitialTest2: 0
        this.a = 6
         */
    }
}
~~~

## 4、对象清除与垃圾回收

java能够自动清除，不需要使用delete。对象回收是由Java虚拟机的**垃圾回收线程**来完成的。

System.gc()是system类的static方法，可以要求系统进行垃圾回收，但是仅仅是建议。

Java中没有“析构方法(destructor)” ，但Object的finalize() 有类似功能。系统在回收时会自动调用对象的finalize() 方法。 

protected void finalize() throws Throwable{} 

子类的finalize()方法可以在子类的finalize()方法释放系统资源。一般来说，子类的finalize()方法中应该调用父类的finalize()方法，以保证父类的清理工作能够正常进行。

## 5、内部类和匿名类

inner class和anonymous class是一种特殊的内部类，没有类名。

内部类就是将一个类定义在一个类中。

### 内部类的使用

* 在封装它的类的内部使用内部类，与普通类的使用方式相同

* 在其他地方使用
  * 类名前要冠以外部类的名字。 
  * 在用new创建内部类实例时，也要在new前面冠以对象变量。
  * 外部对象名.new 内部类名(参数)

~~~java
public class Parcel {
    private Contents c;
    private Destination d;

    class Contents{
        private int i;
        Contents(int i){
            this.i = i;
        }
        int value(){
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readlabel(){
            return label;
        }
    }

    void setProperty(Contents c, Destination d){
        this.c = c;
        this.d = d;
    }

    void ship(){
        System.out.println("move " + c.value() + " to " + d.readlabel());
    }

    public void testship(){
        c = new Contents(22);
        d = new Destination("Beijing");
        ship();
    }
}
~~~

~~~java
public class TestInnerClass {
    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.testship();

        Parcel.Contents c = p.new Contents(33);
        Parcel.Destination d = p.new Destination("Hawii");
        p.setProperty(c, d);
        p.ship();
    }
}
~~~

### static修饰符

用static修饰内部类，表明该内部类实际是一种外部类。

static类在使用时

* 实例化static类时，在 new前面不需要用对象实例变量； 
* static类中不能访问其外部类的非static的字段及方法，既**只能够访问static成员**。 
* static方法中不能访问非static的域及方法，也不能够不带前缀地new 一个非 static的内部类。



### 局部类

local class局部类是定义在方法中的内部类。

局部类的使用

同局部变量一样，方法中的内部类

* 不能够用 public,private,protected,static修饰， 
* 但可以被final或者abstract修饰。 

可以访问其**外部类的成员**。不能够访问该方法的局部变量，除非是final局部变量

### 匿名类

anonymous class是一种特殊的内部类，是一次性使用的 

~~~java
public class Anonymous {
    public static void main(String[] args) {
        Object obj = new Outer().maketheInner(56);
        System.out.println("Hello, " + obj.toString());
    }
}

class Outer{
    private int size = 5;
    public Object maketheInner(int localvar){
        final int finallocalvar = 99;
        return new Object(){
            public String toString(){
                return ("InnerSize: " + size + " finallocalvar: " + finallocalvar);
            }
        };

    }
}
~~~

## 6、lambda表达式

λ表达式

(参数)->结果

()->{System.out.println("aaa");}

是接口or接口函数的简写

~~~java
//求积分
double d = Integral(x->Math.sin(x), 0, Math, 1e-5);
~~~

能写成λ表达式的条件

相当于使用函数式接口@FuntionalInterface

要求包含且最多只能有一个抽象函数

## 7、装箱

基本类型的包装类

int-》Integer

Boolean, Byte, Short, Character, Integer, Long, Float, Double

装箱(Boxing) Integer i= 10;

拆箱 int i = I;

## 8、枚举

Enum是特殊的class类

enum light{Red, Yellow, Green}

注意

浮点数最好不用==，String用equals相等

~~~java
Integer i = new Integer(10);
Integer j = new Integer(10);
System.out.println(i==j); //false，因为对象是两个
Integer m = 10;
Integer n = 10;
System.out.println(m==n); //true，因为对象有缓存，-127~128

Integer p = 200;
Integer q = 200;
System.out.println(p==q); //false，因为对象是两个
~~~



~~~java
String hello = "Hello", lo = "lo";
System.out.println( hello == "Hello"); //true
System.out.println( Other.hello == hello ); //true

System.out.println( hello == ("Hel"+"lo") ); //true
System.out.println( hello == ("Hel"+lo) ); //false

System.out.println( hello == new String("Hello")); //false
System.out.println( hello == ("Hel"+lo).intern()); //true
~~~



# 五、异常处理

## 1、异常处理

异常(exception)又称为例外、差错、违例

### 基本写法

~~~java
try{
    语句组;
}catch(Exception ex){
    异常处理语句;
}
~~~



~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionForNum {
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please input a number: ");

            String s = in.readLine();

            int n = Integer.parseInt(s);

            System.out.println("Your number is " + n);

        }catch(IOException ex){

            ex.printStackTrace();

        }catch(NumberFormatException ex){

            ex.printStackTrace();

        }

    }
}
~~~

其中ex.printStackTrace()打印异常并且层层输出

传统的语言，比如C语言使用if语句判断是否出现了例外。缺点是可读性差、可维护性差，职责不清

Java的异常处理是**抛出异常(throw)**，运行时系统在调用栈中查找，从生成异常的方法开始进行回溯，直到找到

### 异常的分类

throwable

* Error：JVM的错误
* Exception：异常

一般说的异常是Exception及其子类

### Exception类

构造方法

~~~java
public Exception();
public Exception(String message);
Exception(String message, Throwable cause);
~~~

方法

~~~java
getMessage();
getCause();
printStackTrace();    
~~~

### 多异常的处理

子类异常要排在父类异常的前面。

finally语句，无论是否有异常都要执行

* 即使其中有break语句，return语句
* 在编译时，finally部分代码生成了多遍。

~~~java
public class TestTryFinally {

    public static String output = "";

    public static void main(String[] args) {
        //foo(1); 23
        foo(2); //134
        System.out.println(output);
    }

    public static void foo(int i){
        try{
            if(i == 1){
                throw new Exception();
            }
            output += "1";
        }catch(Exception e){
            output += "2";
            return ;
        }finally {
            output += "3";
        }

        output += "4";
    }
}
~~~

### 受检的异常

受检的异常要求进行语法处理，要么捕(catch)，要么抛(throw)

~~~java
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionTrowsToOther {
    public static void main(String[] args) {
        try{
            System.out.println("--------before---------");
            readfile();
            System.out.println("--------after----------");
        }catch(IOException e){
            System.out.println(e);  //如果输错路径，就会显示找不到文件
        }
    }

    public static void readfile()throws IOException{
        FileInputStream in = new FileInputStream("E:\\cs from basic to professional\\JAVA\\JavaMOOC\\src\\com\\mooc\\week6\\myfile.txt");
        int b;
        b = in.read();
        while(b != -1){
            System.out.print((char)b);
            b = in.read();
        }
        System.out.println("");
        in.close();
    }
}
~~~

### try with resource

**try(类型 变量名 = new 类型())**自动添加了finally{变量.close();}

不论是否出现了异常，都会执行。

~~~java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        String path = "E:\\cs from basic to professional\\JAVA\\JavaMOOC\\src\\com\\mooc\\week6\\myfile.txt";
        System.out.println(ReadOneLine1(path));
        System.out.println(ReadOneLine2(path));
    }

    static String ReadOneLine1(String path){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(path));
            return br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br != null){
                try{
                    br.close();
                }catch(IOException ex){

                }
            }
        }
        return null;
    }

    static String ReadOneLine2(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            return br.readLine();
        }
    }
}
~~~

如果文件路径对了，就会输出文件中的内容。否则会报错，并且输出一个null

## 2、自定义异常类

创建用户自定义异常。

* 可以继承自Exception类或某个子Exception类
* 定义属性和方法，或重载父类的方法

重抛异常及异常链接

对于异常，不仅要进行捕获处理，有时还需要将异常进一步传递给调用者。可以有以下三种方式

* 将当前捕获的异常再次抛出 throw e
* 重新生成一个异常，并抛出 throw new Exception("some message")
* 重新生成并抛出一个新异常，该异常包含了当前异常的信息 throw new Exception("some Message", e)

## 3、断言及程序的测试

assertion

格式： assertion 表达式； or assertion 表达式： 信息







