package util;

import org.omg.CORBA.DATA_CONVERSION;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    private  static volatile DataSource DATA_SOURCE;

    private static DataSource getDataSource(){
        if(DATA_SOURCE == null){//目的：提高效率
            //刚开始所有进入这行代码的线程，DATA_SOURCE对象都是null
            //可能是第一个进去的线程，这时候DATA_SOURCE对象都是null
            //也可能是第一个线程之后的线程进入并执行
            synchronized (DBUtil.class){
                if(DATA_SOURCE == null){
                    //初始化操作，使用volatile关键字禁止指令程序，建立内存屏障
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat(Util.DATE_PATTERN);
                    DATA_SOURCE = new SQLiteDataSource(config);
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return  DATA_SOURCE;
    }

    private static String getUrl() {

    }

    public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {

    }

    public static Connection getConnection() {

    }
}
