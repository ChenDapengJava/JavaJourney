package com.traveler100.test.zookeeperdemo;

import com.traveler100.test.zookeeperdemo.conf.MyConfig;
import com.traveler100.test.zookeeperdemo.conf.WatchAndCallback;
import com.traveler100.test.zookeeperdemo.zk.DefaultWatcher;
import lombok.SneakyThrows;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description: ZK Test
 * @author: 行百里者
 * @create: 2020/09/16 10:24
 **/
//@SpringBootTest
public class ZooKeeperConfigTest {
//    @Value("zookeeper.conf-servers")
//    static String servers;
    static String servers = "192.168.134.136:2181,192.168.134.137:2181,192.168.134.140:2181,192.168.134.141:2181/conf";

    static ZooKeeper zk;

    static CountDownLatch latch = new CountDownLatch(1);

    @SneakyThrows
    @BeforeAll
    public static void getZK() {
        System.out.println("servers:" + servers);
        //因为是异步的，所以要await，等到连接上zk集群之后再进行后续操作
        zk = new ZooKeeper(servers, 3000, new DefaultWatcher(latch));
        latch.await();
    }

    @SneakyThrows
    @AfterAll
    public static void close() {
        zk.close();
    }

    @Test
    public void zkConfigTest() {
        WatchAndCallback watchAndCallback = new WatchAndCallback();
        MyConfig config = new MyConfig();
        watchAndCallback.setConfig(config);
        watchAndCallback.setZk(zk);

        //阻塞等待
        watchAndCallback.await();

        //方便观测，写个死循环
        for(;;) {
            if (config.getUserServiceIP().equals("")) {
                System.out.println("node可能被删除了");
                //此时应该阻塞住，等待着node重新创建
                watchAndCallback.await();
            } else {
                System.out.println("userServiceIP:" + config.getUserServiceIP());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
