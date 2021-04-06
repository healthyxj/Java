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
