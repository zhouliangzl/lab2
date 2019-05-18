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
import java.util.List;

@WebServlet("/Goods/updateOver")
public class UpdateOverServlet extends HttpServlet {
    GoodsServices goodsServices = new GoodsServices();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);


        Goods goods = new Goods();
        goods.setName(request.getParameter("name"));
        goods.setType(request.getParameter("type"));
        goods.setPrice(Integer.parseInt(request.getParameter("money")));
        goods.setDescription(request.getParameter("description"));
        goods.setColor(request.getParameter("color"));
        goods.setOld(request.getParameter("old"));
        goods.setGid(Integer.parseInt(request.getParameter("gid")));

        boolean isUpdateSuccessed = goodsServices.UpdateByGid(goods);
        //类别为二手商品
        int updateType = 2;
        request.setAttribute("isUpdateSuccessed",isUpdateSuccessed);
        request.setAttribute("updateId",goods.getGid());
        request.setAttribute("updateType",updateType);
        request.getRequestDispatcher("/JSP/updateOver.jsp").forward(request,response);
    }
}
