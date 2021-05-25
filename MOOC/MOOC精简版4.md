# 六、工具类及常用算法

## 1、Java语言基础类

常用的Java库有

* java.lang Java语言的**核心类库**
  * Java是**自动导入**java.lang.*的 
* java.util 实用工具
* java.io 标准输入/输出类库
* java.awt or javax.swing 图形用户界面(GUI)的类库 
* java.net 网络功能的类库 
* java.sql 数据库访问的类库

其他的库文档可以查阅JDK API。

在线网站：http://docs.oracle.com/javase/8/docs/api/index.html

下载：http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html

网上有chm格式的，有中文版。

### Object类

* equals()
  * **==是引用是否相等，equals是内容（含义）相等**
  * 如果覆盖equals()方法，一般也要覆盖hashCode()方法
* getClass ( )
  * getClass ( )方法是**final方法，它不能被重载**
  * 返回一个对象在运行时所对应的类的表示
* toString()
  * 用来返回对象的字符串表示
  * 通过重载toString ( )方法，可以适当地显示对象的信息以进行调试
* finalize
  * 在垃圾收集前清除对象

### 基本数据类型的包装类

Java中提供了基本数据类型的**包装类 （wrapper）**，它们是这些基本类型的面向对象的代表。

基本数据类型的包装类也有8种：Character，Byte，Short，Integer，Long，Float，Double，Boolean

包装类的特点

* 都提供了一些常数
  * 如Integer.MAX_VALUE（整数最大值）， Double.NaN(非数字)，Double. POSITIVE_INFINITY（正无穷） 等。
* 提供了**valueOf(String)，toString()**
  * 用于从字符串转换及或转换成字符串。
* 通过xxxxValue()方法可以得到所包装的值
* 对象中**所包装的值是不可改变的（immutable）**
* toString(), equals()等方法进行了覆盖

JDK1.5以上，有包装（boxing)及拆包(unboxing)

~~~java
Integer I = 5;
I = Integer.valueOf(5);
~~~

### Math类

~~~java
public final static double E；// 数学常量e
public final static double PI；// 圆周率常量
public static double abs(double a)；// 绝对值
public static double exp(double a)；// 参数次幂
~~~

### System类

系统属性可以通过环境变量来获得

* System.getProperty(String name)方法获得特定的系统属性值 
* System.getProperties()方法获得一个 Properties类的对象，其中包含了所 有可用的系统属性信息

~~~java
package com.mooc.week7.TestObject;

/*主要是使用Properties存储属性信息，然后使用枚举获取属性名*/

import java.util.Enumeration;
import java.util.Properties;

public class SystemProperty {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        Enumeration keys = prop.propertyNames();    //枚举的键用keys表示

        while(keys.hasMoreElements()){
            String key = (String) keys.nextElement();
            System.out.println(key + " = " + System.getProperty(key));
        }
    }
}
~~~



## 2、字符串和日期

字符串可以分为两大类

* String类 
  * 创建之后不会再做修改和变动，即 **immutable** 
  * String 类对象保存不可修改(immutable)的Unicode字符序列
  * 下述方法能**创建并返回一个新的String对象实例**: concat, replace,  replaceAll, substring, toLowerCase, toUpperCase, trim,toString.
* StringBuffer、StringBuilder类 
  * 创建之后允许再做更改和变化 
  * 其中 StringBuilder是JDK1.5增加的，它是非线程安全的

~~~java
package com.mooc.week7.StringAndDate;

/*这个程序是为了比较循环中String和StringBuffer的效率*/

public class StringAndStringBuffer {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        StringBuffer sb = new StringBuffer();

        final int t = 10000;

        long t0 = System.currentTimeMillis();
        for (int i = 0; i < t; i++) {
            s2 += s1;
        }

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < t; i++) {
            sb.append(s1);
        }
        long t2 = System.currentTimeMillis();

        System.out.println(t1 - t0);    //31，可见循环中使用String的+=会带来效率问题
        System.out.println(t2 - t1);    //0
    }
}
~~~



### 字符串常量

注意String常量的内部化（interned） 问题，即同样的字符串常量是合并的（是指向同一个引用的）

**“abc” != new String(“abc”)**

~~~java
package com.mooc.week7.StringAndDate;

public class StringAssign {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");

        System.out.println("s1 == s2: " + (s1 == s2) + "    s1.equals(s2): " + s1.equals(s2));

        String s3 = new String(new StringBuffer("hello"));
        String s4 = new StringBuffer("hello").toString();

