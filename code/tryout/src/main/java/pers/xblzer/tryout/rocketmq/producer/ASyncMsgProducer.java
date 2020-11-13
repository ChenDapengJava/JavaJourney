package pers.xblzer.tryout.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: tryout
 * @description: Producer发送异步消息
 * @author: 行百里者
 * @create: 2020/11/10 18:05
 **/
public class ASyncMsgProducer {
    public static void main(String[] args) throws Exception {
        //实例化消息生产者，参数是producerGroup
        DefaultMQProducer producer = new DefaultMQProducer("laogong");
        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.2.110:9876");
        //启动producer
        producer.start();
        //设置发送失败时的重试次数
        producer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount = 100;
        // 根据消息数量实例化倒计时计算器
        final CountDownLatch2 countDownLatch = new CountDownLatch2(messageCount);
        for (int i = 50; i < messageCount; i++) {
            final int index = i;
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("xiaoxianrou",
                    "TagB",
                    "OrderID288",
                    ("laogong" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            msg.putUserProperty("money", String.valueOf(i));
            // SendCallback接收异步返回结果的回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        // 等待5s
        countDownLatch.await(5, TimeUnit.SECONDS);
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
