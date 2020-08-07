package com.traveler100.dp.factorymethod;

/**
 * 简单工厂 生产防护用品
 * 简单工厂的可扩展性不好，比如需要造新的防护用品的时候，需要加方法
 * @author chappell
 */
public class SimpleProtectiveEquipFactory {

    FaceMask createFaceMask() {
        return new FaceMask();
    }

    HandMask createHandMask() {
        return new HandMask();
    }

    //如果还需要生产其他防护用品，就接着写createXXX方法
}
