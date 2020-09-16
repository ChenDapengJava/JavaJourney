package com.traveler100.test.zookeeperdemo.conf;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @program: demo
 * @description: 配置watch和callback
 * @author: 行百里者
 * @create: 2020/09/16 10:31
 **/
public class WatchAndCallback implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {

    private ZooKeeper zk;
    private MyConfig config;
    CountDownLatch latch = new CountDownLatch(1);

    public void await() {
        zk.exists("/userServiceConf", this, this, "exists watch");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * DataCallback
     * 此回调用于检索节点的数据和stat
     * @param rc 调用返回的code或结果
     * @param path 传递给异步调用的路径
     * @param ctx 传递给异步调用的上下文对象
     * @param data 节点的数据
     * @param stat 指定节点的Stat对象
     * @author 行百里者
     * @create 2020/9/16 10:42
     **/
    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        if (data != null) {
            String res = new String(data);
            config.setUserServiceIP(res);
            latch.countDown();
        }
    }

    /**
     * StatCallback
     * 此回调用于检索节点的stat
     * @param rc 调用返回的code或结果
     * @param path 传递给异步调用的路径
     * @param ctx 传递给异步调用的上下文对象
     * @param stat 指定路径上节点的Stat对象
     * @author 行百里者
     * @create 2020/9/16 10:39
     **/
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if (stat != null) {
            zk.getData("/userServiceConf", this, this, "Msg:Stat is not null");
        }
    }

    /**
     * Watcher接口的实现。
     * Watcher接口指定事件处理程序类必须实现的公共接口。
     * ZooKeeper客户机将从它连接到的ZooKeeper服务器获取各种事件。
     * 使用这种客户机的应用程序通过向客户机注册回调对象来处理这些事件。
     * 回调对象应该是实现监视器接口的类的实例。
     * @param watchedEvent WatchedEvent表示监视者能够响应的ZooKeeper上的更改。WatchedEvent包含发生了什么，ZooKeeper的当前状态，以及事件中涉及的znode的路径。
     * @author 行百里者
     * @create 2020/9/16 10:45
     **/
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                //当一个node被创建后，获取node
                //getData中又会触发StatCallback的回调processResult
                zk.getData("/userServiceConf", this, this, "Msg:NodeCreated");
                break;
            case NodeDeleted:
                //节点被删除
                config.setUserServiceIP("");
                //重新开启CountDownLatch
                latch = new CountDownLatch(1);
                break;
            case NodeDataChanged:
                //节点数据被改变了
                //会触发DataCallback的回调
                zk.getData("/userServiceConf", this, this, "Msg:NodeDataChanged");
                break;
            case NodeChildrenChanged:
                break;
            case DataWatchRemoved:
                break;
            case ChildWatchRemoved:
                break;
            case PersistentWatchRemoved:
                break;
        }
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public MyConfig getConfig() {
        return config;
    }

    public void setConfig(MyConfig config) {
        this.config = config;
    }
}
