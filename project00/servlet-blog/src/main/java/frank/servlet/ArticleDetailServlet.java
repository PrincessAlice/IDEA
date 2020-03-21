package frank.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artcleDetail")
public class ArticleDetailServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));

        return null;
    }
}
