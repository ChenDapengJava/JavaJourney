package cn.chendapeng.zookeeper.config;

/**
 * 自定义配置，根据实际业务自定义
 * @author 行百里者
 * @since 2020/09/16 10:28
 **/
public class MyConfig {

    private String userServiceConf;

    public String getuserServiceConf() {
        return userServiceConf;
    }

    public void setuserServiceConf(String userServiceConf) {
        this.userServiceConf = userServiceConf;
    }
}
