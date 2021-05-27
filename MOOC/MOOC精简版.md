# 八、流、文件及基于文本的应用

把不同类型的输入、输出都抽象为流（Stream)

## 1、输入输出流

按流的方向，可分为输入流与输出流。

从JDK1.4起，加了 java.nio 包， JDK1.7 作了改进，称nio2

字节流和字符流是不同的

|      |    字节流    | 字符流 |
| :--: | :----------: | :----: |
| 输入 | InputStream  | Reader |
| 输出 | OutputStream | Writer |

### 字节流

InputStream类的read()方法，**逐字节地以二进制的原始方式读取数据**

OutputStream类的write()方法，**将字节写入流中**。

~~~java
public void flush ()； 刷新缓存，实际写入到文件、网络
public void close()； 关闭流
~~~

### 字符流

Reader类与InputStream类相似，但差别在于Reader类读取的是字符（char），而不是字节。

~~~java
• public void write (int b)；// 将参数b的低两字节写入到输出流
• public void write (char b[])；// 将字符数组b[]中的全部字节顺序写入到输出流
• public void write(char[] b, int off, int len)；// 将字节数组b[]中从off开始的len个字节写入到流中
• public void write( String s)；// 将字符串写入流中
• public void write( String s, int off, int len)；// 将字符串写入流中, off为位置，len为长度
• public void flush ()；// 刷新流
• public void close()；// 关闭流
~~~

### 节点流和处理流

* 节点流（Node Stream） 
  * 直接与节点(如文件)相连
  * 可以从或向一个特定的地方（节点）读写数据 
  * 如文件流 FileInputStream，内存流 ByteArrayInputStream
* 处理流（Processing Stream） 
  * 对节点流或其他处理流进一步进行处理
  * 是**对一个已存在的流的连接和封装**，处理流又称为过滤流（Filter) 
  * 如缓冲处理流 BufferedReader



![](img/节点流和处理流1.jpg)

### 流的包装(链接)

~~~java
BufferedReader in = new BufferedReader(new FileReader(file));
BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), “utf-8”));
s = in2.readLine();
~~~



### 标准输入与输出

因为输出的是字节，所以都是字节流inputstream。

为了使用方便，经常**将System.in用各种处理流进行封装处理**。

~~~java
BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) );
br.readLine();
~~~



### 常见内容的读写

常见的内容有二进制、文本和对象

* 字符的读写，
  * 常见的编码有UTF-8, ASCII, GB2312, 默认编码
  * 使用java.nio.file.Files的readAllLines()方法
* 对象的读写
  * ObjectInputStream， ObjectOutputStream
* 基本数据的读写
  * DataInputStream, DataOutputStream
* 序列化（serialize）与反序列化（ deserialize）
  * 要求对象实现 Serializable 接口



### 网络流





## 2、文件及目录

java.io包中定义与数据输入、输出功能有关的类，包括提供文件操作功能的File类。

### 文件类

创建file对象

~~~java
File f;
f = new File("Test.java");
f = new File("E:\\ex\\","Test.java");
~~~

在Java中，**将目录（directory, 文件夹)也当作文件处理**。

常见方法有

~~~java
关于文件/目录名操作
String getName()
String getPath()
String getAbsolutePath()
String getParent()
boolean renameTo(File newName)
    
File 测试操作
boolean exists()
boolean canWrite()
boolean canRead()
boolean isFile()
boolean isDirectory()
boolean isAbsolute();
    
获取常规文件信息操作 
long lastModified() 
long length() 
boolean delete
    
目录操作 
boolean mkdir() 
String[] li
~~~

### RandomAccessFile类

RandomAccessFile，可以实现对文件的随机读写操作



## 3、正则表达式

**Regular Expressions**

它实际上是用来**匹配字符串**的一种模式。主要的应用包括：匹配验证、分割、查找、替换

### 写法

字符{数量}位置

[0-9]{2,4}\b 可以匹配 123 1988 2015 16

### 基本元素