        System.out.println("s3 == s4: " + (s3 == s4) + "    s3.equals(s4): " + s3.equals(s4));

        String s5 = new Object().toString();
        String s6 = "" + new Object();

        System.out.println("s5 == s6: " + (s5 == s6) + "    s5.equals(s6): " + s5.equals(s6));

        /*结果
        s1 == s2: false    s1.equals(s2): true
        s3 == s4: false    s3.equals(s4): true
        s5 == s6: false    s5.equals(s6): false
        */
    }
}
~~~



### 字符串的分割

java.util.StringTokenizer类提供了对字符串进行分割的功能

构造方法

~~~java
StringTokenizer(String str, String delim);
~~~

~~~java
package com.mooc.week7.StringAndDate;

public class StringTokenizer {

    public static void main(String[] args) {
        java.util.StringTokenizer st = new java.util.StringTokenizer("This is a test", " ");
        while(st.hasMoreTokens()){
            System.out.print(st.nextToken() + " ");
        }

        st = new java.util.StringTokenizer("192.168.1.1", ".");
        while(st.hasMoreTokens()){
            System.out.print(st.nextToken() + " ");
        }
    }
}
~~~



### Format函数

Jdk1.5 增加了format函数，%1$,8.5f %序号$ 标识 宽度及精度 转换方式

~~~java
package com.mooc.week7.StringAndDate;

import java.util.Date;

public class StringFormat {
    public static void main(String[] args) {
        String s = String.format("整数字 %1$,09d 浮点 %2$9.3f 字符串 %3$-10s 日期 %4$tF%4$tT",
                1234, Math.PI, "hello", new Date());
        System.out.println(s);  //整数字 00001,234 浮点     3.142 字符串 hello      日期 2021-05-2213:42:37
    }
}
~~~

### 日期类

Calendar得到一个实例

Calendar.getInstance()

~~~java
.get(DAY_OF_MONTH) 
.getDisplayName(DAY_OF_WEEK)
.set 
.add(HOUR,1) 
.roll(MONTH, 5), 
.setTime(date), 
.getTime()
~~~

date类

~~~java
new Date(), new Date(System.currentTimeMillis())
.setTime(long), 
.getTime()
~~~

## 3、集合类

Collection API提供“集合”“收集”的功能，包含一系列的接口和类

Collection接口：有两个子接口

* List: (Collection的子接口)**记录元素的保存顺序，且允许有重复元素**
* Set: (Collection的子接口) 不记录元素的保存顺序，且不允许有重复元素

Map接口

是键值对(key-value)的集合

### List接口

是线性表(Linear List)，主要的实现类是 ArrayList. LinkedList， 以及早期的Vector。

~~~java
package com.mooc.week7.Collection;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList h = new ArrayList();
        h.add("1st");
        h.add("2nd");
        h.add(new Integer(3));
        h.add(new Double(5.22));
        h.add("2nd");
        h.add(new Integer(7));
        System.out.println(h);  //[1st, 2nd, 3, 5.22, 2nd, 7]
    }
}
~~~

迭代器 Iterator

重要的是hasNext和next

~~~java
Iterator iterator = iterable.iterator();

~~~

~~~java
package com.mooc.week7.Collection;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Photo> album = new LinkedList<>();

        album.add(new Photo("one",new Date(), "classroom"));
        album.add(new Photo("two", new Date(), "library"));
        album.add(new Photo("three", new Date(), "gym"));
        album.add(new Photo("four", new Date(), "dorm"));

        Iterator<Photo> iterator = album.iterator();
        while(iterator.hasNext()){
            Photo photo = iterator.next();
            System.out.println(photo.toString());
        }

        for(Photo photo: album){
            System.out.println(photo);
        }
    }
}
~~~



### 增强型的for语句

~~~java
for( Element e : list ) doSomething(e);
~~~

### stack

遵循“后进先出”(Last In First Out, LIFO)原则

包含三个方法

* public Object push(Object item)：将指定对象压入栈中。 
* Public Object pop()：将栈最上面的元素从栈中取出，并返回这个对象。 
* public boolean empty()：判断栈中没有对象元素。

~~~java
package com.mooc.week7.Collection;

import java.util.Stack;

public class Stacks {	//要是Stacks否则会报错
    static String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December" };
    public static void main(String[] args) {
        Stack stk = new Stack();
        for (int i = 0; i < months.length; i++) {
            stk.push(months[i] + " ");
        }

        System.out.println("stk= " + stk);
        System.out.println("Popping elements: ");
        while(!stk.empty()){
            System.out.println(stk.pop());
        }
    }
}
~~~



