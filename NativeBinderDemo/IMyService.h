#ifndef MY_SERVICE_DEMO
#define MY_SERVICE_DEMO
#include <stdio.h>
#include <binder/IInterface.h>
#include <binder/Parcel.h>
#include <binder/IBinder.h>
#include <binder/Binder.h>
#include <binder/ProcessState.h>
#include <binder/IPCThreadState.h>
#include <binder/IServiceManager.h>
using namespace android;
namespace android
{
    class IMyService : public IInterface
    {
    public:
        DECLARE_META_INTERFACE(MyService); //使用宏，申明MyService
        virtual void sayHello()=0; //定义方法
    };

		//定义命令字段
    enum
    {
        HELLO = 1,
    };
    
		//申明客户端BpMyService
    class BpMyService: public BpInterface<IMyService> {
    public:
    	BpMyService(const sp<IBinder>& impl);
    	virtual void sayHello();
    };

		//申明服务端BnMyService
		class BnMyService: public BnInterface<IMyService> {
		public:
			virtual status_t onTransact(uint32_t code, const Parcel& data, Parcel* reply,
					uint32_t flags = 0);
			virtual void sayHello();
		};
}
#endif

