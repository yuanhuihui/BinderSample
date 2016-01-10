#include "IMyService.h"

int main() {
	sp < IServiceManager > sm = defaultServiceManager(); //获取service manager引用
	sp < IBinder > binder = sm->getService(String16("service.myservice"));//获取名为"service.myservice"的binder接口
	sp<IMyService> cs = interface_cast < IMyService > (binder);//将biner对象转换为强引用类型的IMyService
	cs->sayHello();//利用binder引用调用远程sayHello()方法
	return 0;
}
