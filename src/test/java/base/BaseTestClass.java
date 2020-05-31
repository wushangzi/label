package base;

import common.ConnectionInfo;

/**
 * @author chengyongjun
 * @date 5/31/20 3:35 AM
 */
public class BaseTestClass {
    protected ConnectionInfo buildConnectionInfo()
    {
        ConnectionInfo connectionInfo = new ConnectionInfo ();
        connectionInfo.setUser ("root");
        connectionInfo.setPassword ("Cheng5453526");
        connectionInfo.setHost ("localhost");
        connectionInfo.setPort ("3309");
        connectionInfo.setDefaultDB ("my");
        return connectionInfo;
    }
}
