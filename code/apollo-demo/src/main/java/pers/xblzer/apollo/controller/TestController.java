package pers.xblzer.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 行百里er
 * @date 2021-06-14 19:00
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ApolloConfig
    private Config config;

    @GetMapping("/config/expiredMinutes")
    public String getExpiredMinutes() {
        return config.getProperty("expiredMinutes", "30");
    }

    @ApolloConfigChangeListener
    private void configOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged("expiredMinutes")) {
            System.out.println("expiredMinutes发生了更新：" + config.getProperty("expiredMinutes", "30"));
        }
    }
}
