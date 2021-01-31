#  一、IDEA

IDE (integrated development environment) 集成开发环境。

~~~
回顾java开发程序的步骤
编写代码-启动cmd-调用javac进行编译-调用java运行
~~~

Intellij IDEA

## 项目结构

项目(project)-模块(module)-包(package)

创建文件时，先选择左上角file。然后选择左下角的empty project。选择好路径后就是创建module，点击➕，选择new module。左边保持默认是java，直接next。输入module名称，finish。

创建后，左边有project。点击project名称左边的三角形箭头，会出现src文件夹和一个iml文件。<b>所有代码要放在src文件夹下</b>，而iml仅是IDEA的一些相关信息。与project平行的有一个external libraries，其实是JDK，一般也用不上，但是要有。

点击src，右键new-package，输入包名称。包名称只能由英文字母、点和数字组成。如com.github.day01.demo01。因为包是一组文件夹的名称，是一个多层级文件夹的嵌套。因此顺序是代码-->day01-->github-->com

如果需要导入module，就可以右键import进行导入

## 用IDEA写helloworld文件

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

## 基本配置

在左上角的File-Settings可以进行设置。

* 字体
  * Editor-Font，可以调整size，令size为16
* 自动补全
  * 代码中出现红颜色的就是错误的
  * Keymap（所有快捷键）界面下，小齿轮选择dumplicate会生成default copy。找到Main menu-code-completion，选择basic，右键remove。然后add keyboard shortcut为alt+斜杠/，不用担心重复，因为另一个选项用不着。

## 常用快捷键

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



## 方法的复习

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

## 方法的定义

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

## 方法的调用

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





