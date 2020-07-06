package core;

import base.BaseTestClass;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAbstractBitSqlTest extends BaseTestClass {

    DefaultAbstractBitSql defaultAbstractBitSql = new DefaultAbstractBitSql ();

    @Test
    void initDB() {
        try {
            defaultAbstractBitSql.addDB (buildConnectionInfo ());
            defaultAbstractBitSql.initDefaultDB ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    @Test
    void getBitInfoFromIds() {
    }

    @Test
    void addDB() {
    }

    @Test
    void testAddDB() {
    }
}