package servlet.house;

import javaBean.Ad;
import javaBean.House;
import javaBean.User;
import services.AdService;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/house/detile")
public class DetileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad ad=new Ad();
        int hid = Integer.parseInt(request.getParameter("hid"));

        House house=new House();
        List<House> housesList = new ArrayList<>();
        HouseService houseService=new HouseService();
        try {
            house = houseService.loadByHid(hid);
            housesList = houseService.recommedHouses(5,house.getHid(),house.getRegion(),house.getRent());
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdService adService=new AdService();
        try {
            ad=adService.adDetile(hid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("ad",ad);
        request.setAttribute("recommedHousesList",housesList);
        request.getSession().setAttribute("house",house);
        request.getRequestDispatcher("/JSP/house/detile.jsp").forward(request,response);
    }
}
