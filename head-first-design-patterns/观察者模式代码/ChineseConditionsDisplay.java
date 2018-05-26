public class ChineseConditionsDisplay implements Observer, DisplayElement{
    private  float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ChineseConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("温度是:" + this.temperature + "湿度是: " + this.humidity + "气压是: " + this.pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
