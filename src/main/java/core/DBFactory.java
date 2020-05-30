package core;

import common.ConnectionInfo;

import java.sql.Connection;

/**
 * @author chengyongjun
 * @date 5/29/20 6:52 AM
 */
public interface DBFactory {

    void addDB(Connection connection);

    void addDB(ConnectionInfo connectionInfo);
}
