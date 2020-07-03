package common;

/**
 * @author chengyongjun
 * @date 2020/7/3 15:25
 */
public class UserTable {

    private String schema;

    private String tableName;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserTable) {
            if (schema != null && tableName != null) {
                if (schema.equals (((UserTable) obj).getSchema ())
                        && tableName.equals (((UserTable) obj).getTableName ())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return super.equals (obj);
    }
}
