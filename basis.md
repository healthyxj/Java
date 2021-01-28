#  一、Java入门

## 1、Java环境变量的设置

有几个环境变量需要设置

* JAVA_HOME
  * 变量值要按照自己的JDK的实际路径配置 

* CLASSPATH
  * **.;**%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
  * <b>新手注意</b> :开头要有英文的点和分号
* PATH
  * %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

设置完成后，可以win+r，输入cmd，输入java -version查看安装情况。

## 2、HelloWorld

新建一个文本文档，名称为HelloWorld。输入以下内容

~~~java 
public class HelloWorld{
	public static void main(String[] args){
		System.out.println("Hello,World!");
	}
}
~~~

或者命名的时候，修改拓展名为java，然后用文本文档打开。

win+r打开运行窗口，输入cmd并enter。通过cd转移到文件所在目录下。输入javac HelloWorld.java(注意一定要带java后缀名)，这时会生成一个class文件。然后再输入java HelloWorld(注意不要带任何的后缀名)，就能看到命令窗口中弹出Hello，world!了。

如果修改了HelloWorld.java的内容，但是没有重新编译，即javac HelloWorld.java，重新运行java程序会得到与之前相同的结果。若对HelloWorld重新编译，会生成一个新的class文件，覆盖掉之前的文件。

几个需要注意的事情

* class后面的内容要与文件名称相同
* 要用全英文的方式输出字母和符号

## 3、程序注释

单行注释

* //	//开头到结束都是注释信息

多行注释

* /* */	/**/星号之间都是注释，也是区块注释

~~~java
//第一行的第三个单词要与所在文件名称完全一致
//public class代表一个类，类是java源代码中的基本组织单位
public class HelloWorld{
    //这一行是固定写法，main方法，是程序的起点
	public static void main(String[] args){
        //打印输出的语句，ln表示换行
		System.out.println("Hello,World!");
	}
}
~~~

## 4、关键字与标识符

### 关键字

有特殊含义的、被保留的、不能随便使用的字符就是关键字。

关键字的特点

* 完全小写
* 在增强版的记事本中有特殊颜色

### 标识符

程序中，自己定义的内容，如类、方法、变量的名字。

命名要求及规范

* 包括英文字母、数字、下划线
* 不能以数字开头
* 不能是关键字
* **类名首字母大写，每个单词首字母大写**
* **变量名首字母要小写，后面的每个单词首字母要大写**

## 5、常量及变量

### 常量分类

* 字符串常量
  * 用双引号引起的，都是字符串常量
  * **内容可以是0个或多个**
* 整数常量、整形常量
  * 直接写上数字，无小数点
* 浮点数常量
  * 有小数点
* 字符常量
  * 用**单引号**引起的**单个**字符
  * 有且只有一个字符，空格也算一个字符
* 布尔常量
  * true和false
* 空常量
  * null

### 常量的打印输出

~~~java
//注意，用文本文档编写的时候要保存为ANSI格式
//这是用于输出常量，加深理解的Demo01
public class Demo01{
	public static void main(String[] args){
		//输出字符串常量
		System.out.println("ABC");
		//输出数字常量
		System.out.println(30);
		//输出字符常量
		System.out.println('A');
		//输出布尔常量
		System.out.println(true);
		//输出空常量 System.out.println(null);×
	}
}
~~~

###  基本数据类型

还有引用数据库类型，包括**字符串**、数组、类、接口和lambda。

基本数据类型（四个八种）

* 整数型
  * byte （1个字节）
  * short（2个字节）
  * int（4个字节）
  * long（8个字节）
* 浮点型（为近似值，并不一定是精确值）
  * float（4个字节）
  * double（8个字节）
* 字符型
  * char（2个字节）
* 布尔型
  * boolean（1个字节）

注意事项

数据范围与字节数不一定相关。<b>浮点数默认用double类型，若非用float的类型，要加上后缀F。整数默认为int，若非要用long类型，要加后缀L。</b>推荐大写字母后缀

### 变量

创建变量：数据类型 变量名称

对变量进行赋值就可以把值存储到左边的变量。**未赋值的变量无法使用**

~~~java
//用于熟悉变量的使用
public class Demo02{
	public static void main(String[] args){
	//创建一个变量并赋值
		int num1;
		num1 = 10;
		System.out.println(num1);
	//改变变量的值
		num1 = 20;
		System.out.println(num1);
	//一步到位定义变量
		int num2 = 25;
		System.out.println(num2);	
		System.out.println("========");
	//右侧的数值范围不能超过变量的数据范围，byte num3 = 400;×
		long num3 =300000000L;	
		System.out.println(num3);

		char A  = '中';
		System.out.println(A); 
	}
}
~~~

注意事项

* 变量之间不可以重名
* 对于float和long需要加后缀
* byte和short注意取值范围
* 变量一定要赋值后才能够使用
* 变量不能够在作用域之外作用。作用域是从定义变量的一行开始，一直到直接所属的大括号结束为止
