package learning7;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
        date.getTime();
        //代表格林威治时间1970-01-01  00:00:00 到目前的毫秒数
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
