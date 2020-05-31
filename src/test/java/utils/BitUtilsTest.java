package utils;

import base.BaseTestClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitUtilsTest extends BaseTestClass {

    @Test
    void getFieldIndex() {
        assert BitUtils.getFieldIndex (64) == 1;
    }

    @Test
    void getFieldBitIndex() {
        assert BitUtils.getFieldBitIndex (64) == 0;
    }
}