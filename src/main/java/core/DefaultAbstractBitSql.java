package core;


import common.ConnectionInfo;
import common.GlobalPara;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author chengyongjun
 * @date 5/30/20 1:47 AM
 */
public class DefaultAbstractBitSql implements BitFactory, DBFactory {

    private ConnectionInfo connectionInfo;

    private Connection connection;

    @Override
    public void initDefaultDB() throws SQLException, ClassNotFoundException {
        if (connectionInfo != null && connection == null) {
            connection = SqlUtils.getConnection (connectionInfo);
            checkInitTable (connection);
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

    @Override
    public void setDefaultTableFieldSize(int number) {
        GlobalPara.setDefaultFieldNumber (number);
    }

    @Override
    public int getDefaultTableFieldSize() {
        return GlobalPara.getDefaultFieldNumber ();
    }

    /**
     * check and init tables
     *
     * @param connection
     */
    private void checkInitTable(Connection connection) {
        try {
            Statement statement = connection.createStatement ();
            statement.execute (GlobalPara.INIT_FORMAT_GLOBAL_SCHEMA_SQL);
            statement.execute (getInitSql ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    /**
     * build global init sql string to constructor init label
     *
     * @return
     */
    private String getInitSql() {
        return String.format (GlobalPara.INIT_FORMAT_LABEL_STRING,
                GlobalPara.INIT_GLOBAL_SCHEMA);
    }


    protected void addSomeLabel(String schemaName, String tableName, String labelName) {

    }
}
