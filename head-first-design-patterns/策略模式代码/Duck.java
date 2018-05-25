public abstract class Duck {

    FlyBehavior flyBehavior;
    public Duck(){
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();  // 不亲自处理飞行行为,而是委托给flyBehavior对象
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void swim(){
        System.out.println("All ducks float!");
    }
}