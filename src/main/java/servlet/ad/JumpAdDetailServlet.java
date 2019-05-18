package servlet.ad;

import javaBean.User;
import services.AdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ad/jumpDetile")
public class JumpAdDetailServlet extends HttpServlet {
    AdService adService=new AdService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int apid=Integer.parseInt(request.getParameter("apid"));
        request.setAttribute("apid",apid);
//        adService.adDetile(apid);

        request.getRequestDispatcher("/JSP/ad/adDetail.jsp").forward(request,response);
    }
}
