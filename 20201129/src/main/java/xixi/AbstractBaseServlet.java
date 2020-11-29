package xixi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            //Session会话管理：除注册和登录接口，其他都需要登陆后才能访问
            //req.getServletPath();获取请求服务路径
            //TODO

            //调用子类可以重写的方法
            process(req,resp);

        }catch(Exception e){
            //处理异常 JDBC的异常，JSON的异常处理，自定义异常返回错误消息
            e.printStackTrace();


            String s="服务器未知的错误";
            if(e instanceof AppException){
                s=e.getMessage();

            }
            PrintWriter pw=resp.getWriter();
            pw.println(s);
            pw.flush();
            pw.close();






        }
    }


    protected abstract void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception;






}
