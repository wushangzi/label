package core;


import common.ConnectionInfo;

import java.sql.Connection;

/**
 * @author chengyongjun
 * @date 5/30/20 1:47 AM
 */
public class DefaultAbstractBitSql implements BitFactory, DBFactory {

    private ConnectionInfo connectionInfo;

    private Connection connection;

    @Override
    public void initDB() {
        if (connectionInfo != null) {
            //TODO initDb
        }
    }

    @Override
    public int[] getBitInfoFromIds() {
        return new int[0];
    }

    @Override
    public void addDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addDB(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }
}
