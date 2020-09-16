package com.traveler100.dp.proxy.staticproxy;

/**
 * @author chappell
 */
public class LogProxy implements Painter {

    private Painter painter;

    public LogProxy(Painter painter) {
        this.painter = painter;
    }

    @Override
    public void paint() {
        System.out.println("日志：开始作画");
        painter.paint();
        System.out.println("日志：画完了");
    }
}
