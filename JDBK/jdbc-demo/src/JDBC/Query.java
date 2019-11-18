package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//查询
public class Query {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil0.getConnection();
            //preparedStatement写法
            //String sql = "select * from student where id = ?";
            String sql = "select * from student where qq_mail" + "like ? and classes_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com");
            ps.setInt(2,1);
            rs = ps.executeQuery();

            //statement写法   sql注入，sql漏洞
            // String sql = "select * from student where id = 3";
            //Statement statement = connection.createStatement();
            //    ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                System.out.println(String.format("id=%s,sn=%s",id,sn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil0.close(connection,ps,rs);
        }
    }
}
