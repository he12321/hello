package web.servlet;

import save.Usersave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/checkUserName.do")
public class CheckusernameServlet extends HttpServlet {
   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    前端：
          var result = xhr.responseText;
          if(result=="0"){
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "账号已经被占用，不能重复注册！";
          }else if(result=="1"){
        	  unspan.className = 'msg-success';
        	  unspan.innerHTML = "恭喜！该账号可以注册！";
          }else{
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "服务器正在维护！请与管理员联系";
          }

 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        //获取前端输入的用户名
        String username = request.getParameter("userName");
        System.out.println(username);
        //去数据库查看用户名是否注册了
        Usersave us = new Usersave();
        try {
            boolean isUsed = us.findByusername(username);
            if (isUsed){//用户名已经注册
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
