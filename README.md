# BinderSample
Binder sample程序，分为app, framework, native三大类，每一类生成的可执行文件都位于/Output文件夹相应的子文件下。


|示例程序|说明|
|---|---|
|NativeBinderDemo|从Native角度编写的Binder Demo程序|
|FrameworkBinderDemo|从framework角度编写的Binder Demo程序|
|AppBinderDemo|从Apk角度编写的Binder Demo程序|

## 一、 Native Binder

### 1.1 源码结构

1. ClientDemo.cpp: 客户端程序
2. ServerDemo.cpp：服务端程序
3. IMyService.h：自定义的MyService服务的头文件
4. IMyService.cpp：自定义的MyService服务
5. Android.mk：源码build文件

### 1.2 分层图

![native_binder_demo](/_images/native_binder_demo.jpg)

### 1.3 运行

首先将这两个ServerDemo，ClientDemo可执行文件push到手机

	adb push ServerDemo /system/bin
	adb push ClientDemo /system/bin 

上面的2个文件，是由/nativeBinderDemo/路径下的代码生成的，生成的文件已经放到/Output/nativeBinderDemo/目录下。如果push不成功，那么先执行`adb remount`，再执行上面的指令；如果还不成功，可能就是权限不够。如果上述开启成功，通过开启两个窗口运行（一个运行client端，另一个运行server端）


服务端运行结果：

![native_server](/_images/native_server.png)

客户端运行结果：

![native_client](/_images/native_client.png)


## 二、 Framework Binder

### 2.1 源码结构

Server端

1. ServerDemo.java：可执行程序
2. IMyService.java: 定义IMyService接口
3. MyService.java：定义MyService

Client端

1. ClientDemo.java：可执行程序
2. IMyService.java: 与Server端完全一致
3. MyServiceProxy.java：定义MyServiceProxy


### 2.2 分层图

![framework_binder_demo](/_images/framework_binder_demo.jpg)


### 2.3 运行

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


## 三、 Apk Binder

### 3.1 源码结构

1. ClientActivity.java 本地客户端
2. RemoteService.java  远程服务端
3. IRemoteService.aidl
4. MyData.java  用于传递复杂的Parcelable数据
5. MyData.aidl

### 3.2 分层图

![app_binder_demo](/_images/app_binder_demo.jpg)

### 3.3 运行
由/AppBinderDemo/路径下的代码生成的Apk，已经放到/Output/appBinderDemo/BinderDemo.apk。

将apk安装到手机，打开apk界面如下：

![apk](/_images/apk_ui.png)

界面上有三个按钮，分别是功能分别是bindService(绑定Service), unbindService(解除绑定Service), killProcess(杀死Service进程)。

从左往右，依次点击界面，可得：

![apk](/_images/logcat_BinderSimple.png)


----------

更多关于Binder示例程序的说明，请查看文章

- [Binder系列7 —— 如何使用Binder](http://www.yuanhh.com/2015/11/22/binder-use/)
- [Binder系列8 —— 如何使用AIDL](http://www.yuanhh.com/2015/11/22/binder-aidl/)



