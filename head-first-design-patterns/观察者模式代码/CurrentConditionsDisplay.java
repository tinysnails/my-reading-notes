public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private  float temperature;
    private float humidity;
    private Subject weatherData;    //接口对象,无论Subject如何实现,代码不受影响

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;                 // 保存对Subject的引用为了以后取消注册使用
//        System.out.println(this);
        weatherData.registerObserver(this);         //构造器需要weatherData对象作为注册使用
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        // update调用起来后, 将参数保存,调用display方法
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions: " + this.temperature + "F degree and" + this.humidity + "%humidity");
    }
}
