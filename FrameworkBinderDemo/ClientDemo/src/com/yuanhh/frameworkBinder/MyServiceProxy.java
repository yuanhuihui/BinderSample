package com.yuanhh.frameworkBinder;

import android.os.IBinder;
import android.os.RemoteException;

public class MyServiceProxy implements IMyService {
	private android.os.IBinder mRemote;  //代表BpBinder

	public MyServiceProxy(android.os.IBinder remote) {
		mRemote = remote;
	}

	public java.lang.String getInterfaceDescriptor() {
		return DESCRIPTOR;
	}

	/** 自定义的sayHello()方法   **/
	@Override
	public void sayHello(String str) throws RemoteException {
		android.os.Parcel _data = android.os.Parcel.obtain();
		android.os.Parcel _reply = android.os.Parcel.obtain();
		try {
			_data.writeInterfaceToken(DESCRIPTOR);
			_data.writeString(str);
			mRemote.transact(TRANSACTION_say, _data, _reply, 0);
			_reply.readException();
		} finally {
			_reply.recycle();
			_data.recycle();
		}
	}

	@Override
	public IBinder asBinder() {
		return mRemote;
	}

}
