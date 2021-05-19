package daodemo;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
}
