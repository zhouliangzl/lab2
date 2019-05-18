package servlet.ad;

import javaBean.Ad;
import services.AdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ad/detile")
public class DetileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int apid = Integer.parseInt(request.getParameter("apid"));

        AdService adService = new AdService();
        Ad ad = new Ad();
        try{
            ad = adService.adDetile(apid);
        }catch (Exception e) {
            System.out.println("ad\\Detile:通过aid查找ad失败！");
        }

        request.setAttribute("ad",ad);
        request.getRequestDispatcher("/JSP/ad/adDetail.jsp").forward(request,response);
    }
}
