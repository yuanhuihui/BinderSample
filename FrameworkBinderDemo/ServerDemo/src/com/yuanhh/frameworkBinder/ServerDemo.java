package com.yuanhh.frameworkBinder;

import android.os.Looper;
import android.os.ServiceManager;

public class ServerDemo {

	public static void main(String[] args) {
		System.out.println("MyService Start");
		Looper.prepareMainLooper(); //开启循环执行
		android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_FOREGROUND); //设置为前台优先级
		ServiceManager.addService("MyService", new MyService());//注册服务
		Looper.loop();
	}

}
