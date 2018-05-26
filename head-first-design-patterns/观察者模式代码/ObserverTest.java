public class ObserverTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        ChineseConditionsDisplay chineseConditionsDisplay = new ChineseConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.printObservers();       //打印出目前观察者列表里的观察者
        weatherData.removeObserver(chineseConditionsDisplay);       //移除一个
        System.out.println("移除一个对象后:");
        weatherData.printObservers();       //打印出目前观察者列表里的观察者

    }
}
