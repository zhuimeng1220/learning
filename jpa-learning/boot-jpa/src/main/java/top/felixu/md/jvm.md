## 运行时数据区
java虚拟机在执行java程序时，它会将所管理的内存分为不同的区域
### 程序计数器
在内存中是一块很小的区域，是当前线程所执行的字节码的行号指示器。
特征：线程隔离，不会出现OOM异常
### 虚拟机栈
方法执行时，会为方法创建一个栈帧，用于存储局部变量表、操作数栈、动态链接、方法出口
特征：线程隔离，请求栈深度大于虚拟机允许的深度抛出StackOverflowError，允许栈扩展时，无法申请到足够内存的时候抛出OutOfMemoryError
### 本地方法栈
与虚拟机栈类似，为native方法服务
### 堆
### 方法区