| 字符 | 含义                 | 描述                                                         |
| ---- | -------------------- | ------------------------------------------------------------ |
| .    | 代表一个字符的通配符 | 能和回车符之外的任何字符相匹配                               |
| []   | 字符集               | 能和括号内的任何一个字符相匹配。方括号内也可以表示 一个范围，用“—”符号将起始和末尾字符区分开来， 例如[0-9] |
| [^]  | 排斥性字符集         | 和集合之外的任意字符匹                                       |
| ^    | 起始位置             | 定位到一行的起始处并向后匹配                                 |
| $    | 结束位置             | 定位到一行的结尾处并向前匹配                                 |
| \b   | 单词边界             |                                                              |
| \B   | 非单词边界           |                                                              |
| ()   | 组                   | 按照子表达式进行分组                                         |
| \|   | 或                   | 或关系的逻辑选择，通常和组结合使用                           |
| \    | 转义                 | 匹配反斜线符号之后的字符，所以可以匹配一些特殊符号， 例如$和\| |

### 数量

| 符号 | 含义      |
| ---- | --------- |
| *    | 0个或多个 |
| +    | 1个或多个 |
| ？   | 零个或1个 |
| n    | 重复      |

### 字符

\d，表示0到9的数字，相当于[0,9]

\D，表示非数字[ ^0, 9 ]

\s，表示空白符

\S，表示非空白符

\w，表示单词字符

\W，表示非单词字符

**大写表示非**。

## 4、pattern类

java.util.regex包主要的类有

Pattern类，Matcher类

### 分割

**对以逗号和/或空格分隔的输入字符串进行切分**

~~~java
Pattern p = Pattern.compile( "[, \\s]+");
String[] result = p.split( "one,two, three four , five ");

for (int i=0; i<result.length; i++)
	System.out.println(result[i]);
~~~

### 匹配

可以判断一个email地址是否合法

要求是

email地址在@的前面有多个非@的字符，在@之后，需要一些由点（.） 隔开的一些单词字符（\w）。要注意\在java的源程序的字符串中要写成\\

~~~java
String pattern = "^[^@]+@[\\w]+(\\.[\\w]+)*$";

String email = "dstang2000@263.net";

boolean ok = Pattern.matches( pattern, email );

~~~

### 替换

Match类

通过**调用某个模式（Pattern对象）的matcher方法可以得到Matcher对象**

Match的方法

* find方法将扫描输入序列，寻找下一个与模式匹配的地方。 
* appendReplacement方法

Matcher中的group

* 所谓group（分组），是指**正则表达式中一对圆括号括起来的一部分**
* group(0)或group()表示整个匹配项，group(1)、group(2)…表示各个分组
* 替换时，$0表示整个匹配项，$1、$2…表示各个分组（圆括号）

# 九、图形用户界面

图形用户界面(graphical user interface，GUI)

有两个库可以实现图形用户界面，分别是

* **AWT： abstract window toolkit(抽象窗口工具集) **
* Swing 是JDK1.2以后版本所引入的。功能更强，界面更丰富。 
* 各种平台上更统一，它是轻量级的（lightweight，即all-Java language) 

主要的包是java.awt包和javax.swing包



## 1、组件

swt组件分类，java中构成图形用户界面的各种元素，称为组件(component)

组件又分为容器和非容器两大类。

容器又分为顶层容器和非顶层容器

### component

是所有组件和容器的抽象父类，

其中定义了所有组件都有可能用到的方法

### swing顶层容器

顶层容器(top-level)，由jframe，jdialog，japplet

容器都有ADD方法。

### swing组件

jcomponent是非顶层容器，也是容器，都有add(子组件)

有很多方法，比如setToolTipText



## 2、★★★实现界面的三部曲

* **创建组件(component)**
  * 创建组成界面的各种元素，如按钮、文本框等
* **指定布局(layout)**
  * 根据具体需要排列它们的位置关系
* **响应事件(event)**
  * 定义图形用户界面的事件和各界面元素对不同事件的响应，从而实现图形用户界面与用户的交互功能



## 3、布局管理

java.awt中定义了多种布局管理器

常见的有三种

* flowlayout
* borderlayout
* gridlayout

### flowlayout布局管理器

注意事项

* 对组件逐行定位，行内从左到右，一行排满后换行 
* 默认对齐方式为居中对齐 
* 不改变组件的大小，按组件原有尺寸显示组件 
* FlowLayout是**Panel类的默认布局管理器**

可以在构造方法中设置不同的组件间距、行距以及对齐方式

