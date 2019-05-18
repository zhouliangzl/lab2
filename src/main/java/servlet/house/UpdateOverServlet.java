package servlet.house;

import javaBean.House;
import javaBean.User;
import services.HouseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig(location = "F:\\curriculumDesign\\src\\main\\webapp\\images\\house")
@WebServlet("/house/updateOver")
public class UpdateOverServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        Part p=request.getPart("photo");
        p.write(p.getSubmittedFileName());

        House house = new House();
        house.setHid(Integer.parseInt(request.getParameter("hid")));
        house.setTitle(request.getParameter("title"));
        house.setAddress(request.getParameter("address"));
        house.setArea(Integer.parseInt(request.getParameter("area")));
        house.setFloor(Integer.parseInt(request.getParameter("floor")));
        house.setRent(Integer.parseInt(request.getParameter("rent")));
        house.setRegion(request.getParameter("region"));
        house.setType(request.getParameter("type"));
        house.setOrient(request.getParameter("orient"));
        house.setEnviron(request.getParameter("environ"));
        house.setDecoration(request.getParameter("decoration"));
        house.setConnect(request.getParameter("connect"));
        house.setPhone(request.getParameter("phone"));
        house.setPhoto("/"+p.getSubmittedFileName());
        house.setDescription(request.getParameter("description"));

        HouseService houseService=new HouseService();
        boolean isUpdateSuccessed = houseService.updateHouseService(house);
        //类别为租房
        int updateType = 1;
        request.setAttribute("isUpdateSuccessed",isUpdateSuccessed);
        request.setAttribute("updateId",house.getHid());
        request.setAttribute("updateType",updateType);
        request.getRequestDispatcher("/JSP/updateOver.jsp").forward(request,response);
    }
}
