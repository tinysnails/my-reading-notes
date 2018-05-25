//package com.company;

public class LocalVariableEffectGC {
    // 申请空间后,立即申请被gc回收,但是byte数组被 变量a 引用,所以无法回收
    public void localvarGc1(){
        byte[] a = new byte[6*1024*2014];
        System.gc();
    }

    // gc前, 将a设置为null, byte数组失去引用, 故可以顺利回收
    public void localvarGc2(){
        byte[] a = new byte[6*1024*2014];
        a = null;
        System.gc();
    }

    // 虽然gc前, 局部变量a已经失效, 但是变量a仍然存在局部变量表上, 并且指向该数组, 所以byte数组仍然不能回收
    public void localvarGc3(){
        {
            byte[] a = new byte[6*1024*2014];
        }
        System.gc();
    }

    // gc前不仅使a 失效, 还声明了变量c, 是变量c复用了变量a的字, 由于变量a被销毁, gc可以成功回收
    public void localvarGc4(){
        {
            byte[] a = new byte[6*1024*2014];
        }
        int c = 10;
        System.gc();
    }

    // 首先调用了localvarGc1, 在localvarGc1中并未释放byte数组, 但是调用返回后, 它的栈帧被销毁,
    // 自然也包含了栈帧中的所有局部变量, 故byte数组失去了引用, gc成功
    public void localvarGc5(){
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args){
        LocalVariableEffectGC ins = new LocalVariableEffectGC();
        ins.localvarGc2();
    }
}