### 队列

遵循“先进先出”(First In First Out，FIFO)的原则。固定在一端输入数据(称为入队)，另一端输出数据(称为出队)。

~~~
Vector， 现多用 ArrayList
	相当于动态数组(比JDK1.0中的 ArrayList好), elementAt, 
• Stack， 现多用 LinkedList
	Stack是Vector的子类, push, pop, peek
• Hashtable， 现多用 HashMap
	Hashtable实现Map接口, 参见Properties类
• Enumeration， 现多用Iterator
	Enumeration用另一种方式实现Iterator的功能
	如Vector可以得到枚举器
	Enumeration<E> e = v.elements(); 
	while(e.hasMoreElements()) doSomething(e.nextElement()
~~~

queue的入是offer，出是poll

~~~java
package com.mooc.week7.Collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            q.offer(i);
        }

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
~~~

### set集

两个重要的实现 HashSet及TreeSet，其中**TreeSet的底层是用TreeMap来实现的**。

Map集

* Map是键-值对的集合 
  * 其中可以取到entrySet()、keySet()、values()、 
  * Map.Entry是一个嵌套接口 
* Map类的重要实现 
  * HashMap类 
  * TreeMap类：用红黑树的算法

~~~java
package com.mooc.week7.Collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();    //用Treemap定义二维(参数)的map
        map.put("b", "Brazil");
        map.put("r", "Russia");
        map.put("i", "India");
        map.put("c", "China");
        map.put("k", "South Africa");

        System.out.println(map.get("c"));   //索引, 结果是China

        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));  //key值是随机的
        }

        for(String value : map.values()){
            System.out.println(value);
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
~~~



## 4、排序和查找

* 自编程序排序与查找
  * 如冒泡排序 、选择排序 、快速排序等
* 系统已有的排序与查找
  * 如 Arrays类及Collections类

### Arrays类

用于对数组进行排序和搜索的类。Arrays类**提供了sort()和binarySearch()**。

执行binarySearch()之前应调用sort() 

~~~java
package com.mooc.week7.SortAndSearch;

import java.util.Arrays;
import java.util.Random;

public class TestArraysSort {
    static Random r = new Random();
    static String ssource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static char[] src = ssource.toCharArray();

    static String randString(int length){
        char[] buf = new char[length];
        for (int i = 0; i < length; i++) {
            int rnd = Math.abs(r.nextInt()) % src.length;
            buf[i] = src[rnd];
        }
        return new String(buf);
    }

    //生成随机的字符串数组
    static String[] randStrings(int length, int size){
        String[] s = new String[size];
        for (int i = 0; i < size; i++) {
            s[i] = randString(length);
        }
        return s;
    }

    public static void print(String[] s){
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] s = randStrings(4, 6);
        print(s);
        Arrays.<String>sort(s);
        print(s);
        int loc = Arrays.<String>binarySearch(s, s[2]);
        System.out.println("Location of" + s[2] + " is " + loc);
    }
}
~~~

### Comparator



~~~java
package com.mooc.week7.SortAndSearch.TestCollectionsSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {
    public static void main(String[] args) {
        List<Person> school = new ArrayList<>();
        school.add( new Person("Li",23));
        school.add( new Person("Wang",28));
        school.add( new Person("Zhang",21));
        school.add( new Person("Tang",19));
        school.add( new Person("Chen",22));
        school.add( new Person("Zhao",22));
        System.out.println( school );

        Collections.sort(school, new PersonComparator());   //根据年龄进行排序
        System.out.println(school);

        int index = Collections.binarySearch(school, new Person("Li", 26),new PersonComparator());
        if(index > 0){
            System.out.println(school.get(index));
        }else{
            System.out.println("Not Found");
        }
    }
}
~~~

## 5、泛型

泛型（Generic）是JDK1.5增加的最重要的Java语言特性。使用泛型可以针对不同的类有相同的处理办法

使用泛型的好处 

* 类型更安全 
* 适用更广泛，针对不同的类有相同的处理办法，但这些类之间不一定有继承关系。

~~~java
package com.mooc.week7.Generic;

import java.util.ArrayList;

public class GenericTreeClass {
    public static void main(String[] args) {
        TNode<String> child = new TNode<>("Roo");
        child.add("aaa");
        child.add("bbb");
        child.add("ccc");

        child.getChild(0).add("ddd");
        System.out.println(child.getChild(0).getValue());   //结果为aaa,可以看出初始的不计入数组数
        child.getChild(0).add("eee");

        child.traverse();   //结果是R,a,d,e,b,c
    }
}

