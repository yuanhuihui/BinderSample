## Native Binder

### 分层图

![native_binder_demo](/_images/native_binder_demo.jpg)

### 运行

首先将这两个ServerDemo，ClientDemo可执行文件push到手机

	adb push ServerDemo /system/bin
	adb push ClientDemo /system/bin 

上面的2个文件，是由/nativeBinderDemo/路径下的代码生成的，生成的文件已经放到/Output/nativeBinderDemo/目录下。如果push不成功，那么先执行`adb remount`，再执行上面的指令；如果还不成功，可能就是权限不够。如果上述开启成功，通过开启两个窗口运行（一个运行client端，另一个运行server端）


服务端运行结果：

![native_server](/_images/native_server.png)

客户端运行结果：

![native_client](/_images/native_client.png)



----------

更多关于Binder示例程序的说明，请查看文章[Binder系列7 —— 如何使用Binder](http://www.yuanhh.com/2015/11/22/binder-use/)




