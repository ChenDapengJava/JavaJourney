package com.traveler100.dp.factorymethod;

/**
 * @author chappell
 */
public class FaceMaskFactory {

    FaceMask create() {
        System.out.println("业务逻辑...");
        return new FaceMask();
    }

}
