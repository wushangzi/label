package core;

import common.ResultInfo;

import java.sql.Connection;

/**
 * @author chengyongjun
 * @date 5/29/20 9:56 AM
 */
public interface BitSql<T> extends BitFactory {

    T getAllExistFromId(int[] id, String name);

    T getAllExistFromBits(int[] id);

    /**
     * this is mean that delete one label.and this label
     *
     * @param labelId
     * @return
     */
    boolean deleteLabel(int labelId, Connection connection);

    ResultInfo addLabel(String schemaName, String tableName, String name, Connection connection);

    String recallLabel(int labelId);
}
