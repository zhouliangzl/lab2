package servlet.house;

import javaBean.House;
import javaBean.User;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/house/updateStart")
public class UpdateStartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int hid = Integer.parseInt(request.getParameter("hid"));

        House house=new House();
        HouseService houseService=new HouseService();
        try {
            house = houseService.loadByHid(hid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("house",house);
        request.getRequestDispatcher("/JSP/house/update.jsp").forward(request,response);
    }
}
