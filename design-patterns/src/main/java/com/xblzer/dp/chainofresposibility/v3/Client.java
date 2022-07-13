package com.xblzer.dp.chainofresposibility.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 */
public class Client {
    public static void main(String[] args) {
        Request req = new Request();
        req.setReqMsg("检查发动机，变速箱，车身有没有问题");

        FilterChain chain = new FilterChain();
        chain.add(new EngineFilter())
                .add(new GearboxFilter())
                .add(new CarbodyFilter())
                .doFilter(req);
//        chain.add(new EngineFilter());
//        chain.add(new GearboxFilter());
//        chain.add(new CarbodyFilter());
//        chain.doFilter(req);
    }
}

class Request {
    private String reqMsg;

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }
}

interface Filter {
    boolean doFilter(Request request);
}

class EngineFilter implements Filter {
    @Override
    public boolean doFilter(Request request) {
        if (request.getReqMsg().contains("发动机")) {
            System.out.println("------检查了发动机------");
        }
        return true;
    }
}

class GearboxFilter implements Filter {
    @Override
    public boolean doFilter(Request request) {
        if (request.getReqMsg().contains("变速箱")) {
            System.out.println("------检查了变速箱------");
        }
        return true;
    }
}

class CarbodyFilter implements Filter {
    @Override
    public boolean doFilter(Request request) {
        if (request.getReqMsg().contains("车身")) {
            System.out.println("------检查了车身------");
        }
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    //比较骚的写法，这样可以链式调用
    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }
    //一般写法
//    public void add(Filter filter) {
//        filters.add(filter);
//    }

    @Override
    public boolean doFilter(Request request) {
        for (Filter f : filters) {
            //任何一环检查出了问题，均不往下检查
            if (!f.doFilter(request)) {
                return false;
            }
        }
        return true;
    }
}



