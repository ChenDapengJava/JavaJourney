package com.traveler100.dp.chainofresposibility.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 */
public class Client {
    public static void main(String[] args) {
        Request request = new Request();
        request.reqMsg = "检查发动机，变速箱，车身有没有问题";
        Response response = new Response();
        response.respMsg = "-------response:";

        FilterChain chain = new FilterChain();
        chain.add(new EngineFilter()).add(new GearboxFilter()).add(new CarbodyFilter());
        chain.doFilter(request, response);

        System.out.println(response.respMsg);
    }
}

class Request {
    String reqMsg;
}

class Response {
    String respMsg;
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

class EngineFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain chain) {
        //先处理request请求
        if (request.reqMsg.contains("发动机")) {
            System.out.println("------EngineFilter 检查了发动机------");
        }
        //通过链条传递处理下一个request
        chain.doFilter(request, response);
        //处理response
        response.respMsg += "---执行了EngineFilter过滤器---";
    }
}

class GearboxFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (request.reqMsg.contains("变速箱")) {
            System.out.println("------GearboxFilter 检查了变速箱------");
        }
        //通过链条传递处理下一个request
        chain.doFilter(request, response);
        //处理response
        response.respMsg += "---执行了GearboxFilter过滤器---";
    }
}

class CarbodyFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (request.reqMsg.contains("车身")) {
            System.out.println("------CarbodyFilter 检查了车身------");
        }
        //通过链条传递处理下一个request
        chain.doFilter(request, response);
        //处理response
        response.respMsg += "---执行了CarbodyFilter过滤器---";
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int filterIndex = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        //如果request链条执行完了，就不往下传递了
        if (filterIndex == filters.size()) {
            return;
        }
        Filter f = filters.get(filterIndex);
        filterIndex++;
        f.doFilter(request, response, this);
    }
}



