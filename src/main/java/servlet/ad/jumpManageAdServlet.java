package servlet.ad;

import javaBean.Ad;
import services.AdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ad/jumpManageAdServlet")
public class jumpManageAdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad ad=new Ad();
        AdService adService=new AdService();
        int apid=Integer.parseInt(request.getParameter("apid"));
        int adposStatus=Integer.parseInt(request.getParameter("adposStatus"));
        try {
            ad=adService.adDetile(apid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("apid",apid);
        request.setAttribute("adposStatus",adposStatus);
        request.setAttribute("ad",ad);
        request.getRequestDispatcher("/JSP/user/manageAd.jsp").forward(request,response);
    }
}
