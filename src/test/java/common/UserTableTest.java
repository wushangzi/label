package common;

import java.util.HashMap;

class UserTableTest {

    public static void main(String[] args) {
        /*UserTable userTableOne=new UserTable ();
        userTableOne.setSchema ("china");
        userTableOne.setTableName ("american");


        GlobalPara.SPECIAL_TABLE_FIELD_NUMBER.put (userTableOne,1);

        UserTable userTableTwo=new UserTable ();
        userTableTwo.setSchema ("china");
        userTableTwo.setTableName ("american");


        boolean b = GlobalPara.SPECIAL_TABLE_FIELD_NUMBER.containsKey (userTableTwo);
        if(userTableOne.equals (userTableTwo))
        {
            System.out.println ("1234");
        }*/

        String a="cjfjoafjeawjfiajwfioajwfiojgioajwgo$1232131241412";
        String bs="cjfjoafjeawjfiajwfioajwfiojgioajwgo$1232131241412";

        HashMap<String,Integer> hashMap=new HashMap<> ();
        hashMap.put (a,1);

        Integer b1 = hashMap.get (bs+"1");
        System.out.println (b1);

    }
}