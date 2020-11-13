package pers.xblzer.tryout.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: tryout
 * @description: 事务性消息生产者
 * @author: 行百里者
 * @create: 2020/11/13 23:14
 **/
public class TransactionProducer {
    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("laopo");
        producer.setNamesrvAddr("192.168.2.110:9876");

        //处理检查请求的线程池
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("client-transaction-msg-check-thread");
                        return thread;
                    }
                });

        producer.setExecutorService(executorService);

        //设置回查
        producer.setTransactionListener(new TransactionListener() {

            private AtomicInteger transactionIndex = new AtomicInteger(0);
            //用来保存事务的状态
            private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();
            //半消息发送成功触发此方法来执行本地事务
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                int value = transactionIndex.getAndIncrement();
                int status = value % 3;
                localTrans.put(message.getTransactionId(), status);

                return LocalTransactionState.UNKNOW;
            }

            //broker将发送检查消息来检查事务状态，并将调用此方法来获取本地事务状态
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                Integer status = localTrans.get(messageExt.getTransactionId());
                if (null != status) {
                    switch (status) {
                        case 0:
                            return LocalTransactionState.UNKNOW;
                        case 1:
                            return LocalTransactionState.COMMIT_MESSAGE;
                        case 2:
                            return LocalTransactionState.ROLLBACK_MESSAGE;
                    }
                }
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        //生产消息
        producer.start();
        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            Message msg =
                    new Message("girl", tags[i % tags.length], "KEY" + i,
                            ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //发送事务消息
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.printf("%s%n", sendResult);
            Thread.sleep(10);
        }
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }
        //关闭生产者实例
        producer.shutdown();
        System.out.printf("%s", "已关闭生产者实例");
    }
}
