package web.servlet;

import entity.User;
import save.Usersave;
import sun.rmi.server.UnicastServerRef;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login.do")//登录验证
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String isAuto = request.getParameter("isAuto");
        System.out.println("username "+username+", password "+password+", isAuto "+isAuto);
        Usersave us = new Usersave();
        try {
            User user = us.findByUser(username,password);
            if (user!=null){
                //session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (isAuto!=null){//保存用户名和密码在浏览器cookies中
                    Cookie c1 = new Cookie("su", username);
                    c1.setMaxAge(24*60*60);
                    c1.setPath("/");
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("sp", password);
                    c2.setMaxAge(24*60*60);//设置cookies时间
                    c2.setPath("/");
                    response.addCookie(c2);
                }
                out.print("1");
            }
            else{
                out.print("2");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            out.print("3");
        }
    }
}
