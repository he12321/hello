package web.servlet;

import save.Usersave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/checkEmail.do")
public class CheckemailServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //获取前端输入的邮箱
        String email = request.getParameter("email");
        System.out.println(email);
        //查询数据库邮箱号是否注册
        Usersave us = new Usersave();
        try {
            boolean isused = us.findByemail(email);
            if (isused){//被注册
                out.print("0");
            }
            else{
                out.print("1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            out.print("2");
        }
    }
}
