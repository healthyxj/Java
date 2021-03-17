API(Application Programming Interface)，应用程序编程接口。相当于程序员的字典，记录了一些类的说明文档，这些文档将底层的代码封装起来。可以查询API，来学习Java提供的类。

可以查看API帮助文档，按照类的包路径-构造方法摘要-成员方法摘要

# 一、Scanner

通过scanner键盘输入。

## 引用类型的一般使用步骤

* 导包
  * **import 包路径.包名称**
  * 如果需要使用的目标类和当前类位于同一包下，可以省略导包语句。
  * 位置要在packages后。public之前。没使用前都是灰色的。
  * **只有java.lang包下的内容不需要导包**，其他的包都需要import语句
* 创建
  * **类名称 对象名 = new 类名称();**
* 使用
  * **对象名.成员方法名()**

Scanner的初步使用

~~~java
package com.github.demo02;

//导包
import java.util.Scanner;

public class Demo01Scanner {
    public static void main(String[] args) {
        //创建
        Scanner sc = new Scanner(System.in);

        //使用，调用nextInt方法
        int num = sc.nextInt();
        System.out.println("输入的数字为" + num);

        //调用next方法，读入字符串
        String str = sc.next();
        System.out.println("输入的字符串为" + str);
    }
}
~~~

结果显示

~~~
21
输入的数字为21
Hello, world
输入的字符串为Hello,
~~~

可见，Scanner.next()方法遇到空格就会退出。

## 练习

输入三个数，输出其中最大的值

~~~java
package com.github.demo02;

import java.util.Scanner;

public class Demo02ScannerMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //方便与用户进行交互
        System.out.println("请输入第一个数:");
        int a = sc.nextInt();
        System.out.println("请输入第二个数:");
        int b = sc.nextInt();
        System.out.println("请输入第三个数:");
        int c = sc.nextInt();

        int tmp = a > b ? a : b;
        int max = tmp > c ? tmp : c;
        System.out.println("最大的数为" + max);
    }
}
~~~

## 匿名对象

创建对象的标准格式：类名称 对象名 = new 类名称();

匿名对象是只有右边的对象，没有左边的名字和赋值运算符。如 new 类名称();

**匿名对象只能使用一次**，下次使用就得创建一个新的对象。如果确定有一个对象只需要使用唯一的一次，就可以使用匿名对象。

# 二、Random

产生随机数

## 简单使用

使用

nextInt有两种输入：**里面的为空，随机产生int范围内的数，-21亿到21亿；里面有数字，则输出[0,数字)**, 形式上类似数组。

~~~java
package com.github.demo02;

import java.util.Random;

public class Demo02RandomN {
    public static void main(String[] args) {

        Random r1 = new Random();
        int num1 = r1.nextInt();
        System.out.println("生成的随机数为" + num1);

        System.out.println("-----------------------");

        Random r2 = new Random();
        int num2;
        for (int i = 0; i < 20; i++) {
            //用于输出括号范围内的数字
            num2 = r2.nextInt(52);
            System.out.println("random number: " + num2);
        }
    }
}
~~~

## 猜数字

猜测数字

~~~java
package com.github.demo02;

import java.util.Random;
import java.util.Scanner;

public class Demo02GuessNum {
    public static void main(String[] args) {
        Random ran = new Random();
        int RandowNum = ran.nextInt(100) + 1;   //使得生成的随机数控制在1到100之间
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请输入你猜测的数字： ");
            int Guess = sc.nextInt();

            if(Guess < RandowNum){
                System.out.println("太小了，请重试");
            }else if(Guess > RandowNum){
                System.out.println("太大了，请重试。");
            }else{
                System.out.println("恭喜你猜对了！");
                break;
            }
        }

        System.out.println("游戏结束。");
    }
}
~~~



# 三、ArrayList



## 1、对象数组

将类存储到数组中。例如定义一个Person类

~~~java
package com.github.demo02;

