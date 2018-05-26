// import java.util.Observer;
// 先自己动手,不用java内置支持,自己建立这一切会更有弹性
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();     // 主题状态改变会被调用,以通知所有观察者
}
