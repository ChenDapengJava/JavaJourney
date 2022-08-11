package cn.chendapeng.dp.singleton;

/**
 * 和Singleton_1是同一个意思
 * 只是将new的动作放在了代码块里
 * 类加载到内存的时候只加载一个实例
 * @author 行百里者
 */
public class Singleton_2 {
    private static final Singleton_2 INSTANCE;

    static {
        INSTANCE = new Singleton_2();
    }

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_2() {
    }

    public static Singleton_2 getInstance() {
        return INSTANCE;
    }

    /**
     * for test
     */
    public static void main(String[] args) {
        Singleton_2 instance1 = Singleton_2.getInstance();
        Singleton_2 instance2 = Singleton_2.getInstance();
        System.out.println(instance1 == instance2);
    }
}
