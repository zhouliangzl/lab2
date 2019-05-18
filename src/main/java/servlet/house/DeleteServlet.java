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

@WebServlet("/house/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int hid = Integer.parseInt(request.getParameter("hid"));

        HouseService houseService=new HouseService();
        boolean isDeleteSuccess = houseService.deleteByHidService(hid);

        request.setAttribute("isDeleteSuccess",isDeleteSuccess);
//        request.getRequestDispatcher("/JSP/house/detile.jsp").forward(request,response);
//        forward
    }
}
