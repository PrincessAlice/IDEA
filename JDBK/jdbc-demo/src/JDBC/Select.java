package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil1.getConnection();
            String sql = "select id,sn,name,qq_mail,classes_id" + "from student where qq_mail" + "like ? and classes_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com");
            ps.setInt(2,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                String name = rs.getString("name");
                String qqMail = rs.getString("qqMail");
                Integer classesId = rs.getInt("classesId");
                System.out.println(String.format("id=%s,sn=%s,name=%s," + "mail=%S,classesId=%s" ,id,sn,name,qqMail,classesId));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //finally 始终会一直执行
            //如果放到try里，即便放到最后，可能会执行不到。
            DBUtil1.close(connection,ps,rs);
        }
    }
}
