package frank.dao;

import frank.exception.SystemException;
import frank.model.Article;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(Integer id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select id,title,content,user_id,create_time"+"from article where user_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            Article article = new Article();
            //处理结果集
            while(resultSet.next()){
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new java.util.Date(resultSet.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
            return articles;
        }catch (Exception e){
            throw new SystemException("aquery002","查询文章详情出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }
}
