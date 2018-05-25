//package com.company;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftRefQ {
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

    static ReferenceQueue<User> softQueue = null;
    public static class CheckRefQueue extends Thread{
        @Override
        public void run(){
            while(true){
                if(softQueue != null){
                    UserSoftReference obj = null;
                    try{
                        obj = (UserSoftReference) softQueue.remove();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if (obj != null)
                        System.out.println("user id " + obj.uid +" is delete!" );
                }
            }
        }
    }

    public static class UserSoftReference extends SoftReference<User>{
        // 实现一个自定义的软引用类，扩展软引用的目的是记录User.id,后续在引用队列中，通过这个uid字段知道那个User实例被回收了
        int uid;
        public UserSoftReference(User referent, ReferenceQueue<? super User> q){
            /*
            泛型三种：
          [1]ArrayList<T> al=new ArrayList<T>();指定集合元素只能是T类型
          [2]ArrayList<?> al=new ArrayList<?>();集合元素可以是任意类型，这种没有意义，一般是方法中，只是为了说明用法
          [3]ArrayList<? extends E> al=new ArrayList<? extends E>();
            泛型的限定：
               ? extends E:接收E类型或者E的子类型。
               ？super E:接收E类型或者E的父类型
             */
            super(referent, q);
            uid = referent.id;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);  // ???
        t.start();
        User u = new User(1,"game");
        softQueue = new ReferenceQueue<User>();
        // 创建软引用时，制定了一个软引用队列，当给定对像被回收时，就会被加入到这个引用队列，通过访问该队列，可以跟踪对象的回收情况
        UserSoftReference  userSoftRef = new UserSoftReference(u, softQueue);
        u = null;
        System.out.println(userSoftRef.get());
        System.gc();
        // 内存足够，不被回收
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());

        System.out.println("try to create byte array and GC");
        byte[] b = new byte[1024 * 925*7];
        System.gc();
        System.out.println(userSoftRef.get());

        Thread.sleep(1000);
    }
}
