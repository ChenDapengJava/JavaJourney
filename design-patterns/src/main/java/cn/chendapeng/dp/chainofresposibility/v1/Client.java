package cn.chendapeng.dp.chainofresposibility.v1;

/**
 * @author 行百里者
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Request req = new Request();
        req.setReqMsg("检查发动机，变速箱，车身有没有问题");
        if (req.getReqMsg().contains("车身")) {
            client.doCheckCarbody();
        }
        if (req.getReqMsg().contains("发动机")) {
            client.doCheckEngine();
        }
        if (req.getReqMsg().contains("变速箱")) {
            client.doCheckGearbox();
        }
        if (req.getReqMsg().contains("xxx")) {
            // do something
        }
    }

    public void doCheckEngine() {
        System.out.println("------检查了发动机------");
    }

    public void doCheckCarbody() {
        System.out.println("------检查了车身-------");
    }

    public void doCheckGearbox() {
        System.out.println("------检查了变速箱-----");
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



