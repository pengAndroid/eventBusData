package com.example.lzpeng.eventtest;

/**
 * desc :   event事件的传递消息类
 * author : lzPeng
 * time : 2018/4/27 19:27
 */

class ObjEvent {

    private String name;
    private String age;

    public ObjEvent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
