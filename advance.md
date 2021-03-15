#  一、IDEA

IDE (integrated development environment) 集成开发环境。

~~~
回顾java开发程序的步骤
编写代码-启动cmd-调用javac进行编译-调用java运行
~~~

Intellij IDEA

## 1、项目结构

项目(project)-模块(module)-包(package)

创建文件时，先选择左上角file。然后选择左下角的empty project。选择好路径后就是创建module，点击➕，选择new module。左边保持默认是java，直接next。输入module名称，finish。

创建后，左边有project。点击project名称左边的三角形箭头，会出现src文件夹和一个iml文件。<b>所有代码要放在src文件夹下</b>，而iml仅是IDEA的一些相关信息。与project平行的有一个external libraries，其实是JDK，一般也用不上，但是要有。

点击src，右键new-package，输入包名称。包名称只能由英文字母、点和数字组成。如com.github.day01.demo01。因为包是一组文件夹的名称，是一个多层级文件夹的嵌套。因此顺序是代码-->day01-->github-->com

如果需要导入module，就可以右键import进行导入

## 2、用IDEA写helloworld文件

对包名称右键，创建一个新的java class，名称为HelloWorld，就会创建一个类名称。

<b>常用语句</b>

* 在类里面输入psv or psvm再按下enter键就会自动出现public static void main(String[] args){}
* 输入sout就会跳出System.out.println();

<b>注意事项</b>

* Intellij IDEA 不需要保存，随着写就会保存下来
* 在代码空白处右键run HelloWorld main() or 按下shit+ctrl+F10 就会在下面的终端显示结果.按住alt+数字4能够显示和隐藏终端
* 生成的类在out/production/同项目名/同模块名下

~~~java
package com.github.day01.demo01;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
~~~

## 3、基本配置

在左上角的File-Settings可以进行设置。

* 字体
  * Editor-Font，可以调整size，令size为16
* 自动补全
  * 代码中出现红颜色的就是错误的
  * Keymap（所有快捷键）界面下，小齿轮选择dumplicate会生成default copy。找到Main menu-code-completion，选择basic，右键remove。然后add keyboard shortcut为alt+斜杠/，不用担心重复，因为另一个选项用不着。

## 4、常用快捷键

|        快捷键         |                  功能                  |
| :-------------------: | :------------------------------------: |
|       alt+enter       |          导入包，自动修正代码          |
|        Ctrl+Y         |             删除光标所在行             |
|        Ctrl+D         | 复制光标所在行的内容，插入光标位置下面 |
|      Ctrl+Alt+L       |          格式化代码，对齐代码          |
|        Ctrl+/         |         单行注释，再按取消注释         |
|     Ctrl+Shift+/      |  选中代码注释，多行注释，再按取消注释  |
| Alt+Ins（插入insert） |   自动生成代码，toString，get等方法    |
|  Alt+Shift+上下箭头   |             移动当前代码行             |

格式化代码以及导入包都是非常实用的

# 二、方法

只要包(package)名称前面一样，最后修改，生成的也是放在同一路径下。

方便

* 循环次数.fori加上回车就会自动生成for循环语句
  * 注意<b>要在main语句下</b>，例如5.fori再按下enter键，会生成for (int i = 0; i < 5; i++)



## 1、方法的复习

* 定义格式

~~~java
public static void 方法名称(){
    方法体
}
~~~

* 调用:在main里输入: 方法名称();

注意事项

* 方法定义的先后顺序无所谓
* 方法定义必须挨着，不能在一个方法的内部定义另一个方法
* 希望执行方法，需要对方法进行调用

~~~java
package com.github.day01.demo02;

public class Demo02Method {
    public static void main(String[] args) {
        print();
    }

    public static void print() {
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 20; i1++) {
                System.out.print("*");  //去掉ln表示不换行
            }
            System.out.println();   //不加内容直接用于换行
        }
    }
}
~~~

## 2、方法的定义

定义方法的完整格式

修饰符 返回值类型 方法名称（参数类型 参数名称， ……）{

​	方法体；

​	return 返回值;

}

一些术语的解释

* 修饰符，即public static
* 返回值类型，方法产生的最终数据结果的类型
* 方法名称，方法的名称，小驼峰格式
* 参数类型，进入方法的数据的类型
* 参数名称，进入方法的数据对应的变量名称；多个参数，用逗号分隔
* 方法体，方法需要做的事情
* return，停止当前方法，将后面的返回值返回给调用处
* 返回值，方法执行最后产生的数据结果。返回值的类型要与方法名称前面的类型相一致

因此，定义一个方法有三要素：

* 返回值类型
* 方法名称
* 参数列表：包含参数类型和参数名称

## 3、方法的调用

单独调用：方法名称();

