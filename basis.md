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
### 数据类型转换

数据类型不一样时，会发生类型转换

* 自动类型转换（隐式）
  * 特点：代码不需要进行特殊处理，自动完成
  * 规则：数据范围从小到大
* 强制类型转换（显式）
  * 代码需要进行特殊的格式处理，不能自动完成
  * 格式：范围小的类型 范围小的变量名 = （范围小的类型）原本范围大的数据

~~~java
public class Demo03{
    public static void main(String[] args){
        //缺少一个L,将右边范围小的int转换为long，符合自动类型转换的要求，属于自动类型转换
     	long num1 = 100;
        System.out.println(num1);
        
        //float范围比double小，也是自动类型转换
        double num2 = 2.2F;
        System.out.println(num2);	//2.200000047683716
        
        //long转换为float，符合数据范围从小到大，自动类型转换，结果为30.0
        float num3 = 30L;
        System.out.println(num3);	//30.0
        
        //long转化为int，需要强制类型转化
        int num4 = (int)100L;
        System.out.println(num4);	//100
        
        //数据溢出
        int num5 = (int)60000000000L;
        System.out.println(num5);	//-129542144
        
        //精度损失，浮点数转化为整数，去掉小数部分
        int num6 = (int)3.5;
        System.out.println(num6);	//3
        
        //计算机的底层用数字代表字符A，一旦char要进行数学运算，就会转为int类型：A是65
        char zifu1 = 'A';
        System.out.println(zifu1 + 1);	//66
        
        //byte + byte先转为int类型
        byte num7 = 30;
        byte num8 = 60;
        //byte + byte-->int + int-->int
        int result1 = num7 + num8;
        System.out.println(result1);
        
        //byte + short
        short num9 = 50;
        //short + byte-->int + int-->int；这里要有括号否则就是对num7进行局部的数据类型转化
        short result2 = (short)(num7 + num9);
        System.out.println(result2);
    }
}
~~~

注意事项

* 强制类型转换一般不推荐使用，会发生精度损失、数据溢出
* byte/short/char这3种类型可以发生数学运算
* <b>byte/short/char这3种类型在运算的时候会先转为int类型</b>
* 布尔类型不能发生强制类型转化
* <b>编译器的常量优化：在赋值时，如果右侧全部是常量，没有任何变量，编译器会将常量运行结果的值直接赋值给左边。不会用默认的int类型赋值</b>

### ASCII码表

ASCII 码表 美国信息标准交换代码

Unicode万国码，数字和符号的对照关系，开头0-127与ASCII完全一样，从128开始包括更多字符

0-48；A-65；a-97

~~~java
public class Demo04{
	public static void main(String[] args){
        char zifu1 = '1';
        System.out.println(zifu1 + 0);
        
        char zifu2 = 'C';
        //char-->int发生自动类型转化
        int num = zifu2;
        System.out.println(num);
        
        char zifu3 = '中';
        System.out.println(zifu3 + 0);	//20013
    }    
}
~~~

## 6、运算符

进行特定运算的符号，如+；用运算符连接起来的 是表达式

算术运算符

除数/，小学运算中的除数；

取模：取余数

注意事项：<b>一旦运算中出现不同数据类型，结果会是数据类型大的那种</b>
~~~java
public class Demo05{
	public static void main(String[] args){
		//两个常量之间可以进行运算
        System.out.println(20 + 30);
        
        //两个变量之间可以进行运算
        int a = 20;
        int b = 30;
        System.out.println(a + b);
        
        //变量和常量之间混合使用
        System.out.println(10 * a);
        
        int result1 = b / a;
        int result2 = b % a;
        System.out.println(result1);	//1
        System.out.println(result2);	//10
        
        //String是要大写的，同时字符也是要用双引号的
        String str1 = "Hello";
        System.out.println(str1);	
        
        System.out.println(str1 + "World");	//HelloWorld
        
        String str2 = "java";
        System.out.println(str2 + 20 + 20);	//java2020
        System.out.println(str2 + (20 + 20));	//java40
    }
}
~~~

### 自增自减运算符

自增运算符: ++；自减运算符: --。让一个变量涨一个数字或降一个数字 ，可以写在变量名之前，也可以写在变量名之后。

使用方式

* 单独使用，不与其他操作混合，自己独立成为一个步骤
* 混合使用：与其他操作混合

区别:单独使用时，前++和后++无区别；混合使用时，前++，变量马上+1，然后拿着结果去使用；后++先用变量本来的值，再让变量+1.【前++，先加后用，后++，先用后加】

注意事项：只有常量才能使用自增自减运算符

