package common;


/**
 * @author chengyongjun
 * this is for set bit infomation in table
 * @date 5/30/20 9:38 AM
 */
public class BitInfoTable {
    private int id;

    private String tableName;

    private int bitIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getBitIndex() {
        return bitIndex;
    }

    public void setBitIndex(int bitIndex) {
        this.bitIndex = bitIndex;
    }
}
