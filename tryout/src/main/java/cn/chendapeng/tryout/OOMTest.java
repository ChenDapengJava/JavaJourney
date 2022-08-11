package cn.chendapeng.tryout;

//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试OOM
 * @author 行百里者
 * @since 2020/11/01 14:39
 **/
public class OOMTest {
    //定时任务线程池
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(24,
            //new ThreadFactoryBuilder().setNameFormat("处理告警信息线程-%d").build(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("program starts");
        executor.setMaximumPoolSize(50);
        //业务处理
        while (true) {
            //获取告警列表
            List<AlarmInfo> list = getAlarmList();
            list.forEach(alarmInfo -> {
                executor.scheduleWithFixedDelay(() -> {
                    alarmInfo.alarmCheck();
                }, 2, 3, TimeUnit.SECONDS);
            });
            Thread.sleep(100);
        }
    }

    //模拟获取告警列表
    private static List<AlarmInfo> getAlarmList() {
        List<AlarmInfo> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            AlarmInfo alarmInfo = new AlarmInfo();
            alarmInfo.setId(i);
            alarmInfo.setAlarmType("type" + i);
            alarmInfo.setAlarmTime(new Date());
            alarmInfo.setDuration(new BigDecimal(new Random().nextInt(10000)));
            list.add(alarmInfo);
        }
        return list;
    }

    //模拟告警数据
//    @Data
    public static class AlarmInfo {
        private Integer id;
        private String alarmType;
        private Date alarmTime;
        private BigDecimal duration;

        //处理业务逻辑
        public void alarmCheck() {
            //System.out.println("do something");
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public void setAlarmTime(Date alarmTime) {
            this.alarmTime = alarmTime;
        }

        public void setDuration(BigDecimal duration) {
            this.duration = duration;
        }
    }
}
