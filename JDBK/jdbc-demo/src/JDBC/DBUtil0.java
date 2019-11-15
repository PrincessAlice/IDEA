package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil0 {
    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD ="123456";

    //创建 mysql 的数据源（将java数据源转化为mysql数据源）
    private static DataSource DATASOURCE = new MysqlDataSource();

    //数据源初始化
    static{
        ((MysqlDataSource) DATASOURCE).setUrl(URL);
        ((MysqlDataSource) DATASOURCE).setUser(USER_NAME);
        ((MysqlDataSource) DATASOURCE).setPassword(PASSWORD);
    }

    //封装一个方法给别人使用
    public static Connection getConnection(){
        try{
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接获取失败");
        }
    }
    //封装类 close方法
    public  static void close(Connection connection, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null){
                rs.close();     //释放资源：数据源获得数据关闭时，连接词将数据再次初始化连接，物理上没有关闭
            }
            if(ps!=null){
                ps.close();
            }
            if(connection !=null){
                connection.close();
            }
        } catch (SQLException e) {
             e.printStackTrace();
            throw new RuntimeException("释放数据库资源错误");
        }
    }

    public static void main(String[] args) {
        //通过数据源来获取数据源对象来操作数据库
        try{
            Connection connection = DATASOURCE.getConnection();   //通过getConnection 来获取数据源对象
            System.out.println(connection);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
