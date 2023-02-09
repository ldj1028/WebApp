package kr.co.cywell.web.util;

import java.util.Date;
import java.sql.Timestamp;

public class CommonUtil {
    public CommonUtil(){}

    public String changeTimeFormat(long time){
        Timestamp stamp = new Timestamp(time);
        Date date = new Date(stamp.getTime());
        return date.toString();
    }
}