public class Person {
    private  int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
~~~

然后将用Person类创建的对象存储到数组中

~~~java
package com.github.demo02;

public class ArrayPerson {
    public static void main(String[] args) {
        //创建一个长度为3的数组，用于存放Person类的对象
        Person[] array = new Person[3];

        //创建三个对象
        Person p1 = new Person(18, "张三");
        Person p2 = new Person(21, "李四");
        Person p3 = new Person(24, "王五");

        //将对象的地址值赋值到数组中
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;

        System.out.println(array[0]);   //输出的是地址值
        System.out.println(array[1]);
        System.out.println(array[2]);

        System.out.println(array[0].getName()); //输出的是名字
        System.out.println(array[1].getName());
        System.out.println(array[2].getName());
    }
}
~~~



## 2、ArrayList基本使用

数组的长度不能发生改变，但是ArrayList的长度可以改变。

对于ArrayList，有一对尖括号<>表示**泛型(表示在集合当中的所有元素，全部统一是什么类型**)。**泛型只能是引用类型，而不能是基本类型**。

如果非要往ArrayList中存储基本数据类型，必须**使用基本类型对应的包装类**。

| 基本类型 | 包装类    |
| -------- | --------- |
| byte     | Byte      |
| short    | Short     |
| int      | Interger  |
| long     | Long      |
| float    | Float     |
| double   | Double    |
| char     | Character |
| boolean  | Boolean   |

JDK1.5开始，能够支持自动装箱和自动拆箱。即自动对基本类型和包装类型进行转换。

ArrayList可以看成是一个集合。

~~~java
package com.github.demo02;

import java.util.ArrayList;

public class demo02ArrayList {
    public static void main(String[] args) {
        //创建了一个ArrayList集合，集合的名称是lname，里面的内容是String类型的
        ArrayList<String> lname = new ArrayList<>();

        System.out.println(lname);  //[]->如果内容为空，得到的是空的中括号

        //向集合中添加数据，需要用到add方法
        lname.add("张三");
        lname.add("李四");
        lname.add("王五");
        lname.add("朱六");

        System.out.println(lname);  //[张三, 李四, 王五, 朱六]
    }
}
~~~



## 3、ArrayList常用方法

public boolean add(E e);	向集合中添加元素，参数的类型和泛型(E)一致。

public E get(int index);	向集合中获取元素，参数是索引编号，返回值是对应位置的元素。

public E remove(int index);	从集合中删除元素，参数是索引编号，返回值是被删除的元素

public int size();	获取集合的尺寸长度，返回值是集合中包含的元素个数。

~~~java
package com.github.demo02;

import java.util.ArrayList;

public class demo02ArrayList {
    public static void main(String[] args) {
        //创建了一个ArrayList集合，集合的名称是lname，里面的内容是String类型的
        ArrayList<String> lname = new ArrayList<>();

        System.out.println(lname);  //[]->如果内容为空，得到的是空的中括号

        //向集合中添加数据，需要用到add方法
        lname.add("张三");
        lname.add("李四");
        lname.add("王五");
        lname.add("朱六");
        boolean success = lname.add("老大");
        System.out.println("添加元素是否成功：" + success);

        System.out.println(lname);  //[张三, 李四, 王五, 朱六]

        //用get()方法获取集合中的元素
        System.out.println(lname.get(1));

        //用remove()方法移除集合中的元素
        String whoRemoved = lname.remove(2);
        System.out.println("被移走的人是" + whoRemoved);
        System.out.println(lname);

        //ArrayList.size()能够显示出集合的长度，相当于数组的length
        System.out.println("剩下" + lname.size() + "人， 分别是");
        for (int i = 0; i < lname.size(); i++) {
            System.out.println(lname.get(i));
        }
    }
}
~~~



## 4、练习

1、产生6个范围在1-33的随机整数，并存放到一个集合中，并且遍历集合。

~~~java
package com.github.demo03;

/*
生成6个1到33的随机整数，添加到一个数组中，并且遍历数组
1、需要用存储6个数字->数组； 产生随机数->random
2、6个->for循环， 循环内要调用nextInt
3、添加到集合中->add， 得到集合的长度->size和get
 */

import java.util.ArrayList;
import java.util.Random;

public class Demo03ArrayListRandom1 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(33) + 1;    //整体加1才是33
            array.add(num);
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
~~~



2、定义以指定格式打印集合的方法，使用{}扩起集合，使用@分隔所有元素

~~~java
package com.github.demo03;

import java.util.ArrayList;

/*
定义以指定格式打印集合的方法，使用{}扩起集合，使用@分隔所有元素
 */

public class Demo03PrintStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student stu1 = new Student("张三",18);
        Student stu2 = new Student("李四",31);
        Student stu3 = new Student("王五",26);
        Student stu4 = new Student("朱六",19);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);

        System.out.println(list);   //输出地址值, 形式如同[addr1, addr2, ……, addrn];
        PrintStudentName(list); //{张三@李四@王五@朱六}
    }

    public static void PrintStudentName(ArrayList<Student> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            Student tmp = list.get(i);
            if(i == list.size() - 1){
                System.out.print(tmp.getName());
            }else{
                System.out.print(tmp.getName() + "@");
            }
        }
        System.out.println("}");
    }
}
~~~



