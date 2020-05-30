package utils;


import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;
import common.ConnectionInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static common.CompileStatus.COMPILE_STATUS_DEBUG;

/**
 * @author chengyongjun
 * @date 5/29/20 12:07 PM
 */
public class SqlUtils {

    private static String getUrl(ConnectionInfo info) {
        StringBuilder sql = new StringBuilder (100);
        sql.append ("jdbc:mysql://");
        sql.append (info.getHost ());
        sql.append (":");
        sql.append (info.getPort ());
        sql.append ("/");
        sql.append (info.getDefaultDB ());
        sql.append ("?useSSL=false&serverTimezone=UTC&autoReconnect=false");
        if (COMPILE_STATUS_DEBUG) {
            System.out.println (sql.toString ());
        }
        return sql.toString ();
    }

    public static Connection getConnection(ConnectionInfo info) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName ("com.mysql.cj.jdbc.Driver");// 加载驱动程序，此次无需更改
        System.out.println ("registered success!");//输出registered success表示驱动加载成功
        //创建对象连接，连接数据库，此例中employeedbms为数据库名，root为用户名，123456位密码，
        // 该三项均需根据实际情况进行修改，其它代码无需变动。注：确保数据库名、用户名和密码的准确性。
        conn = DriverManager.getConnection (info.getConnectionUrl () != null ? info.getConnectionUrl ()
                : getUrl (info), info.getUser (), info.getPassword ());
        System.out.println ("connection success!");//输出connection success表示数据库已成功连接
        return conn;
    }

    public static List getIdsForm(Connection connection, String sql) throws SQLException {
        List list = new ArrayList ();
        PreparedStatement preparedStatement = connection.prepareStatement (sql);
        ResultSet resultSet = preparedStatement.executeQuery ();
        ResultSetMetaData metaData = resultSet.getMetaData ();
        int columnCount = metaData.getColumnCount ();

        if (columnCount == 1) {
            while (resultSet.next ()) {
                list.add (resultSet.getObject (0));
            }
        }

        while (resultSet.next ()) {
            List subList = new ArrayList (columnCount);
            for (int i = 0; i < columnCount; i++) {
                subList.add (resultSet.getObject (i));
            }
        }
        return list;
    }

    public static boolean setBitInIds(List ids, int bitIndex, String schemaName, String tableName) {

        return false;
    }
}
