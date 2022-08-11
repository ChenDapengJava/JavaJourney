package cn.chendapeng.dp.factorymethod;

/**
 * @author 行百里者
 */
public class Client {

    public static void main(String[] args) {
//        FaceMask fm = new FaceMask();
//        fm.protect();
        FaceMaskFactory factory = new FaceMaskFactory();
        factory.create().protect();
    }
}
