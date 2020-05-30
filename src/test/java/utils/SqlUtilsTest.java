package utils;

import common.ConnectionInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

class SqlUtilsTest {

    private ConnectionInfo buildConnectionInfo()
    {
        ConnectionInfo connectionInfo = new ConnectionInfo ();
        connectionInfo.setUser ("root");
        connectionInfo.setPassword ("Cheng5453526");
        connectionInfo.setHost ("localhost");
        connectionInfo.setPort ("3309");
        connectionInfo.setDefaultDB ("mysql");
        return connectionInfo;
    }


    @org.junit.jupiter.api.Test
    void getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = SqlUtils.getConnection (buildConnectionInfo());
    }

    @org.junit.jupiter.api.Test
    void getIdsForm() throws SQLException, ClassNotFoundException {
        Connection connection = SqlUtils.getConnection (buildConnectionInfo());
        List idsForm = SqlUtils.getIdsForm (connection, "select * from user");
    }

    @org.junit.jupiter.api.Test
    void setBitInIds() {
        long status=0;
        status = ~(1 << 0);
        System.out.println (status);
    }
}