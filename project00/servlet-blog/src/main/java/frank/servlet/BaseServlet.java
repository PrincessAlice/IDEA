package frank.servlet;

import frank.model.Article;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");//返回json

        Result result = new Result();
        try{
            //Todo
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(data);
        }catch (Exception e){
            result.setCode("500");
            result.setMessage("服务器出错了");
            e.printStackTrace();
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    public abstract Object process(HttpServletRequest req,HttpServletResponse resp)  throws Exception;
}
