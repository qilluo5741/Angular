package com.dev.local.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 转时间搓
	 * @param ordertime
	 * @return
	 * @throws Exception
	 */
	 public static String dateToStamp(String createtime) throws Exception{
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = simpleDateFormat.parse(createtime);
         String res = String.valueOf(date.getTime());
	     return res;
    }
	 /**
	  * 转回时间
	  * @param ordertime
	  * @return
	  */
	 public static String stampToDate(String createtime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long createlt = new Long(createtime);
        Date date = new Date(createlt);
        String rss = simpleDateFormat.format(date);
        return rss;
	  }
}
