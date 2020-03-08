package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理login.html用户登录请求（post方式提交，url为/login）
 * 注意点：servlet绑定的url一定要用/开头
 */

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequst req,HttpServletResponse resp )throws ServletException{
        req.setCharacterEncoding("UTF-8");//只是对请求体设置编码，如果是在url中的请求参数，需要自己处理
        resp.setCharacterEncoding("UTF-8");//对响应设置编码：响应体
        resp.setContentType("text/html;charset=UTF-8");//


        super.service(req,resp);

    }

}
