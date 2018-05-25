package com.company;

public class TestStackDeep{
    private static int count = 0;
    public static void recursion(long a, long b, long c){
        long e=1, f=2, g=3, h=4, i=5, j =6, k=7, l=8, m=9, n=10;
        count++;
        recursion(a,b,c);
    }
    public static void recursion(){
        count++;
        recursion();    // 递归没有出口,会出现栈溢出错误
    }
    public static void main(String[] args){
        try{
            // recurdaxiesion();
            recursion(0L, 0L, 0L);       //长整形要大写L
        }catch(Throwable e){
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }
    }
}