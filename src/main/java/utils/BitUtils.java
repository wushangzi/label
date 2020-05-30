package utils;


import common.GlobalPara;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengyongjun
 * @date 5/29/20 6:24 AM
 */
public class BitUtils {

    private static final int BIT_INTERVAL = 64;

    static Map<Integer, List<Integer>> groupByBits(int[] bits) {
        Map<Integer, List<Integer>> map = new HashMap<> ();
        for (int i = 0; i < bits.length; i++) {
            int fieldIndex = getFieldIndex (bits[i]);
            int fieldBitIndex = getFieldBitIndex (bits[i]);
            if (!map.containsKey (fieldIndex)) {
                List<Integer> subList = new ArrayList ();
                subList.add (fieldBitIndex);
                map.put (fieldIndex, subList);
                continue;
            } else {
                map.get (fieldIndex).add (fieldBitIndex);
            }
        }
        return map;
    }

    static long getStatus(long status, int bitIndex) {
        status |= 1 << bitIndex;
        return status;
    }


    static void getCondition(StringBuilder stringBuilder, Integer fieldIndex, List<Integer> bitIndex, boolean isAll) {
        stringBuilder.append (GlobalPara.DB_PREFIX + fieldIndex);
        stringBuilder.append (" & ");
        long status = 0;
        for (Integer bit : bitIndex) {
            status = getStatus (status, bit);
        }
        stringBuilder.append (status);
        if (isAll) {
            stringBuilder.append ("==");
            stringBuilder.append (status);
        } else {
            stringBuilder.append (">=1");
        }
        stringBuilder.append (" && ");
    }

    public static int getFieldIndex(int bitId) {
        return bitId / 64;
    }

    public static int getFieldBitIndex(int bitId) {
        return bitId % 64;
    }

    public static String getAndAllOrOne(int[] bits, boolean isAll) {
        Map<Integer, List<Integer>> map = groupByBits (bits);

        StringBuilder condition = new StringBuilder (100);
        map.forEach ((integer, integerList) -> {
            getCondition (condition, integer, integerList, isAll);
        });
        condition.delete (condition.length () - 4, condition.length () - 1);
        return condition.toString ();
    }

    public static String setBitInvalid(int bit) {
        int fieldIndex = getFieldIndex (bit);
        int fieldBitIndex = getFieldBitIndex (bit);
        List<Integer> list = new ArrayList<> ();
        list.add (fieldBitIndex);
        StringBuilder stringBuilder = new StringBuilder (100);
        stringBuilder.append (GlobalPara.DB_PREFIX + fieldIndex);
        stringBuilder.append (" = ");
        stringBuilder.append (GlobalPara.DB_PREFIX + fieldIndex);
        stringBuilder.append (" & ");
        long status = ~(1 << fieldBitIndex);
        stringBuilder.append (status);
        return stringBuilder.toString ();
    }
}
