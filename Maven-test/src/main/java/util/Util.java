package util;

import java.io.File;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Util {
    public static final String DATE_PATTERN ="yyyy-MM-dd HH:mm:ss" ;

    /**
     * 解析日期为中文日期描述
     * @param lastModified
     * @return
     */

    public static String parseSize(long size){
        String[] danweis = {"B","KB","MB","GB","PB","TB"};
        int idx = 0;
        while(size>1024&& idx < danweis.length){
            size/=1024;
            idx++;
        }
        return size+danweis[idx];
    }

    public static String parseDate(Date lastModified){
        return new SimpleFormatter().format();
    }

    public static void main(String[] args) {
        System.out.println(parseSize(100));
        System.out.println(new File(""));
        System.out.println();
    }
}
