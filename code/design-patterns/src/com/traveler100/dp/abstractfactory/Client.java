package com.traveler100.dp.abstractfactory;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chappell
 */
public class Client {

    public static void main(String[] args) {
//        BaseFactory factory = new HumanFactory();
//        //BaseFactory factory = new UsaFactory();
//
//        Food food = factory.createFood();
//        food.printName();
//        ProtectiveEquip protectiveEquip = factory.createProtectiveEquip();
//        protectiveEquip.protect();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        Rice rice = (Rice) ctx.getBean("rice");
        rice.printName();
    }
}
