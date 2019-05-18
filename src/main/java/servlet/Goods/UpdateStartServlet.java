package servlet.Goods;

import javaBean.Goods;
import javaBean.User;
import services.GoodsServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Goods/updateStart")
public class UpdateStartServlet extends HttpServlet {

    GoodsServices goodsServices = new GoodsServices() ;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int gid = Integer.parseInt(request.getParameter("gid"));
        Goods goods = goodsServices.loadByGid(gid);
        request.setAttribute("Goods", goods );

        request.getRequestDispatcher("/JSP/usedGoods/Update.jsp").forward(request , response );
    }
}
