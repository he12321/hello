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
    ǰ�ˣ�
          var result = xhr.responseText;
          if(result=="0"){
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "�˺��Ѿ���ռ�ã������ظ�ע�ᣡ";
          }else if(result=="1"){
        	  unspan.className = 'msg-success';
        	  unspan.innerHTML = "��ϲ�����˺ſ���ע�ᣡ";
          }else{
        	  unspan.className = 'msg-error';
        	  unspan.innerHTML = "����������ά�����������Ա��ϵ";
          }

 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        //��ȡǰ��������û���
        String username = request.getParameter("userName");
        System.out.println(username);
        //ȥ���ݿ�鿴�û����Ƿ�ע����
        Usersave us = new Usersave();
        try {
            boolean isUsed = us.findByusername(username);
            if (isUsed){//�û����Ѿ�ע��
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
