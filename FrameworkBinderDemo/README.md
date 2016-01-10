## Framework Binder

### 分层图

![framework_binder_demo](/_images/framework_binder_demo.jpg)


### 运行

首先将ServerDemo，ClientDemo可执行文件，以及ServerDemo.jar，ClientDemo.jar都push到手机。

	adb push ServerDemo /system/bin
	adb push ClientDemo /system/bin
	adb push ServerDemo.jar /system/framework
	adb push ClientDemo.jar /system/framework 

上面的4个文件，是由/FrameworkBinderDemo/路径下的代码生成的，生成的文件已经放到/Output/frameworkBinderDemo/目录下。


服务端运行结果：

![framework_server](/_images/framework_server.png)

客户端运行结果：

![framework_client](/_images/framework_client.png)


更多关于Binder示例程序的说明，请查看文章[Binder系列7 —— 如何使用Binder](http://www.yuanhh.com/2015/11/22/binder-use/)




