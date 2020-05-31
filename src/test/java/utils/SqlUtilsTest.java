package utils;

import base.BaseTestClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class SqlUtilsTest extends BaseTestClass {


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