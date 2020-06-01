package common;

/**
 * @author chengyongjun
 * @date 5/30/20 6:33 AM
 */
public class GlobalPara {

    public static final String DB_PREFIX = "bit_info_";

    public static final String INIT_LABEL_NAME = "label_info";

    public static final String INIT_FORMAT_LABEL_STRING = "create table if not exists %s." + INIT_LABEL_NAME +
            " (id int primary key auto_increment,schema_name varchar(40),table_name varchar(40),name varchar(40)" +
            " not null,bit_index smallint NOT NULL default 1,bit_index_status smallint not null default 0," +
            "UNIQUE KEY `schema_table_bit_unique` (`schema_name`,`table_name`,`bit_index`))";


    public static final int LABEL_STATUS_NORMAL = 1;

    public static final int LABEL_STATUS_DELETED = 1 << 1;
}
