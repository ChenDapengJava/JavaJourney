package com.traveler100.dp.builder;

/**
 * @author 行百里者
 */
public class Employee {
    private String name;
    private Integer age;
    private String sex;
    private Integer height;
    private Integer weight;
    private String address;
    private String level;
    //...还有很多属性

    //私有的构造方法
    private Employee(){

    }

    public static class EmployeeBuilder{
        Employee employee = new Employee();

        public EmployeeBuilder basicInfo(String name, Integer age, String sex){
            employee.name = name;
            employee.age = age;
            employee.sex = sex;
            return this;
        }

        public EmployeeBuilder height(Integer height){
            employee.height = height;
            return this;
        }

        public EmployeeBuilder weight(Integer weight){
            employee.weight = weight;
            return this;
        }

        public EmployeeBuilder address(String address){
            employee.address = address;
            return this;
        }

        public EmployeeBuilder level(String level){
            employee.level = level;
            return this;
        }

        public Employee build(){
            return employee;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
