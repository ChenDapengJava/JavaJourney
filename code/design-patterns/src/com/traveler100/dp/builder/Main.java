package com.traveler100.dp.builder;

/**
 * @author 行百里者
 */
public class Main {
    public static void main(String[] args) {
//        Employee e = new Employee.EmployeeBuilder()
//                .basicInfo("张三", 18, "男")
//                .height(178)
//                .weight(65)
//                //.level("初级")
//                .build();
//        System.out.println(e);

        StringBuilder sb = new StringBuilder();
        sb.append("下蛋公鸡").append(",").append("公鸡中的战斗鸡！");
        System.out.println(sb.toString());
    }
}
