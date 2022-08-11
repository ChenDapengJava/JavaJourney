package cn.chendapeng.dp.facade;

/**
 * “中国式办证”所需的“门面”部门，负责统一处理各部门的事情，
 * Client只需要调“门面”的doItJustOnce方法即可
 *
 * @author 行百里者
 */
public class NetApp {
    private StuffDept stuffDept = new StuffDept();
    private CheckDept checkDept = new CheckDept();
    private IssueDept issueDept = new IssueDept();

    public void doItJustOnce() {
        stuffDept.makeStuff();
        checkDept.checkStuff();
        issueDept.issueCert();
    }
}
