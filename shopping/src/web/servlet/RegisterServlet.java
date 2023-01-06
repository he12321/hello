package web.servlet;

import entity.User;
import save.Usersave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/regist.do")
public class RegisterServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("userName");
        String pwd = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        User user = new User(username,pwd,phone,email);
        Usersave us = new Usersave();
        try {
           us.savaUser(user);
           //×¢²á³É¹¦µ½µÇÂ¼½çÃæ
            response.sendRedirect("web/login.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //×¢²áÊ§°Ü
            response.sendRedirect("web/500.jsp");
        }
    }

}
