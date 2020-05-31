package core;


import common.ConnectionInfo;
import common.GlobalPara;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author chengyongjun
 * @date 5/30/20 1:47 AM
 */
public class DefaultAbstractBitSql implements BitFactory, DBFactory {

    private ConnectionInfo connectionInfo;

    private Connection connection;

    @Override
    public void initDB() throws SQLException, ClassNotFoundException {
        if (connectionInfo != null && connection == null) {
            //TODO initDb
            connection = SqlUtils.getConnection (connectionInfo);
            checkInitTable(connection);
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


    private void checkInitTable(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement (getInitSql ());
            preparedStatement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    private String getInitSql() {
        return String.format (GlobalPara.INIT_FORMAT_LABEL_STRING,
                connectionInfo.getDefaultDB ());
    }
}
