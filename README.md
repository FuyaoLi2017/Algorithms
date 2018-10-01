# Algorithms
coursera class projects

## Method to add a additional external library
假定：有测试类f:\Test.java，它用到的lib分别是c:\abc.jar和d:\efg.jar。那么我们的编译和运行命令可以这样写
javac -cp c:\abc.jar;d:\efg.jar; f:\Test.java
java -cp c:\abc.jar;d:\efg.jar; f:\Test
注意：最后一个;后面必须要用空格把这个类和lib包分开。如果是在linux下，需要把;替换成：路径当然也要替换成linux格式的。

## Command line encoding problem
Linux下为UTF-8编码，javac编译gbk编码的java文件时，容易出现“错误: 编码UTF8的不可映射字符”解决方法是添加encoding 参数：javac -encoding gbk WordCount.java
Windows下为GBK编码，javac编译utf-8编码的java文件时，容易出现“错误: 编码GBK的不可映射字符”解决方法是添加encoding 参数：javac -encoding utf-8 WordCount.java
如果还不能解决，将其保存成ANSI编码
首先记事本打开java源文件。然后另存为，选择ANSI编码。

本文来自 不亦 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/Leytton/article/details/52740171?utm_source=copy

## Acknowledgement
参考内容：
https://github.com/huipengly/Algorithms-4th/
