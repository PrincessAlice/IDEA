package task;

import app.FileMeta;
import util.DBUtil;
import util.Util;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class FileSave {
    public void callback(File dir){
        File[] children = dir.listFiles();
        List<FileMeta> locals = new ArrayList<>();
        if(children != null){
            for(File child:children){
                locals.add(new FileMeta(child));
            }
        }
    }

    private void save(FileMeta meta){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            //1.获取数据库连接
            connection = DBUtil.getConnection();
            //添加is_directory,占位符，set值3，4,5,6，+1，添加set第3个参数is_directory
            String sql = "insert into file_meta" +"(name,path,is_directory,size,last_modified,pinyin,pinyin_first)"
                    +"value(?,?,?,?,?,?,?)";
            //2.获取sql操作命令对象statement
            statement = connection.prepareStatement(sql);
            statement.setString(1,meta.getName());
            statement.setString(2,meta.getPath());
            statement.setBoolean(3,meta.getDirectory());
            statement.setLong(4,meta.getSize());
            //数据库保存日期类型，可以按数据库设置的日期格式，以字符串传入
            statement.setString(5,meta.getLastModifiedText());

        }catch (Exception e){
            throw new RuntimeException("");
        }finally {

        }
    }

    private List<FileMeta> query(File dir){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FileMeta> metas = new ArrayList<>();
        try{
            //1.创建素具库连接
            connection = DBUtil.getConnection();
            String sql = "select name,path,is_directory,size,last_modified"+"from file_meta where path=?";
           //2.创建jdbc操作命令对象statement
            ps = connection.prepareStatement(sql);
            ps.setString(1,dir.getPath());
            //3.执行sql语句
            rs = ps.executeQuery();
            //4.处理结果集ResultSet
            while(rs.next()){
                String name = rs.getString("name");
                String path = rs.getString("path");
                Boolean isDirectory = rs.getBoolean("is_directory");
                Long size = rs.getLong("size");
                Timestamp lastModified = rs.getTimestamp("last_modified");
                FileMeta meta = new FileMeta(name,path,isDirectory,size,
                        new java.util.Date(lastModified.getTime()));
                System.out.printf("查询文件信息：name=%s,path=%s,is_directory=%s,size=%,last_modified=%s\n",
                        name,path,String.valueOf(isDirectory), String.valueOf(size), Util.parseDate(new java.util.Date(lastModified.getTime())));
                metas.add(meta);
            }
            return metas;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询文件信息出错");
        }finally{
            DBUtil.close(connection,ps,rs);
        }
    }

    public static void main(String[] args) {
        DBUtil.init();
        File file = new File("");
        FileSave fileSave = new FileSave();
        fileSave.save(file);
        fileSave.query(file);

    }

}
