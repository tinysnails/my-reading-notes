//package com.company;

public class OnStackTest {
    public static class User{
        // 实例需要16字节
        public int id = 0;
        public String name="";
    }

    public static void alloc(){
        User u = new User();
        u.id = 5;
        u.name = "gyem";
    }

    public static void main(String[] args){
        long b = System.currentTimeMillis();
        // 循环1亿次,累计分配空间1.5GB, 设置堆空间最大为-Xmx:10m, 如果分配到堆上,会大量GC
        // 使用-XX:+PrintGC 打印GC日志
        for (int i = 0; i < 100000000; i++){
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
