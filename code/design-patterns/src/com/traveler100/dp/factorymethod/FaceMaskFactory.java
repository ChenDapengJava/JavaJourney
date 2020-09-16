package com.traveler100.dp.factorymethod;

/**
 * @author 行百里者
 */
public class FaceMaskFactory {

    FaceMask create() {
        System.out.println("业务逻辑...");
        return new FaceMask();
    }

}
