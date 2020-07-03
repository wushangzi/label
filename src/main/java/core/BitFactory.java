package core;

import java.sql.SQLException;

/**
 * @author chengyongjun
 * @date 5/29/20 6:52 AM
 */
public interface BitFactory {
    void initDefaultDB() throws SQLException, ClassNotFoundException;

    int[] getBitInfoFromIds();
}
