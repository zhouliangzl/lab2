package servlet.house;

import javaBean.House;
import javaBean.SignHouse;
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

@WebServlet("/house/signHouse")
@MultipartConfig(location = "F:\\curriculumDesign\\src\\main\\webapp\\images\\house\\contract")
public class SignHouseServlet extends HttpServlet {
    HouseService houseService=new HouseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("对不起，不支持 get 方式上传图片！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int sid = 0;
        try{
            Part p=request.getPart("idCardImage");
            p.write(p.getSubmittedFileName());

            SignHouse signHouse = new SignHouse();
            signHouse.setHid(((House)request.getSession().getAttribute("house")).getHid());
            signHouse.setUid(((User)request.getSession().getAttribute("my")).getUid());
            signHouse.setConnect(request.getParameter("lessee"));
            signHouse.setPhone(request.getParameter("phone"));
            signHouse.setIdCard(request.getParameter("IDcard"));
            signHouse.setIdImage("/"+p.getSubmittedFileName());
            sid = houseService.signHouseService(signHouse);
        } catch (Exception e) {
            System.out.println("签订合同失败！");
            e.printStackTrace();
        }

        request.setAttribute("signId",sid);
        request.getRequestDispatcher("/JSP/house/signOver.jsp").forward(request,response);
    }
}
