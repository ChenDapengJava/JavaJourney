package cn.chendapeng.dp.chainofresposibility.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 */
public class Client {
    public static void main(String[] args) {
        Request req = new Request();
        req.setReqMsg("检查发动机，变速箱，车身有没有问题");

        List<Filter> filters = new ArrayList<>();
        filters.add(new CarbodyFilter());
        filters.add(new GearboxFilter());
        filters.add(new EngineFilter());

        for (Filter f : filters) {
            f.doFilter(req);
        }
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



