package servlet.house;

import javaBean.House;
import javaBean.SignHouse;
import javaBean.User;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/house/signHouseDetail")
public class SignHouseDetailServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int sid = Integer.parseInt(request.getParameter("sid"));
        HouseService houseService=new HouseService();
        UserServices userServices = new UserServices();

        SignHouse signHouse = new SignHouse();
        User signUser = new User();
        House house = new House();

        try{
            signHouse = houseService.searchSignHouseService(sid);
            signUser = userServices.searchByUid(signHouse.getUid());
            house = houseService.loadByHid(signHouse.getHid());
        } catch (Exception e) {
            System.out.println("查看合同详情失败！");
            e.printStackTrace();
        }

        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("timeStart",dateFormat.format(signHouse.getTimeStart().getTime()));
        signHouse.getTimeStart().add(Calendar.MONTH,1);
        request.setAttribute("timeEnd",dateFormat.format(signHouse.getTimeStart().getTime()));
        request.setAttribute("signHouse",signHouse);
        request.setAttribute("signUser",signUser);
        request.setAttribute("house",house);
        request.getRequestDispatcher("/JSP/house/signHouseDetail.jsp").forward(request,response);
    }
}
