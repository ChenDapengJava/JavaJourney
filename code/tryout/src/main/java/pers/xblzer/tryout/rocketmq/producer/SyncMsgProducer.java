package pers.xblzer.tryout.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: tryout
 * @description: Producer发送同步消息
 * @author: 行百里者
 * @create: 2020/11/10 18:05
 **/
public class SyncMsgProducer {
    public static void main(String[] args) throws Exception {
        //实例化消息生产者，参数是producerGroup
        DefaultMQProducer producer = new DefaultMQProducer("laogong");
        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.2.110:9876");
        //启动producer
        producer.start();

        //发送消息
//        Message msg = new Message("xiaoxianrou", "这是我的第一次".getBytes());
//        SendResult sendResult = producer.send(msg);
//        System.out.printf("%s%n", sendResult);
        //批量发送
        List<Message> msgs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("xiaoxianrou", ("这是我的第" + i + "次").getBytes());
            msgs.add(msg);
        }
        SendResult sendResult = producer.send(msgs);
        System.out.printf("%s%n", sendResult);

        //关闭producer
        producer.shutdown();
        System.out.println("已关闭producer实例");
    }
}
