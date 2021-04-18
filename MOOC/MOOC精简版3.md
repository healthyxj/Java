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
