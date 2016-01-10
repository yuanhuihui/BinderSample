## Apk Binder

### 分层图

![app_binder_demo](/_images/app_binder_demo.jpg)

### 运行
由/AppBinderDemo/路径下的代码生成的Apk，已经放到/Output/appBinderDemo/BinderDemo.apk。

将apk安装到手机，打开apk界面如下：

![apk](/_images/apk_ui.png)

界面上有三个按钮，分别是功能分别是bindService(绑定Service), unbindService(解除绑定Service), killProcess(杀死Service进程)。

从左往右，依次点击界面，可得：

![apk](/_images/logcat_BinderSimple.png)


----------

更多关于Binder示例程序的说明，请查看文章[Binder系列8 —— 如何使用AIDL](http://www.yuanhh.com/2015/11/23/binder-aidl/)



