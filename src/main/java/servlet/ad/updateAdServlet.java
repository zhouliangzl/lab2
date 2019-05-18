package servlet.ad;

import javaBean.Ad;
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

@WebServlet("/ad/update")
@MultipartConfig(location = "")
public class updateAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("对不起，不支持 get 方式上传图片！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        AdService adService=new AdService();
        Part p=request.getPart("aimage");
        p.write(p.getSubmittedFileName());

        int apid=Integer.parseInt(request.getParameter("apid"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String aimage="/"+p.getSubmittedFileName();
        adService.updateAd(apid,title,content,aimage);

        Ad ad = new Ad();
        try{
            ad = adService.adDetile(apid);
        }catch (Exception e) {
            System.out.println("ad.updateAd:通过aid查找ad失败！");
        }
        request.setAttribute("ad",ad);

        request.getRequestDispatcher("/JSP/ad/adDetail.jsp").forward(request,response);
    }

}
