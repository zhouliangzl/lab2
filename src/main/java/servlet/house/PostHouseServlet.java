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

@WebServlet("/house/postHouse")
@MultipartConfig(location = "F:\\curriculumDesign\\src\\main\\webapp\\images\\house")
public class PostHouseServlet extends HttpServlet
{
    HouseService houseService=new HouseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("对不起，不支持 get 方式上传图片！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User my = (User)request.getSession().getAttribute("my");
        //未登录，跳转到登录界面
        if(my==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        Part p=request.getPart("photo");
        p.write(p.getSubmittedFileName());

        String type1=request.getParameter("type1");
        String type2=request.getParameter("type2");
        String type3=request.getParameter("type3");
        String type4=request.getParameter("type4");
        String type5=request.getParameter("type5");
        String type="";
        if(!type1.equals("0")) type = type+type1+"室";
        if(!type2.equals("0")) type = type+type2+"厅";
        if(!type3.equals("0")) type = type+type3+"卫";
        if(!type4.equals("0")) type = type+type4+"厨";
        if(!type5.equals("0")) type = type+type5+"阳台";

        House house = new House();
        house.setUid(my.getUid());
        house.setTitle(request.getParameter("title"));
        house.setAddress(request.getParameter("address"));
        house.setArea(Integer.parseInt(request.getParameter("area")));
        house.setFloor(Integer.parseInt(request.getParameter("floor")));
        house.setRent(Integer.parseInt(request.getParameter("rent")));
        house.setRegion(request.getParameter("region"));
        house.setType(type);
        house.setOrient(request.getParameter("orient"));
        house.setEnviron(request.getParameter("environ"));
        house.setDecoration(request.getParameter("decoration"));
        house.setConnect(request.getParameter("connect"));
        house.setPhone(request.getParameter("phone"));
        house.setPhoto("/"+p.getSubmittedFileName());
        house.setDescription(request.getParameter("description"));

        int hid = 0;
        hid = houseService.postHouseService(house);
        //发布类别为租房
        int postType = 1;
        request.setAttribute("postId",hid);
        request.setAttribute("postType",postType);
        request.getRequestDispatcher("/JSP/postOver.jsp").forward(request,response);
    }
}