class TNode<T>{
    private T value;
    private ArrayList<TNode<T>> children = new ArrayList<>();

    public TNode(T value) {
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void add(T value){
        TNode<T> child = new TNode<>(value);
        this.children.add(child);
    }

    public TNode<T> getChild(int i){
        if((i < 0) || (i > this.children.size())) return null;
        return (TNode<T>)this.children.get(i);
    }

    public void traverse(){
        System.out.println(this.value);
        for(TNode child : this.children){
            child.traverse();
        }
    }
}
~~~



### 协变与逆变

协变(Covariance) ? extends T

~~~
GenericCovariance.java
• 原因：ListArray<Apple>不是ListArray<Fruit>的子类
• 但又想让<Apple>当作<Fruit>
• 就声明ListArray<? extends Fruit>
~~~

逆变(Contravariance) ? super T

~~~
GenericContrvariance.java
• 原因：Basket<Apple>不是Basket<Fruit>的子类
• 但又想让Comparator<Fruit>用于Comparator<Apple>
• 就声明Comparator<? super Fruit>
~~~

## 6、常用算法

遍试、迭代、递归和回溯

### 遍试

遍试也是穷举，exhaust algorithm。在有限的范围内，可以对所有的值都进行试验和判断，从而找到满足条件的值

### 迭代

iterative algorithm是**多次利用同一公式**进行计算，每次将计算的结果再代入公式进行计算，从而逐步逼近精确解。

### 递归

递归(recursive)就是一个过程调用过程本身。 在递归调用中，**一个过程执行的某一步要用到它的上一步(或上几步)的结果**。

### 回溯

back-track，试探回溯法，先选择某一可能的线索进行试探，每一步试探都有多种方式，将每一方式都一一试探，如果不符合条件就返回纠正，反复进行这种试探再返回纠正，直到得出全部符合条件的答案或是问题无解为止。

# 七、多线程

进程：一个程序的执行 

线程：程序中单个顺序的流控制称为线程

一个进程中可以含有多个线程，这些线程分享CPU(并发的或以时间片的方式)，并且共享内存(多个线程访问同一对象)

## 1、线程的创建

线程体---- run()方法来实现的，**线程启动后，系统就自动调用run()方法**。

创建线程的两种方法

* 通过继承Thread类创建线程

  * ~~~java
    class MyThread extends Thread {
    	public void run() {
    		for(int i=0;i<100;i++) {
    			System.out.print (" " + i);
            }
        }
    }    
    ~~~

* 通过向Thread()构造方法**传递Runnable对象**来创建线程

  * ~~~java
    class MyTask implements Runnable {
    	public void run() { …}
    }
    
