package JDBC;


import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD ="123456";

    /*
    * 1.加载驱动
    * 2.建立连接
    * 3.创建执行对象Statement
    * 4.执行sql
    * 5.处理结果集ResultSet
    * 6.释放资源
    * @param args
    * */
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //加载驱动，java中的反射
            Class.forName("com.mysql.jdbc.Driver");   //编译时异常需处理，一般选自己处理异常
            //java中类加载：静态方法，静态代码块，实例代码块，构造方法

            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            System.out.println(connection);
            //创建执行语句的对象
            statement = connection.createStatement();

            //执行sql
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);

            //处理结果集
            while(resultSet.next()){
               Integer id = resultSet.getInt(1);
               Integer sn = resultSet.getInt(2);
               String name = resultSet.getString(3);
               String qq = resultSet.getString(4);
               Integer classesId = resultSet.getInt(5);
               System.out.println(String.format("id=%s,sn=%s," + "name=%s,qq=%s,classId=%s",
                        id,sn,name,qq,classesId));

            }
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }finally {
            //释放对象(和创建的顺序相反来释放)：resultSet statement connection
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

}
