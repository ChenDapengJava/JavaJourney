package cn.chendapeng.dp.proxy.staticproxy;

/**
 * @author 行百里者
 */
public class TimeProxy implements Painter {

    private Painter painter;

    public TimeProxy(Painter painter) {
        this.painter = painter;
    }

    @Override
    public void paint() {
        long start = System.currentTimeMillis();
        //调用小马画画
        painter.paint();
        long end = System.currentTimeMillis();
        System.out.println("paint 画画耗时：" + (end - start) + "毫秒");
    }
}
