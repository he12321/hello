package web.addrservlet;

import entity.Address;
import entity.User;
import save.AddressDao;
import save.Usersave;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/Addrdata")
public class SaveaddressByservlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //表单传回的中文乱码
        request.setCharacterEncoding("utf-8");
        //要获取标签数据得找到name属性，需要在jsp中添加name
        String name = request.getParameter("receiverName");
        String state = request.getParameter("receiverState");
        String city = request.getParameter("receiverCity");
        String district = request.getParameter("receiverDistrict");
        String detail = request.getParameter("receiverAddress");
        String phone = request.getParameter("receiverPhone");
        String mobile = request.getParameter("receiverMobile");
        String zip = request.getParameter("receiverZip");
        System.out.println(name+":"+phone+"\\"+mobile+","+state+"-"+city+"-"+district+":"+detail+",邮编"+zip);
        Address addr = new Address(name,phone,mobile,state,city,district,detail,zip);
        AddressDao ad = new AddressDao();
        try {
            ad.saveAddress(addr);
            //地址保存成功
            response.sendRedirect("web/addressAdmin.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //保存失败
            response.sendRedirect("web/500.jsp");
        }
        /*var receiverName = $("#receiverName").val();// 收件人
        var receiverState = $("#receiverState").val();// 省
        var receiverCity = $("#receiverCity").val();// 市
        var receiverDistrict = $("#receiverDistrict").val();// 区/县
        var receiverAddress = $("#receiverAddress").val();//
        var receiverMobile = $("#receiverMobile").val();*/
    }

}
