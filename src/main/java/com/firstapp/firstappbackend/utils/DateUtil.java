package com.firstapp.firstappbackend.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 时间格式化工具类
 *
 * */
public class DateUtil {
    public  static final String STANDARD="yyyy-MM-dd HH:mm:ss";
    /***
     *
     *字符串类型的时间转为Date
     * */
     public  static Date stringToDate(String strDate){
         DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern(STANDARD);
         DateTime dataTime=dateTimeFormatter.parseDateTime(strDate);
         return  dataTime.toDate();
     }
    public  static Date stringToDate(String strDate,String format){
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern(format);
        DateTime dataTime=dateTimeFormatter.parseDateTime(strDate);
        return  dataTime.toDate();
    }

    /***
     *
     *Date类型时间转为字符串时间
     * */

    public  static  String dataToString(Date date){
        if (date==null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime=new DateTime(date);
        return  dateTime.toString(STANDARD);
    }

    public  static  String dataToString(Date date,String format){
        if (date==null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime=new DateTime(date);
        return  dateTime.toString(format);
    }


}
