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
