package cn.chendapeng.dp.factorymethod;

/**
 * 口罩 类
 * @author 行百里者
 */
public class FaceMask extends ProtectiveEquip {

    @Override
    public void protect() {
        System.out.println("face masks don't let the virus enter");
    }
}
