package servlet.house;

import javaBean.House;
import services.HouseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchHouseByCondition")
public class searchHouseByCondition extends HttpServlet {
    HouseService houseservice = new HouseService();
    @Override
    public void service(HttpServletRequest request , HttpServletResponse response){
        String region = request.getParameter("region");
        int area = Integer.parseInt(request.getParameter("area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int rent = Integer.parseInt(request.getParameter("rent"));
        int type = Integer.parseInt(request.getParameter("type"));
        String decoration = request.getParameter("decoration");
        House house = houseservice.searchByCondition(region, area, floor, rent, type, decoration);
    }
}
