LOCAL_PATH := $(call my-dir)
 

include $(CLEAR_VARS)
LOCAL_SHARED_LIBRARIES := \
    libcutils \
    libutils \
    libbinder       
LOCAL_MODULE    := ServerDemo
LOCAL_SRC_FILES := \
    IMyService.cpp \
    ServerDemo.cpp
   
LOCAL_MODULE_TAGS := optional
include $(BUILD_EXECUTABLE)
  

include $(CLEAR_VARS)
LOCAL_SHARED_LIBRARIES := \
    libcutils \
    libutils \
    libbinder
LOCAL_MODULE    := ClientDemo
LOCAL_SRC_FILES := \
    IMyService.cpp \
    ClientDemo.cpp
LOCAL_MODULE_TAGS := optional
include $(BUILD_EXECUTABLE)
