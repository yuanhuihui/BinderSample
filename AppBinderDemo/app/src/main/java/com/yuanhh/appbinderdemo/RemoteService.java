package com.yuanhh.appbinderdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    private static final String TAG = "BinderSimple";

    MyData mMyData;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "[RemoteService] onCreate");
        initMyData();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"[RemoteService] onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "[RemoteService] onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "[RemoteService] onDestroy");
        super.onDestroy();
    }

    /**
     * 实现IRemoteService.aidl中定义的方法
     */
    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {

        @Override
        public int getPid() throws RemoteException {
            Log.i(TAG,"[RemoteService] getPid()="+android.os.Process.myPid());
            return android.os.Process.myPid();
        }

        @Override
        public MyData getMyData() throws RemoteException {
            Log.i(TAG,"[RemoteService] getMyData()  "+ mMyData.toString());
            return mMyData;
        }

        /**此处可用于权限拦截**/
        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    };

    /**
     * 初始化MyData数据
     **/
    private void initMyData() {
        mMyData = new MyData();
        mMyData.setData1(10);
        mMyData.setData2(20);
    }
}