3、创建一个有20个随机数生成的集合，筛选其中的偶数部分，并将偶数部分存放到一个新的集合中。

~~~java
package com.github.demo03;

import java.util.ArrayList;
import java.util.Random;

public class Demo03ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> biglist = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int tmp = r.nextInt(100) + 1;
            biglist.add(tmp);
        }

        ArrayList<Integer> smalllist = GetSmallList(biglist);

        System.out.println("偶数的个数：" + smalllist.size());
        for (int i = 0; i < smalllist.size(); i++) {
            System.out.print(smalllist.get(i));
            System.out.print(" ");
        }
    }

    public static ArrayList<Integer> GetSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if(tmp % 2 == 0){
                smalllist.add(tmp);
            }
        }

        return smalllist;
    }
}
~~~



# 四、String

java.lang.String代表字符串。程序中所有的双引号字符串都是String类的对象。

## 1、字符串的特点

* 字符串的内容永不可变【重点】
* 字符串不可改变，字符串是可以共享使用的
* 字符串效果上相当于char[]字符数组，但是底层原理是byte[]字节数组

## 2、创建字符串的常见方法

3+1

3种构造方法

public String();	创建一个空白的字符串，不包含任何内容

public String(char[] array);	//根据字符数组的内容，来创建对应的字符串

public String(byte[] array);	//根据字节数组的内容，来创建对应的字符串

1种直接创建

String str = "Hello"	//直接引用双引号

~~~java
package com.github.demo03;

public class Demo03String {
    public static void main(String[] args) {
        //使用空参构造方法
        String str1 = new String();
        System.out.println(str1);

        //根据字符数组创建字符串
        char[] array = {'A', 'B', 'C'};
        String str2 = new String(array);
        System.out.println(str2);

        //根据字节数组创建字符串
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println(str3);

        String str4 = "Hello";
        System.out.println(str4);
    }
}
~~~

## 3、字符串常量池

程序中**直接写上的双引号字符串，就在字符串常量池**中。字符串常量池位于堆之中。



~~~java
package com.github.demo03;

public class Demo03StringPool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] array =  {'a', 'b', 'c'};
        String str3 = new String(array);

        System.out.println(str1 == str2);   //true
        System.out.println(str3 == str2);   //false
        System.out.println(str1 == str3);   //false
    }
}
~~~

对于基本类型，==进行的是数值的比较，而对于**引用类型**来说，**==进行的是地址值的比较**；双引号直接写的字符串在常量池之中，new的不在池当中。

### 整个过程

直接创建String，会在堆中生成一块空间，里面放着**字节数组(会变成ASCII值)**。同时在字符串常量池中生成一个String，指向该字节数组。而参数则指向该String。

而用字符数组创建一个String，则是在堆中字符串常量池之外创建字符数组。字符数组会转换成一个字节数组。同时，在字符串常量池之外生成一个String指向该字节数组，而参数指向该字节数组。

## 4、字符串的比较相关方法

==是对象的地址值的比较，要堆字符串的内容进行比较，需要使用方法

* public boolean equals(Object obj)
  * 参数可以是任何对象
  * 只有参数是一个字符串且**内容完全相同**才会返回一个true
  * 方法有**对称性**，可以是a.equals(b)也可以是b.equals(b)
  * 如果**要比较一个常量和一个变量，推荐把常量写在前面**，当字符串为NULL时会报错空指针异常NullPointerException
* public boolean equalsIgnoreCase(String str)
  * **忽略大小写**的内容比较

**任何对象都能用Object进行接收**



~~~java
package com.github.demo03;

public class Demo03StringComp {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        char[] Array = {'a','b', 'c'};
        String str3 = new String(Array);

        System.out.println(str1.equals(str3));  //true
        System.out.println("abc".equals(str2)); //true

        String strA = "Hello";
        String stra = "hello";
        System.out.println(strA.equalsIgnoreCase(stra));    //true
    }
}
~~~

## 5、字符串的获取相关方法

常见的有

* public int length()
  * 获取字符串中含有的字符个数，即拿到字符串的长度
* public String concat(String str)
  * 将当前字符串与参数字符串进行**拼接**，并且返回一个新的字符串
