//package com.company;

import java.lang.ref.WeakReference;

public class WeakRef {
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
        WeakReference<User> userWeakRef = new WeakReference<User>(u);
        u=null;
        System.out.println(userWeakRef.get());
        System.gc();
        // 不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After gc");
        System.out.println(userWeakRef.get());

    }
}
