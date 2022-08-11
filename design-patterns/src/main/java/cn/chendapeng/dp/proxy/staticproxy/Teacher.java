package cn.chendapeng.dp.proxy.staticproxy;

/**
 * @author 行百里者
 * @since 2020.5.22
 */
public class Teacher {
    public static void main(String[] args) {

        //new TimeProxy(new Puppy()).paint();
        new TimeProxy(new LogProxy(new Puppy())).paint();
    }
}