* new FlowLayout(FlowLayout.RIGHT,20,40);
  * 表示右对齐，组件之间的水平间距为20个像素，竖直间距为40个像素
* new FlowLayout();
  * 使用缺省的居中对齐方式，水平和竖直间距为缺省值：5；

### borderlayout布局管理器

注意事项

* BorderLayout将整个容器的布局划分成东、西、南、北、中五个区域，组件只能被添加到指定的区域 
* 如不指定组件的加入部位，则**默认加入到Center区域** 
* 每个区域只能加入一个组件，如加入多个，则先前加入的组件会被遗弃 
* BorderLayout是**Frame类的默认布局管理器**



### gridlayout布局管理器

* GridLayout型布局管理器**将布局划分成规则的矩形网格**，每个单元格区域大小相等. 
* 组件被添加到每个单元格中，先从左到右添满一行后换行，再从上到下.  
* 在GridLayout构造方法中指定分割的行数和列数. 
  * new GridLayout(4,5);

### 绝对布局

一般流程

* 对象.setLocation(100,20); 
* 对象.setSize(80,20); (或用setBounds同时设定四个参数) 
* 容器.setLayout(null); 
* 容器.add(对象);

location size layout add

## 4、事件处理

事件及事件监听器

* 事件（Event） 
  * 鼠标、键盘、布局改变等等操作等
* 事件监听器（Event Listener) 
  * 对这些事件作出响应的程序

~~~java

~~~

### 事件监听器

event listener是一些事件的**接口**

* 是 AWTEventListener的子接口
* 接口中含有相关的方法
  * MouseMotionListener 是对鼠标移动事件的处理的接口，它含有两个重要的方法： 
    * void mouseDragged (MouseEvent e)；// 处理鼠标拖动的方法 
    * void mouseMoved (MouseEvent e)；// 处理鼠标移动的方法

### Event包含的信息

最重要的有： 

* 事件源（即产生事件的组件） 
  * getSource() 
  * 得到的Object可以强制类型转换成相应的类型 
* 事件的具体情况
  * 如MouseEvent 的 getX(), getY() 方法得到鼠标的坐标 
  * KeyEvent 的 getKeyChar() 得到当前的字符等。

### 事件适配器

事件适配器类（Adapter）----简化实现Listener

在extends事件适配器时，只需要Override自己所需要的方法即可



### 注册事件监听器 

事件的注册 addxxxxListener 

监听器的实现有两种方法 

* **implements xxxListener** 
  * 具体写其中的每个方法 
* **extends xxxAdapter** 
  * 其中Adapter是Listener的默认实现，每个方法的方法体为空 
  * Adapter可以只Override其中重要的方法



## 5、常用组件的处理

常用组件有

* 标签、按钮 与动作事件 
  * JLabel Jbutton ActionListener 
* 文本框、文本区域 与文本事件 
  * JTextField JTextArea JPasswordField JFormattedTextField Text:istener 
* 单、复选按钮，列表 与选择事件 
  * JRadioButton JCheckbox JList JComboBox ItemListener 
* 滚动条与调整事件 
  * JScrollBar JScrollPane AdjustmentListener 
* 画布与鼠标、键盘事件 
  * Canvas JComponent KeyListener MouseListener 
* Panel与容器事件 
  * JPanel ComponentListener

### 强功能的组件

* JTextPane
  * 可以编辑文本、网页、RTF
* JScrollPane 
  * 能自动滚动

### 标准对话框

* JOptionPane的4种方法 
  * showConfirmDialog --- 确认对话框，提出问题，然后由用户自己来确认（按"Yes"或 "No"按钮） 
  * showInputDialog --- 提示输入文本 
  * showMessageDialog --- 显示信息 
  * showOptionDialog -－ 组合其它三个对话框类型 
* JFileChooser 
  * 文件选择器 
* JColorChooser 
  * 颜色选择器

### 菜单和工具栏



### 小技巧

* 焦点 
  
  * 对象.requestFocus(); 
  
* 处理按键 
	* ~~~ java
    
    textMaxScores.addKeyListener(new KeyAdapter (){
    	public void keyPressed( KeyEvent e){
          if(e.getKeyCode()==KeyEvent.VK_LEFT){......}
	      }  	
	  }); 
    
	  ~~~
	
* 线程中操作界面

  * SwingUtilites.invokeLater(…)

