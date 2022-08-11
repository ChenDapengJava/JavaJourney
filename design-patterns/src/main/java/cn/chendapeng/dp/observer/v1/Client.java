package cn.chendapeng.dp.observer.v1;

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

    China china = new China();
    Usa usa = new Usa();

    public void fire () {
        System.out.println("朝鲜：发射核弹！");
        china.warn();
        usa.threaten();
    }
}

class China {
    public void warn () {
        System.out.println("中国：不要在我家门口玩火，否则后果自负！");
    }
}

class Usa {
    public void threaten () {
        System.out.println("美国：韩国小老弟来我们军事演练走一波！");
    }
}


