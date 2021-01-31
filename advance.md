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





