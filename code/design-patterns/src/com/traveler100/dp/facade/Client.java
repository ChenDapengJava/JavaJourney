package com.traveler100.dp.facade;

/**
 * @author chappell
 */
public class Client {
    public static void main(String[] args) {
//        //一定要按照这个顺序去办证，否则拿不到证
//        StuffDept sd = new StuffDept();
//        sd.makeStuff();
//        CheckDept cd = new CheckDept();
//        cd.checkStuff();
//        IssueDept id = new IssueDept();
//        id.issueCert();
        NetApp facade = new NetApp();
        facade.doItJustOnce();
    }
}
