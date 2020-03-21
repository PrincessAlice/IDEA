package frank.servlet;

import frank.model.Article;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet {

    @Override
    public  Object process(HttpServletRequest req,HttpServletResponse resp)  throws Exception {
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        System.out.println(article);
        return null;
    }

}