    Thread thread = new Thread(mytask);
    thread.start();
    ~~~

### 匿名类及lambda表达式

可用匿名类来实现Runnable

~~~java
package com.mooc.week8.thread;

//一个是在{}里写run方法，一个是在()写λ表达式
public class TestThread4Anonymous {
    public static void main(String[] args) {

        new Thread(){
            public void run(){
                for (int i = 0; i < 5; i++) {
                    System.out.println("ID: 1 " + "No." + i);
//                    try{
//                        Thread.sleep(100);
//                    }catch (InterruptedException e){}
                }
            }
        }.start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
~~~

## 2、线程的控制

线程的状态与生命周期，可以类比操作系统中的进程。

### 对线程的基本控制

* 线程的启动 
  * start() 
* 线程的结束 
  * **设定一个标记变量**，以结束相应的循环及方法。 
* 暂时阻止线程的执行 
  * try{ Thread.sleep( 1000 );} catch( InterruptedException e ){ }

### 线程的优先级

设定线程的优先级，setPriority( int priority)方法

MIN_PRIORITY，MAX_PRIORITY，NORM_PRIORITY

### 后台线程

线程有两种 

* 一类是普通线程（非Daemon线程） 
  * 在Java程序中，若还有非Demon线程，则整个程序就不会结束 
* 一类是Daemon线程（守护线程，后台线程） 
  * 如果普通线程结束了，则后台线程自动终止 
  * 注：垃圾回收线程是后台线程

## 3、线程的同步

线程的不确定性

同时运行的线程需要共享数据、 就必须考虑其它线程的状态与行为，这时就需要实现同步

Java引入了**对象互斥锁**的概念，来保证共享数据操作的完整性。

每个对象都对应于一个monitor（监视器），它上面一个称为“**互斥锁 （lock, mutex)**”的标记，这个标记用来保证在任一时刻，只能有一个线程访 问该对象。

关键字synchronized 用来与对象的互斥锁联系

### synchronized

用法

* 对代码片段
  * synchronized(对象){ 。。。。}
* 对某个方法
  * synchronized 放在方法声明中， 
  * public synchronized void push(char c ){ 。。。。}  
  * 相当于对synchronized(this), 表示整个方法为同步方法。

### 线程的同步控制

使用**wait()方法可以释放对象锁**

使用notify()或notifyAll()可以让等待的一个或所有线程进入就绪状态

Java里面可以将wait和notify放在synchronized里面，在synchronized代码被执行期间，线程调用对象的wait()方法，会释放对象锁标志，然后进入等待状态，然后由其它线程调用notify()或者notifyAll()方法通知正在等待的线程。

### 死锁



## 4、并发API

java.util.concurrent包及其子包，几个实用的类：单变量、集合、Timer、线程池

### 原子变量

java.util.concurrent.atomic 包 

* AtomicInteger 类 
* getAndIncrement（）方法

### 集合与线程

在JDK1.5以前 

* ArrayList/HashMap不是线程安全的 
  * **Vector及Hashtable是线程安全的**
* 产生一个线程安全的集合对象
  * Collections.synchronizedArrayList(list)

### 并发的集合类

java.util.concurrent包中增加了一些方便的类

* CopyOnWriteArrayList、 CopyOnWriteArraySet 
  * 适合于很少写入而读取频繁的对象 
* ConcurrentHashMap 
  * putIfAbsent(), remove(), replace()
* ArrayBlockingQueue 
  * 生产者与消费者，使用put()及take(

### 使用线程池

线程池相关的类：ExecutorService 接口、ThreadPoolExecutor 类 、Executors 工具类

### 使用Timer

**java.util.Timer是用于重复做某事。javax.swing.Timer重复执行ActionListener类**。

在线程中更新图形化界面，要调用SwingUtilites.invokeLater

### 显示锁



## 5、流式操作及并行的流

因为集合是常见的任务，需要抽取出来。

将常见的集合上的操作抽取出来，并能连续地进行操作，就有了流的概念。java.util.stream支持在流上的函数式风格的操作

### 得到流与操作流

得到流

~~~java
Stream<T> stream = collection.stream();
~~~

* 对于数组 
  * Arrays.stream(ary) 
* 对于collection (包括List) 
  * 用 list.stream() 
* 对于Map 
  * 没有流，但提供了类似的方法 
    * 如map.putIfAbsent 
    * map.computeIfPresent 
    * map.merge

操作流

~~~java
int sumOfWeights = blocks.stream();

//可以对数组进行流化
Arrays.stream(a)
    .filter(i->i > 20)
~~~

Lambda实现了函数式编程

### stream的操作种类

分两类

* 中间的
  * 中间的操作保持流打开状态，并允许后续的操作
* 末端的



### 流的并行计算

只需将stream换成parallestream即可



中间的操作

~~~
filter - 排除所有与断言不匹配的元素。
• map - 通过Function对元素执行一对一的转换。
• flatMap - 通过FlatMapper将每个元素转变为无或更多的元素。
• peek - 对每个遇到的元素执行一些操作。主要对调试很有用。
• distinct - 根据.equals行为排除所有重复的元素。这是一个有状态的操作。
• sorted - 确保流中的元素在后续的操作中，按照比较器（Comparator）决定的顺序访问。这是
一个有状态的操作。
• limit - 保证后续的操作所能看到的最大数量的元素。
• substream - 确保后续的操作只能看到一个范围的（根据index）元素。
• skip- 忽略一些元素
• mapToDouble mapToInt mapToLong 类型转换
~~~

末端的操作

~~~
forEach - 对流中的每个元素执行一些操作。
• toArray - 将流中的元素倾倒入一个数组。
• min - 根据一个比较器找到流中元素的最小值。
• max -根据一个比较器找到流中元素的最大值。
• count - 计算流中元素的数量。
• anyMatch - 判断流中是否至少有一个元素匹配断言。这是一个短路的操作。
• allMatch - 判断流中是否每一个元素都匹配断言。这是一个短路的操作。
• noneMatch - 判断流中是否没有一个元素匹配断言。这是一个短路的操作。
• findFirst - 查找流中的第一个元素。这是一个短路的操作。
• findAny - 查找流中的任意元素，可能对某些流要比findFirst代价低。这是一个短路的操作。
• 注：子接口还有更多的操作，如 average等
~~~

