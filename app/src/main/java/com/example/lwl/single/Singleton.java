package com.example.lwl.single;

/**
 * Created by lwl on 2017/5/24.
 * 单例模式
 */
public class Singleton {
    private volatile static Singleton instance;

    public Singleton(){

    }

    //获取单例
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
