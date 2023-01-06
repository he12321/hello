package web.servlet;

import save.Usersave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/checkPhone.do")
public class CheckphoneServlet extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      String phone = request.getParameter("phone");
      System.out.println(phone);
      Usersave us = new Usersave();
      try {
         boolean isused = us.findByphone(phone);
         if (isused){//ÒÑ´æÔÚ
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
