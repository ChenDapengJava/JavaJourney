package cn.chendapeng.dp.proxy.springaop;

/**
 * @author 行百里者
 */
public class LogProxy {
    public void before() {
        System.out.println("日志：开始作画");
    }

    public void after() {
        System.out.println("日志：画完了");
    }
}
