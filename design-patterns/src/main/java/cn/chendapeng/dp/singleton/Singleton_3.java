package cn.chendapeng.dp.singleton;

/**
 * lazy loading 懒汉式
 * 这种写法虽然达到了用的时候才初始化的目的，但是存在多线程获取实例时相互影响的问题
 * @author 行百里者
 */
public class Singleton_3 {
    private static Singleton_3 INSTANCE;

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_3() {
    }

    public static Singleton_3 getInstance() {
        if (INSTANCE == null) {
            // 测试，sleep一下，增加被其他线程打断的机会
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton_3();
        }
        return INSTANCE;
    }

    /**
     * for test
     */
    public static void main(String[] args) {
        //同一个类的不同对象的hashcode不同
        //跑100个线程，看看有没有不同的实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton_3.getInstance().hashCode())).start();
        }
    }
}
