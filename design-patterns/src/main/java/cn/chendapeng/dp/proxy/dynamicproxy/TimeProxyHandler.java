package cn.chendapeng.dp.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 行百里者
 */
public class TimeProxyHandler implements InvocationHandler {

    private Pony pony;

    public TimeProxyHandler(Pony pony) {
        this.pony = pony;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = method.invoke(pony, args);
        long end = System.currentTimeMillis();
        System.out.println("执行耗时：" + (end - start) + "毫秒");
        return o;
    }
}
