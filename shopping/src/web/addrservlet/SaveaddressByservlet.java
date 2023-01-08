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
        //�����ص���������
        request.setCharacterEncoding("utf-8");
        //Ҫ��ȡ��ǩ���ݵ��ҵ�name���ԣ���Ҫ��jsp�����name
        String name = request.getParameter("receiverName");
        String state = request.getParameter("receiverState");
        String city = request.getParameter("receiverCity");
        String district = request.getParameter("receiverDistrict");
        String detail = request.getParameter("receiverAddress");
        String phone = request.getParameter("receiverPhone");
        String mobile = request.getParameter("receiverMobile");
        String zip = request.getParameter("receiverZip");
        System.out.println(name+":"+phone+"\\"+mobile+","+state+"-"+city+"-"+district+":"+detail+",�ʱ�"+zip);
        Address addr = new Address(name,phone,mobile,state,city,district,detail,zip);
        AddressDao ad = new AddressDao();
        try {
            ad.saveAddress(addr);
            //��ַ����ɹ�
            response.sendRedirect("web/addressAdmin.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //����ʧ��
            response.sendRedirect("web/500.jsp");
        }
        /*var receiverName = $("#receiverName").val();// �ռ���
        var receiverState = $("#receiverState").val();// ʡ
        var receiverCity = $("#receiverCity").val();// ��
        var receiverDistrict = $("#receiverDistrict").val();// ��/��
        var receiverAddress = $("#receiverAddress").val();//
        var receiverMobile = $("#receiverMobile").val();*/
    }

}