* public char charAt(int index)
  * 获取指定索引位置的单个字符
* public int indexOf(String str)
  * 查找参数字符串在本字符串中的第一次出现的位置，如果没有就返回-1

concat不会对原字符串产生影响。

~~~java
package com.github.demo03;

public class Demo03StringUse {
    public static void main(String[] args) {
        String str1 = "Hjoiojfojoanf";
        System.out.println(str1.length());  //13

        String str2 = "Hello";
        String str3 = "World";
        String str4 = str2.concat(str3);
        System.out.println(str4);   //HelloWorld
        System.out.println(str2);	//Hello

        System.out.println(str2.charAt(3)); //l

        System.out.println(str4.indexOf("o"));  //4
    }
}
~~~



## 6、字符串的截取

主要有两种形式

* public String substring(int index)
  * 截取从**参数位置一直到字符串末尾**，并且返回新的字符串
* public String substring(int begin, int end)
  * 截取从begin到end的中间的字符串，同样是**左闭右开**,[begin, end)

因为**str中赋的是地址值**，虽然赋了新的内容，但是字符串的内容是没有改变的，只是指向的地址的内容改变了。

~~~java
package com.github.demo03;

public class Demo03StringSUB {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = str1.substring(5);
        String str3 = str1.substring(4,7);

        System.out.println(str2);   //World
        System.out.println(str1);   // 不变
        System.out.println("-----------");
        System.out.println(str3);   //oWo
        System.out.println(str1);   //不变
        System.out.println("-----------");

        String str4 = "Hello";
        System.out.println(str4);
        str4 = "Java";
        System.out.println(str4);   //并没有改变字符串的值，只是修改了地址
    }
}
~~~



## 7、字符串的转换

常见的有三种

* public char[] toCharArray()
  * 将当前字符串拆成**字符数组**返回
* public byte[] getBytes()
  * 获得当前字符串**底层的字节数组**
* public String replace(CharSequence oldString, CharSequence newString)
  * 将所有出现的老的字符串替换成新的字符串，返回替换之后的结果的**新的字符串**





~~~java
package com.github.demo03;

public class Demo03StringConvert {
    public static void main(String[] args) {
        //转换成字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[1]);
        System.out.println(chars.length);   //5

        //转换成字节数组
        byte[] bytes = "World".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);   //87\n111\n114\n108\n100
        }

        //替换
        String str1 = "How do you do?";
        System.out.println(str1.replace("o","O"));
    }
}
~~~



## 8、字符串的分割

分割字符串的方法

public String[] split(String regex)	按照参数的规则，将字符串分割成若干部分。

注意：split方法的参数是正则表达式。如果**按照英文句点"."进行切分，需要写成"\\."**



~~~java
package com.github.demo03;

import java.lang.reflect.Array;

public class Demo03StringSplit {
    public static void main(String[] args) {
        String str1 = "aaa, bbb, ccc";
        String[] array1 = str1.split(", ");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        System.out.println("-----------");

        String str2 = "aaa.bbb.ccc";
        String[] array2 = str2.split(".");  //最后分割失败
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("-----------");

        String[] array3 = str2.split("\\.");
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
}
~~~



## 9、练习

定义一个方法，把数组{1, 2, 3}按照指定格式拼接成一个字符串，格式参照[word#1word#2word#3]

~~~java
package com.github.demo03;

public class Demo03Prac1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};

        //定义一个方法，将数组转化成字符串
        String result = arraytoString(array1);
        System.out.println(result);
    }

    public static String arraytoString(int[] array){
        String tmp = "[";
        
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                tmp += "word" + array[i] + "]";
            }else{
                tmp += "word" + array[i] + "#";
            }
        }

        return tmp;
    }
}
~~~

统计各种字符的个数

~~~java
package com.github.demo03;

import java.util.Scanner;

public class Demo03StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String input = sc.next();

        char[] chars = input.toCharArray();

        int countNum = 0;
        int countUpper = 0;
        int countLower = 0;
        int countOther = 0;

        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            if('a' <= tmp && tmp <= 'z'){
                countLower++;
            }else if('A' <= tmp && tmp <= 'Z'){
                countUpper++;
            }else if('0' <= tmp && tmp <='9'){
                countNum++;
            }else{
                countOther++;
            }
        }

        System.out.println("大写字母个数：" + countUpper);
        System.out.println("小写字母个数：" + countLower);
        System.out.println("数字个数：" + countNum);
        System.out.println("其他字符个数：" + countOther);
    }
}
~~~



