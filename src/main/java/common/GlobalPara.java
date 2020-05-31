package common;

/**
 * @author chengyongjun
 * @date 5/30/20 6:33 AM
 */
public class GlobalPara {

    public static final String DB_PREFIX = "bit_info_";

    public static final String INIT_LABEL_NAME = "label_info";

    public static final String INIT_FORMAT_LABEL_STRING = "create table if not exists %s." + INIT_LABEL_NAME +
            " (id int primary key auto_increment,name varchar(40) not null,bit_index smallint NOT NULL unique)";
}
