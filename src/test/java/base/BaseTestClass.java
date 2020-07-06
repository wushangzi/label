package base;

import common.ConnectionInfo;

import java.util.ArrayDeque;
import java.util.concurrent.*;

/**
 * @author chengyongjun
 * @date 5/31/20 3:35 AM
 */
public class BaseTestClass {
    protected ConnectionInfo buildConnectionInfo() {
        ConnectionInfo connectionInfo = new ConnectionInfo ();
        connectionInfo.setUser ("root");
        connectionInfo.setPassword ("Cheng5453526");
        connectionInfo.setHost ("localhost");
        connectionInfo.setPort ("3309");
        connectionInfo.setDefaultDB ("my");
        return connectionInfo;
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor (
                5, 10, 0, TimeUnit.DAYS,
                new ArrayBlockingQueue<> (100), r -> {
                    Thread thread = new Thread (r);
                    thread.setDaemon (true);
                    return thread;
                });
        executorService.execute (() -> System.out.println ("1234"));
    }
}
