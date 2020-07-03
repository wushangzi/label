package core;


import common.GlobalPara;
import common.ResultInfo;
import exception.AddLabelOutOFIndexException;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @author chengyongjun
 * @date 5/29/20 12:02 PM
 */
public class BitSqlImpl<T> extends DefaultAbstractBitSql implements BitSql<T> {

    public T getAllExistFromId(int[] id, String name) {
        return null;
    }

    public T getAllExistFromBits(int[] id) {
        return null;
    }

    @Override
    public boolean deleteLabel(int labelId) {
        return false;
    }

    @Override
    public ResultInfo addLabel(String schemaName, String tableName, String name, Connection connection) {
        ResultInfo resultInfo = new ResultInfo ();
        try {
            connection.createStatement ().execute ("begin;");

            String searchLabelSql = String.format ("select " + GlobalPara.INIT_GLOBAL_SCHEMA + "." + GlobalPara.INIT_LABEL_NAME
                            + " from %s.%s where schemaName=? and tableName=? order by bit_index asc for update"
                    , schemaName, tableName);
            PreparedStatement preparedStatement = connection.prepareStatement (searchLabelSql);
            preparedStatement.setString (1, schemaName);
            preparedStatement.setString (2, tableName);
            ResultSet resultSet = preparedStatement.executeQuery ();
            int result = 1;
            while (resultSet.next ()) {
                if (result == -1) {
                    result = resultSet.getInt (0);
                } else if (resultSet.getInt (0) - result != 1) {
                    Integer fieldNumber = GlobalPara.SPECIAL_TABLE_FIELD_NUMBER.get (schemaName + "$" + tableName);
                    if (result + 1 <= (1 << fieldNumber)) {
                        String insertSql = String.format ("insert into %s.%s(schema_name,table_name,name,bit_index) values(?,?,?,?)");
                        PreparedStatement insert = connection.prepareStatement (insertSql);
                        preparedStatement.setString (1, schemaName);
                        preparedStatement.setString (2, tableName);
                        preparedStatement.setString (3, name);
                        preparedStatement.setInt (4, result + 1);
                        insert.execute ();

                    } else {
                        resultInfo.setCode (0);
                        resultInfo.setMsg ("标签超出范围");
                    }
                }
                break;
            }

        } catch (SQLException e) {
            try {
                connection.createStatement ().execute ("rollback;");
            } catch (SQLException e1) {
                e1.printStackTrace ();
                return resultInfo;
            }
            e.printStackTrace ();
        }
        return resultInfo;
    }

    @Override
    public String recallLabel(int labelId) {
        return null;
    }
}
