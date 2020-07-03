package common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengyongjun
 * @date 5/30/20 6:33 AM
 */
public class GlobalPara {

    public static final Object GLOBAL_PARA_LOCK = new Object ();

    public static final String FIELD_PREFIX = "bit_info_";

    public static final String INIT_LABEL_NAME = "label_info";

    public static final String INIT_FORMAT_LABEL_STRING = "create table if not exists %s." + INIT_LABEL_NAME +
            " (id int primary key auto_increment,schema_name varchar(40),table_name varchar(40),name varchar(40)" +
            " not null,bit_index smallint NOT NULL default 1,bit_index_status smallint not null default 0," +
            "UNIQUE KEY `schema_table_bit_unique` (`schema_name`,`table_name`,`bit_index`))";


    public static final int LABEL_STATUS_NORMAL = 1;

    public static final int LABEL_STATUS_DELETED = 1 << 1;

    static int DEFAULT_FIELD_NUMBER = 8;

    static final Map<String, Integer> SPECIAL_TABLE_FIELD_NUMBER = new HashMap<> ();

    public static int getDefaultFieldNumber() {
        synchronized (GLOBAL_PARA_LOCK) {
            return DEFAULT_FIELD_NUMBER;
        }
    }

    public static void setDefaultFieldNumber(int defaultFieldNumber) {
        synchronized (GLOBAL_PARA_LOCK) {
            DEFAULT_FIELD_NUMBER = defaultFieldNumber;
        }
    }

    public static Map<String, Integer> getSpecialTableFieldNumber() {
        return SPECIAL_TABLE_FIELD_NUMBER;
    }
}