打印调用：System.out.println(方法名称(参数));

赋值调用：数据类型 变量名称 = 方法名称(参数);

返回值类型为void的只能用单独调用，不能用打印调用或赋值调用

步骤是：找到方法-参数传递-执行方法体-带着返回值回到方法的调用处

~~~java
package com.github.day01.demo02;

public class Demo02methoduse {
    public static void main(String[] args) {
        //单独调用
        add(10,20); //在IDEA中a:和b:不能被选中，只是用于指引参数表征的含义
        System.out.println("==========");

        //打印调用
        System.out.println(add(10,20));
        System.out.println("==========");

        //赋值调用
        int num = add(10,20);
        System.out.println("变量的值：" + num);
    }

    public static int add(int a, int b){
        System.out.println("方法执行了！");
        int result = a + b;
        return result;
    }
}
~~~
结果
~~~
方法执行了！
==========
方法执行了！
30
==========
方法执行了！
变量的值：30
~~~

根据之前，可以看出可以分为<b>有参数和无参数</b>的情况

~~~java
package com.github.day01.demo02;

public class Demo02Parameter {
    public static void main(String[] args) {
        mult1(15,20);
        System.out.println("---------");
        mult2();
    }

    public static void mult1(int a, int b){
        int result = a * b;
        System.out.println("结果是： " + result);
    }

    public static void mult2(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello,world!" + i);
        }
    }
}
~~~

也可以分为<b>有返回值和无返回值</b>的情况

注意

* 对于有返回值的方法，可以使用单独调用，打印调用或赋值调用
* 对于无返回值的方法，只能使用单独调用，不能使用打印调用或赋值调用

~~~java
package com.github.day01.demo02;

public class Demo02MethodReturn {
    public static void main(String[] args) {
        //有返回值
        getsum(5,10);
        System.out.println(getsum(5,10));
        System.out.println("--------------------");

        //无返回值
        //System.out.println(printsum(5,10));   ×
        printsum(5,10);

    }

    //有返回值
    public static int getsum(int a, int b){
        int result = a * b;
        return result;
    }

    //无返回值
    public static void printsum(int a, int b){
        int result = a * b;
        System.out.println("结果是： " + result);
    }
}
~~~

 ## 4、练习

### a、比较两数字是否相同

~~~java
package com.github.day01.demo02;

public class Demo02MethodReturn {
    public static void main(String[] args) {
        //有返回值
        getsum(5,10);
        System.out.println(getsum(5,10));
        System.out.println("--------------------");

        //无返回值
        //System.out.println(printsum(5,10));   ×
        printsum(5,10);

    }

    //有返回值
    public static int getsum(int a, int b){
        int result = a * b;
        return result;
    }

    //无返回值
    public static void printsum(int a, int b){
        int result = a * b;
        System.out.println("结果是： " + result);
    }
}
~~~

### b、求出1到100和打印指定次数

~~~java
package com.github.day01.demo02;

public class Demo02GetSum {
    public static void main(String[] args) {
        GetSum();
        print(13);
    }

    public static void GetSum(){
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1到100的和是：" + sum);
    }

    public static void print(int num){
        for (int i = 0; i < num; i++) {
            System.out.println("Hello,world!");
        }
    }
}
~~~
 ## 5、方法重载(overload)

对于功能类似的方法，因为参数列表不同，需要重新编写方法。不方便，就有了overload。

### 概念

多个<b>方法的名称一样，但是参数列表不一样</b>。因此只需要记住一个方法名称，就可以实现类似的多个功能。

<b>方法与下列因素有关</b>

* 参数类型不同，
* 参数个数不同，
* 参数的多类型顺序不同

与下列因素无关

* 与参数的名称无关
* 与方法的返回值类型无关

~~~java
package com.github.day01.demo03;

public class Demo03Overload {
    public static void main(String[] args) {
        System.out.println("结果是：" + sum(2,5));
        System.out.println("------------");
        System.out.println("结果是：" + sum(2,5,7));
        System.out.println("------------");
        System.out.println("结果是：" + sum(2,5,7,8));
    }

    public static int sum(int a, int b){
        System.out.println("有2个参数参与运算");
        return a + b;
    }

    public static int sum(int a, int b, int c){
        System.out.println("有3个参数参与运算");
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d){
        System.out.println("有4个参数参与运算");
        return a + b + c + d;
    }
}
~~~

### 练习

 1、比较两个数据是否相等，参数类型分别是两个byte类型，两个short类型，两个int类型，两个long类型。

一般先写方法，再调用。这里熟悉了各种判断的表示方法

~~~java
package com.github.day01.demo03;

