package com.yuanhh.frameworkBinder;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class MyService extends Binder implements IMyService{ 
	

	public MyService() {
		this.attachInterface(this, DESCRIPTOR);
	}

	@Override
	public IBinder asBinder() {
		return this;
	}

	/** 将MyService转换为IMyService接口 **/
	public static com.yuanhh.frameworkBinder.IMyService asInterface(
			android.os.IBinder obj) {
		if ((obj == null)) {
			return null;
		}
		android.os.IInterface iInterface = obj.queryLocalInterface(DESCRIPTOR);
		if (((iInterface != null) && (iInterface instanceof com.yuanhh.frameworkBinder.IMyService))) {
			return ((com.yuanhh.frameworkBinder.IMyService) iInterface);
		}
		return null;
	}

	/**  服务端，接收远程消息，处理onTransact方法  **/
	@Override
	protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
			throws RemoteException {
		switch (code) {
		case INTERFACE_TRANSACTION: {
			reply.writeString(DESCRIPTOR);
			return true;
		}
		case TRANSACTION_say: {
			data.enforceInterface(DESCRIPTOR);
			String str = data.readString();
			sayHello(str);
			reply.writeNoException();
			return true;
		}
		}
		return super.onTransact(code, data, reply, flags);
	}

	/** 自定义sayHello()方法   **/
	@Override
	public void sayHello(String str) {
		System.out.println("MyService:: Hello, " + str);
	}


}
