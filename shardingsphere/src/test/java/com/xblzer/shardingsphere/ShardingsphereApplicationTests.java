package com.xblzer.shardingsphere;

import cn.chendapeng.shardingsphere.bean.Laogong;
import cn.chendapeng.shardingsphere.mapper.LaogongMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Autowired
    private LaogongMapper laogongMapper;

    @Test
    public void testMSInsert(){
        for (int i = 1; i <= 5; i++) {
            Laogong laogong = new Laogong();
            laogong.setId(i);
            laogong.setName("xblzer" + i);
            laogong.setAge(new Random().nextInt(30));
            laogongMapper.addLaogong(laogong);
        }
    }

    @Test
    public void testMSQuery(){
        for (int i = 0; i < 10; i++) {
            Laogong laogong = laogongMapper.queryLaogong(1);
            System.out.println(laogong);
        }
    }

    @Test
    public void test() {
        System.out.println(new Random().nextInt(20));
    }

}