# 五、静态关键字

一旦用了static关键字，这样的内容不再属于对象，而是属于类的。凡是属于本类的对象，都共享同一份。



~~~java
package com.github.demo03;

public class Student {
    private int ID;
    private String name;
    private int age;
    static String room;
    private static int idCounter = 0;

    public Student() {
        this.ID = ++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = ++idCounter;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
~~~

用static设置了room属性，一旦设置了room的值，后面的人就可以继续使用。

~~~java
package com.github.demo03;

public class Demo03Static {
    public static void main(String[] args) {
        Student stu1 = new Student("alice", 21);
        stu1.room = "图书馆一楼";
        System.out.println(stu1.getName() + "，学号为" + stu1.getID() + "，在" + stu1.room + "里。");

        Student stu2 = new Student("front", 12);
        System.out.println(stu2.getName() + "，学号为" + stu2.getID() + "，在" + stu2.room + "里。");
    }
}
~~~

## 静态关键字修饰成员

一旦使用static修饰成员方法，就成为了静态方法。静态方法不属于对象，二是属于类的。

如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用他。

如果有static关键字，那么不需要创建对象，直接就能够通过类名称访问。

无论是成员变量还是成员方法，都**推荐使用类名称进行调用**。

* 静态变量：类名称.静态变量
* 静态方法：类名称.静态方法()

注意

* **静态不能访问非静态**
  * 内存中是先有了静态的内容，才有非静态内容
* 静态方法中不能用this
  * this代表了当前对象，通过谁调用的方法，谁就是当前对象。



~~~java
package com.github.demo03;

public class Demo03MyClass {
    int num;    //成员变量
    static int statnum; //静态变量

    public void Method(){
        System.out.println("这是一个成员方法");
        //成员方法既可以访问成员变量也可以访问静态变量
        System.out.println(num);
        System.out.println(statnum);
    }

    public static  void StaticMethod(){
        System.out.println("这是一个静态方法");

        //静态方法只能访问静态变量
        System.out.println(statnum);
    }
}
~~~

~~~java
package com.github.demo03;

public class Demo03StaticMem {
    public static void main(String[] args) {
        Demo03MyClass obj = new Demo03MyClass();    //要先创建对象
        //才能使用不带static关键字的方法
        obj.Method();

        //对于静态方法，可以使用对象名和类名称进行调用，但推荐使用后者
        obj.StaticMethod(); //虽然编译后仍会生成类名称.静态方法
        Demo03MyClass.StaticMethod();

        //对于本类当中的方法，可以省去类名称
        myMethod();
        Demo03StaticMem.myMethod();

    }

    public static void myMethod(){
        System.out.println("这是我的方法");
    }
}
~~~

## 静态代码块

格式

public class 类名称{

​	static{

​		//静态代码块的内容

​	}

}

特点：当第一次用到本类时，**静态代码块执行唯一的一次**。静态内容总是优先于非静态，**静态代码块用来对静态成员变量进行赋值**。



# 六、Arrays

数组工具类。提供了大量的静态方法。

public static String toString(数组)	将参数数组变成字符串(按照标准的格式[元素1， 元素2，……， 元素n])

public static void sort(数组)	按照默认升序对数组进行排序

如果是数值，默认从小到大；是**字符串，默认按照字母升序**；自定义的类型，需要有comparable或comparator接口的支持

**要数组才能够使用**

~~~java
package com.github.demo03;

import java.util.Arrays;

public class Demo03Arrays {
    public static void main(String[] args) {
        int[] array1 = {20, 15, 62};
        String str1 = Arrays.toString(array1);
        System.out.println(str1);

        int[] array2 = {656,56,56,56,6565,6,4,13,8};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));    //需要转换为字符串才能够正常输出

    }
}
~~~

倒序输出随机的字符串

~~~java
package com.github.demo03;

import java.util.Arrays;

public class Demo03Arrays {
    public static void main(String[] args) {
     String str1 = "adafjeoijfmfajvdsdb";

     char[] chars = str1.toCharArray();

     Arrays.sort(chars);

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    
    }
}
~~~

# 七、Math类

多种重载

public static double abs(double num)	获取绝对值

public static double ceil(double num)	向上取整

public static double floor(double num)	向下取整

public static long round(double num)	四舍五入

四舍五入不带小数点；Math.PI代表圆周率Π

~~~java
System.out.println(Math.floor(3.5));
~~~





