package com.xblzer.dp.abstractfactory;

/**
 * “漂亮国”的防护口罩
 * @author 行百里者
 */
public class Rags extends ProtectiveEquip {
    @Override
    public void protect() {
        //处理其他业务逻辑。。日志等
        System.out.println("漂亮国的防护口罩，不知道能不能防护！");
    }
}
