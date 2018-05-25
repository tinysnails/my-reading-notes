//package com.company;
//  使用-Xmx10m 运行
import java.lang.ref.SoftReference;

public class SoftRef {
    public static class User{
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        byte[] b = new byte[1024*975*3];        //这个对像比较大
        public int id;
        public String name;

        @Override
        public String toString(){
            return "[id = " + String.valueOf(id) + ", name = " + String.valueOf(name) + "]";
        }
    }

    public static void main(String[] args){
        User u = new User(1, "game");
        SoftReference<User> userSoftRefer = new SoftReference<User>(u);
        u = null;

        System.out.println(userSoftRefer.get());
        System.gc();
        System.out.println("after gc");
        System.out.println(userSoftRefer.get());

        byte[] b = new byte[1024*985*7];    // 分配较大一块内存，系统认为内存紧张，就会回收仅有软引用的对象
        System.gc();
        System.out.println(userSoftRefer.get());
    }

}
