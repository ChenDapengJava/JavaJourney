package cn.chendapeng.dp.observer.v2;

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

    public void fire () {
        System.out.println("朝鲜：我要发射了！Boom！！！");
        observers.forEach(observer -> observer.onFire());
    }
}

interface Observer {
    void onFire();
}

class China implements Observer {
    public void warn () {
        System.out.println("中国：不要在我家门口玩火，否则后果自负！");
    }

    @Override
    public void onFire() {
        warn();
    }
}

class Usa implements Observer {
    public void threaten () {
        System.out.println("美国：韩国小老弟来我们军事演练走一波！");
    }

    @Override
    public void onFire() {
        threaten();
    }
}


