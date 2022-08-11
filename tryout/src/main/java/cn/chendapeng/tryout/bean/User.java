package cn.chendapeng.tryout.bean;

/**
 * @author 行百里者
 * @date 2022-08-03 10:47
 */
public class User {
    private Integer id;
    private String userName;
    private String phoneNumber;

    public User() {
    }

    public User(Integer id, String userName, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public void myDefine() {
        System.out.println("xxx");
    }
}
