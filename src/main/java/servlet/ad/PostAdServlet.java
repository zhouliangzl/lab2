package servlet.ad;

import javaBean.Ad;
import javaBean.House;
import javaBean.User;
import services.AdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/ad/postAd")
@MultipartConfig(location = "F:\\curriculumDesign\\src\\main\\webapp\\images\\adv")
public class PostAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("对不起，不支持 get 方式上传图片！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aid = 0;
        try{
            Part p=request.getPart("aimage");
            p.write(p.getSubmittedFileName());

            AdService adService=new AdService();
            Ad ad = new Ad();
            ad.setApid(Integer.parseInt((request.getParameter("apid"))));
            ad.setUid(((User)request.getSession().getAttribute("my")).getUid());
            ad.setTitle(request.getParameter("title"));
            ad.setAimage("/"+p.getSubmittedFileName());
            ad.setContent(request.getParameter("content"));
            ad.setMoney(Integer.parseInt(request.getParameter("money")));
            aid = adService.postAd(ad);
        }catch (Exception e) {
            System.out.println("填写广告失败！");
            e.printStackTrace();
        }
        request.setAttribute("aid",aid);
        request.getRequestDispatcher("/JSP/ad/postOver.jsp").forward(request,response);
    }
}
