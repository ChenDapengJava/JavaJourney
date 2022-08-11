package cn.chendapeng.dp.observer.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 */
public class Client {
    public static void main(String[] args) {
        Korea k = new Korea();
        k.fire();
    }
}

class Korea {

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new China());
        observers.add(new Usa());
    }

    public void fire() {
        System.out.println("朝鲜：我要发射了！Boom！！！");
        //事件发生了
        FireEvent fireEvent = new FireEvent(System.currentTimeMillis(), "夏威夷", this);
        observers.forEach(observer -> observer.onFire(fireEvent));
    }
}

/**
 * 抽象出事件类
 *
 * @param <T>
 */
abstract class Event<T> {
    abstract T getSource();
}

/**
 * 发射核弹事件，事件源是Korea
 */
class FireEvent extends Event<Korea> {

    //事件发生时间
    long timestamp;
    //事件发生地点
    String location;
    //事件源
    private Korea korea;

    public FireEvent(long timestamp, String location, Korea korea) {
        this.timestamp = timestamp;
        this.location = location;
        this.korea = korea;
    }

    @Override
    public Korea getSource() {
        return korea;
    }
}

/**
 * 观察者
 */
interface Observer {
    //观察者根据事件作出响应
    void onFire(FireEvent fireEvent);
}

class China implements Observer {
    public void warn() {
        System.out.println("中国：不要在我家门口玩火，否则后果自负！");
    }

    @Override
    public void onFire(FireEvent fireEvent) {
        if (fireEvent.location.contains("鸭绿江")) {
            warn();
        }
    }
}

class Usa implements Observer {
    public void threaten() {
        System.out.println("美国：韩国小老弟来我们军事演练走一波！");
    }

    @Override
    public void onFire(FireEvent fireEvent) {
        if (fireEvent.location.contains("夏威夷")) {
            threaten();
        }
    }
}


