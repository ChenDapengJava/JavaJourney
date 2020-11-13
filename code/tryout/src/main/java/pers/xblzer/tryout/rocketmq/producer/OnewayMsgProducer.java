package pers.xblzer.tryout.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @program: tryout
 * @description: 单向发送消息的Producer
 * @author: 行百里者
 * @create: 2020/11/10 21:03
 **/
public class OnewayMsgProducer {
    public static void main(String[] args) throws Exception {
        //实例化消息生产者，参数是producerGroup
        DefaultMQProducer producer = new DefaultMQProducer("laogong");
        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.2.110:9876");
        //启动producer
        producer.start();

        for (int i = 0; i < 100; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("xiaoxianrou" ,
                    "TagA",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 发送单向消息，没有任何返回结果
            producer.sendOneway(msg);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
