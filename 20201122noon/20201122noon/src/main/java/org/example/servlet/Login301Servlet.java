package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注解的使用：属性名为value可以默认不写   （）小括号包裹多个属性名，属性名=属性值，多个之间逗号间隔
//servlet定义服务：注意服务路径必须是从/开始的，否则tomcat就会报错
@WebServlet("/login301")
public class Login301Servlet extends HttpServlet {

    //每次http请求映射到某个Servlet的资源路径，都会调用services生命周期法
    //如果请求的方法没有重写，就会调用父类的doXXX（对应请求方法），返回405
    //如果进行重写，会将请求数据包装成为一个Request对象，这时候虽然还没有相应，
    // 但是也包装了一个Response响应对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //super.doPost(req, resp);
        //设置请求，响应编码，及响应数据类型（为响应体设置Content—Type数据类型）
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //解析数据
        //request.getParameter方法获取请求数据，url和请求体，数据格式为键值对
        String u=req.getParameter("username");
        String p=req.getParameter("password");
        System.out.printf("------用户名(%s) 密码(%s)%n",u,p);

        if("abc".equals(u)&&"123".equals(p)) {
            resp.sendRedirect("home.html");//重定向，

        }else if("abc".equals(u)){
            req.getRequestDispatcher("home.html").forward(req,resp);

        }else{
            PrintWriter pw=resp.getWriter();//response获取io输出流
            pw.println("登陆失败");
            pw.println("<h3>用户名："+u+"或密码错误"+"</h3>");
            pw.flush();//有缓冲的io操作，需要书刷新缓冲区，才会真正的发送数据
            pw.close();
        }






    }
}
