package com.company;

public class ReuseLocalVariableTableSlot{
    // 示例1: a,b都作用到函数的末尾, 故b无法复用a所在位置
    public void localvar1(){
        int a = 0;
        System.out.println(a);
        int b = 0;
    }
    // 示例2: 局部变量a位作用到函数最后, 局部变量 b复用a的槽位(int是1个字.)
    // 实例方法第一个局部变量都是this
    public void localval2(){
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 0;
    }
    public static void main(String[] args){
        ReuseLocalVariableTableSlot reuse = new ReuseLocalVariableTableSlot();
        reuse.localvar1();
        reuse.localval2();
    }
}