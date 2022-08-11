package cn.chendapeng.zookeeper.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * 默认的ZK watcher
 * @author 行百里者
 * @since 2020/09/16 10:18
 **/
public class DefaultWatcher implements Watcher {

    private CountDownLatch latch;

    public DefaultWatcher() {
    }

    public DefaultWatcher(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("DefaultWatcher watchedEvent:" + watchedEvent);
        Event.KeeperState state = watchedEvent.getState();
        switch (state) {
            case Disconnected:
                break;
            case SyncConnected:
                System.out.println("SyncConnected.");
                //连接成功后，执行countDown，此时便可以拿zk对象使用了
                latch.countDown();
                break;
            case AuthFailed:
                break;
            case ConnectedReadOnly:
                break;
            case SaslAuthenticated:
                break;
            case Expired:
                break;
            case Closed:
                break;
            default:
                break;
        }
    }
}
