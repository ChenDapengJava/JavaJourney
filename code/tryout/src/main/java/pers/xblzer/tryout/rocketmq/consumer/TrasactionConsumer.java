package pers.xblzer.tryout.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @program: tryout
 * @description: 事务消息消费者
 * @author: 行百里者
 * @create: 2020/11/10 22:04
 **/
public class TrasactionConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("laopo-consumer");
        consumer.setNamesrvAddr("192.168.2.110:9876");

        //订阅topic，消费TagB的消息
        consumer.subscribe("girl", "TagB");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动Consumer实例
        consumer.start();
        System.out.println("consumer started.");
    }
}
