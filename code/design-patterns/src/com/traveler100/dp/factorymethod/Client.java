package com.traveler100.dp.factorymethod;

/**
 * @author chappell
 */
public class Client {

    public static void main(String[] args) {
//        FaceMask fm = new FaceMask();
//        fm.protect();
        FaceMaskFactory factory = new FaceMaskFactory();
        factory.create().protect();
    }
}
