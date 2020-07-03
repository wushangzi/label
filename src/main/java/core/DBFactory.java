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

    /**
     * this is add special number.please node that,the now number must big than
     * old one.if it is not that.the method will not valid
     * @param number
     */
    void setDefaultTableFieldSize(int number);

    /**
     * get Default number size
     * @return default number size
     */
    int getDefaultTableFieldSize();
}