public class Demo03OverloadSame {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 2;
        System.out.println(same(a,b));
        System.out.println("--------");
        System.out.println(same((short)2,(short)3));
        System.out.println("--------");
        System.out.println(same(5,5));
        System.out.println("--------");
        System.out.println(same(12L,11L));
    }

    public static boolean same(byte a, byte b){
        boolean result;
        if(a == b){
            result = true;
        }else{
            result = false;
        }
        System.out.println("执行的是byte类型的比较");
        return result;
    }

    public static boolean same(short a, short b){
        System.out.println("执行的是short类型的比较");
        if(a == b){
            return true;
        }else{
            return false;
        }
    }

    public static boolean same(int a, int b){
        boolean result = a == b ? true : false;
        System.out.println("执行的是int类型的比较");
        return result;
    }


    public static boolean same(long a, long b){
        System.out.println("执行的是long类型的比较");
        return a == b;
    }
}
~~~

小技巧：按住shift+F6，可以同时修改原来相同的内容。

选中println，按住ctrl，用鼠标点击就会跳到对应的文件中。输出语句时。println就用了方法的重载。

## 6、数组

数组可以同时存放多个数据值。

数组的特点：

* 是一种引用数据类型
* 数组中的多个数据类型必须统一
* 数组的长度在程序运行期间不能改变

### 数组的初始化

在内存中创建一个数组，向其中赋予一些值。

常见的初始化方式有

* 动态初始化（指定长度 or 数据元素个数）
  * 格式:	数据类型[] 数组名称 = new 数据类型[数组长度];
    * 例如: int[] ArrayInt = new int[20];