~~~java
public class Demo06{
	public static void main(String[] args){
		int num1 = 10;
        System.out.println(num1);
        ++num1;
        System.out.println(num1);
        num1++;
        System.out.println(num1);
        System.out.println("======");
        
        int num2 = 20;
        System.out.println(++num2);	//21
        System.out.println(num2);	//21
       	System.out.println("======");
        System.out.println(num2++);	//21
        System.out.println(num2);	//22
        
        int num3 = 30;
        int result1 =--num3;
        System.out.println(result1);	//29
        System.out.println(num3);	//29
        System.out.println("======");
        
        int result2 = num3--;
        System.out.println(result2);	//29
        System.out.println(num3);	//28
    }
}
~~~

### 赋值运算符

赋值运算符分类

* 基本赋值运算符
  * =
* 复合赋值运算符
  * +=	a += 1 --> a = a + 1
  * -= 类比上面一条语句
  * *=
  * /=
  * %=

注意事项

* 只有变量才能进行赋值运算
* 复合赋值会发生强制类型转换

### 比较运算符

 大于，小于，等于(==)，不等于(!=)

注意事项

* 比较运算符输出的结果是一个布尔值
  * 10 < 12输出true
* 比较运算符不能连着写

### 逻辑运算符

与&&、或||、非！

注意事项

* 与&&和或||有短路效果，根据左边可以判断得到最终结果，右边的代码将不再执行，从而节省一定的性能
* 逻辑运算符只用于boolean
* 与或运算符左右端各需要一个布尔值
* 与或可以连接多个条件

### 三元运算符

一元运算符：只需要一个数据就可以进行操作的运算符；自增自减、取反

二元运算符：需要两个数据才可以进行操作的运算符

三元运算符：需要三个运算符才可以进行操作的运算符。格式：变量名称 = 条件判断 ？ 表达式A ： 表达式B。

注意事项

* 必须同时保证表达式A和表达式B都符合左侧数据类型的要求
* 三元运算符的结果必须被使用

~~~java
public class Demo07{
    public static void main(String[] args){
		int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println("最大值：" + max);
        
        //int result = 3 > 4 ? 2.5 : 10;	×
        System.out.println(3 > 4 ? 2.5 : 10);	//10.0
    }
} 
~~~

## 7、方法入门

方法是将代码抽出来，从而达到分类的效果

### 定义方法的格式

public static void 方法名称(){

​	方法体

}

方法名称的命名规则和变量一样，使用小驼峰。方法体可以包含任意个语句。

#### 注意事项

* 方法定义的先后顺序无所谓
* 方法（包含public static void）不能产生嵌套包含关系
* 方法的使用需要调用：方法名称();

~~~java
public class Demo08{
    public static void main(String[] args){
        PC();	//调用电脑
        browser();	//调用浏览器
        github();	//调用github
    }
    
    //打开电脑
    public static void PC(){
        System.out.println("插上电源");
		System.out.println("按下开机键");
    }
    
    //打开浏览器
    public static void  browser(){
        System.out.println("打开浏览器");
    }
    
    //打开github
	public static void github(){
        System.out.println("输入地址");
		System.out.println("进入github");
    }
}
~~~

## 8、 JShell的使用

在cmd命令中直接输入jshell 。直接输入System.out.println(“Hello world”);类似于脚本

退出语句: <b>/exit</b>

jshell是轻量级的小工具，其他还是要单独保存为文件

# 二、流程控制

## 1、顺序结构

按顺序执行

## 2、判断语句

### if语句

分类

* 单if语句
* if else语句
* if else if else语句

~~~java
public class Demo09{
    public static void main(String[] args){
		//单if语句
        System.out.println("看见一个网吧");
        
        int age = 17;
        if(age >= 18){
			System.out.println("打游戏");
        }
        System.out.println("回家");
        
        System.out.println("=========");
            
        //标准if else语句,非黑即白类型
        int a = 15;
        if(a % 2 == 0){
			System.out.println("是偶数");
        }else{
			System.out.println("是奇数");
        }
        
        //扩展if语句
        int score = 100;
        if (score > 100 || score < 0){
			System.out.println("成绩不合法");
        }else if(score >= 90 || score < 100){
			System.out.println("成绩为优秀");
        }else if(score >= 80 || score < 90){
			System.out.println("成绩为良");
        }else if(score >= 60 || score < 80){
			System.out.println("成绩为及格");
        }else{
			System.out.println("成绩不及格");
        }
    }
}
~~~

### switch语句

注意事项：

* 多个case后面的数值不可以重复
* switch后面跟的小括号只能是byte/short/char/int类型和引用数据类型string
* 顺序可以改变，不一定要按照一定的顺序，default总是最后执行的

~~~java
public class Demo10{
    public static void main(String[] args){
		int num = 1;
        
        switch(num){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;  
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期七");
                break;     
            default:
                System.out.println("不合理");
                break;
        }
    }
}
~~~

## 3、循环语句