* 静态初始化（指定内容）
  * 格式:	数据类型[] 数组名称 = new 数据类型[]{元素1， 元素2 ，……};
    * 例如:	String[] ArrayString = new String[]{“Hello”, "World“, "Java"};
* 省略格式的静态初始化
  * 格式：	数据类型[] 数组名称 = {元素1， 元素2， ……};

注意事项

* 静态初始化没有直接指定长度，仍然会自动推算得到长度
* 静态初始化和动态初始化的标准格式可以拆分为两个步骤
  * int[] arrayA;
  * arrayA = new int[20];
* <b>静态初始化的省略模式不能拆分成两个步骤</b>

### 访问数组元素

#### a、获取

直接打印数组名称，得到的数组对应的内存地址哈希值。

访问数组元素的格式: 数组名称[索引值], <b>索引值代表元素的编号，从0开始到数组长度-1</b>

#### b、赋值

动态初始化数组时，其中的元素会自动拥有一个默认值

|  类型  |  默认值  |
| :----: | :------: |
|  整数  |    0     |
| 浮点数 |   0.0    |
|  字符  | '\u0000' |
|  布尔  |  false   |
|  引用  |   null   |

其实，静态初始化也有默认值的情况，只不过系统马上将默认值替换为大括号中的内容

~~~java
package com.github.day01.demo03;

public class Demo03ArrayUse {
    public static void main(String[] args) {
        //静态初始化先赋值
        int[] arrayA = new int[]{10, 20, 30};

        System.out.println("数组的第一个元素是：" + arrayA[0]);
        System.out.println("数组的最后一个元素是:" + arrayA[2]);

        int num = arrayA[1];
        System.out.println(num);
        System.out.println("---------------");

        //动态初始化
        int[] arrayB = new int[3];
        arrayB[1] = 3;
        arrayB[2] = 5;
        System.out.println(arrayB); //数组内存地址对应的哈希值
        System.out.println(arrayB[0]);
        System.out.println(arrayB[1]);
        System.out.println(arrayB[2]);
    }
}
~~~

## 7、Java中内存的划分

内存需要划分为5部分：

* <b>栈(stack)</b>: 存放的是方法中的局部变量。（局部变量，方法的参数）局部变量，一旦超出作用域，立刻从栈内存中消失。<b>方法的运行在栈中运行</b>
* <b>堆(heap)</b>: <b>new出来的都放在堆中</b>。堆里面的都有地址值，地址值是16进制。堆内存里面的数据有默认值。
  * 规则是：整数为0，浮点数为0.0，字符为'\u0000'，布尔为false，引用类型为null
* <b>方法区(method area)</b>: 存储.class相关信息，包含方法的信息
* <b>本地方法栈(native method stack)</b>: 与操作系统相关
* <b>寄存器(register)</b>: 与CPU相关

### a、一个数组的内存划分

public static void main(String[] args)先保存在方法区 。先运行方法区的main方法，将main中的内容加载到栈内存中，并且为main方法开辟一块空间。

![image](https://github.com/healthyxj/Java/blob/main/images/%E4%B8%80%E4%B8%AA%E6%95%B0%E7%BB%84%E7%9A%84%E5%86%85%E5%AD%98%E5%9B%BE.png)

### b、两个数组的内存划分

真正要执行，一定要进栈，

![images](https://github.com/healthyxj/Java/blob/main/images/%E4%B8%A4%E4%B8%AA%E6%95%B0%E7%BB%84%E7%9A%84%E5%86%85%E5%AD%98%E5%9B%BE.png)



![image](https://github.com/healthyxj/Java/blob/main/images/%E4%B8%A4%E4%B8%AA%E5%BC%95%E7%94%A8%E6%8C%87%E5%90%91%E5%90%8C%E4%B8%80%E4%B8%AA%E6%95%B0%E7%BB%84.png)

### c、数组常见问题

数组索引越界异常

ArrayIndexOutOfBoundsException。

空指针异常

数组初始化，分部执行时。所有引用类型变量都可以赋值为null。

NullPointerException。

## 8、数组进阶

### a、获取数组的长度

方法是数组名称.length

注意：数组一旦创建，程序运行期间，长度不可改变

### b、数组的遍历输出

遍历数组，对数组中的每一个元素进行挨个处理。

一般使用循环的方法对数组进行处理。<b>IDEA中用数组长度.fori</b>

### c、数组的最值

遍历与某个值进行比较，这个某个值可以用数组的第一个值进行赋值

~~~java
package com.github.day01.demo03;

public class Demo03ArrayLength {
    public static void main(String[] args) {
        int[] ArrayA = new int[5];
        int[] ArrayB = new int[]{2, 1, 23, 3, -5, 3, 185, 4859, 646, 749, 670, 2};
        //获取数组长度
        System.out.println("数组A的长度为" + ArrayA.length);
        System.out.println("数组B的长度为" + ArrayB.length);
        System.out.println("------------------------");

        //数组的遍历
        int[] ArrayC = new int[]{11, 1, 4154, 9648, 974, 16, 5};
        for (int i = 0; i < ArrayC.length; i++) {   //这里用length可以避免数组更改带来的影响
            System.out.println("第" + (i + 1) + "个元素的值为" + ArrayC[i]);
        }
        System.out.println("------------------------");

        //求出数组的最大值和最小值
        int Max = ArrayB[0];
        int Min = ArrayB[0];
        for (int i = 1; i < ArrayB.length; i++) {
            if (ArrayB[i] > Max) {
                Max = ArrayB[i];
            }
            if (ArrayB[i] < Min) {
                Min = ArrayB[i];
            }
        }
        System.out.println("最大值为" + Max + "， 最小值为" + Min);
    }
}
~~~

### d、数组元素反转

不能使用新数组，只能用原来的唯一的数组。

<b>数组元素反转，其实是对称位置的元素交换</b>。通常是一个索引，表示对称位置需要两个索引min和max。一开始为0和长度减一。

然后是交换两个变量的值，要借助第三个变量temp。

当min >= max时，停止交换。（min < max时，应该继续交换）

~~~java
package com.github.day01.demo03;

public class Demo03ArrayReverse {
    public static void main(String[] args) {
        int[] Array = new int[]{45, 69, 76, 1, 35};

        /*初始化：令min为数组的第一个元素，max为数组的最后一个元素
        循环条件：min < max
        步进： min++，max--
        循环体：利用临时变量进行交换*/
        for (int min = 0, max = Array.length - 1; min < max; min++, max--) {
            int temp = Array[min];
            Array[min] = Array[max];
            Array[max] = temp;
        }

        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }
}
~~~

### e、数组作为方法参数

数组可以作为方法的参数，当调用方法时，向方法的小括号传参，<b>传递进去的是数组的地址值</b>。

~~~java
package com.github.day01.demo03;

public class Demo03ArrayParam {
    public static void main(String[] args) {
        int[] array = new int[]{51,4,8,98,23};

        System.out.println(array);
        System.out.println("-------------");
        PrintArray(array);

    }

    public static void PrintArray(int[] array){
        System.out.print("PrintArray收到的参数是：");
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
~~~

### f、数组作为方法的返回值

一个方法可以有任意整数个输入，但是只能有0个或1个输出。解决方法是返回数组，返回的仍是地址，使用的时候需要使用索引。

~~~java
package com.github.day01.demo03;

public class Demo03ArrayReturn {
    public static void main(String[] args) {
        //数组作为返回值，返回的是地址值
        System.out.println(caculate(45, 13, 96));
        System.out.println("------------------------");

        //如果需要使用数组的返回值，需要赋值
        int[] result = caculate(45, 13, 96);
        System.out.println("结果：" + result[0]);
        System.out.println("平均值：" + result[1]);

    }

    public static int[] caculate(int a, int b, int c) {
        int sum = a + b + c;
        int average = (a + b + c) / 3;
        int[] result = new int[]{sum, average};
        return result;
    }
}
~~~







