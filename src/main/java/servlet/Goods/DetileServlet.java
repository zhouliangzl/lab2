package servlet.Goods;

import javaBean.Ad;
import javaBean.Goods;
import javaBean.User;
import services.AdService;
import services.GoodsServices;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/usedGoods/detile")
public class DetileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad ad=new Ad();
        int ggid=20000;
        int gid = Integer.parseInt(request.getParameter("gid"));
        ggid=ggid+gid;

        Goods goods = new Goods();
        List<Goods> goodsList = new ArrayList<>();
        GoodsServices goodsServices = new GoodsServices();

        User postUser = new User();
        UserServices userServices = new UserServices();
        try {
            goods = goodsServices.loadByGid(gid);
            postUser = userServices.searchByUid(goods.getUid());
            goodsList = goodsServices.recommedGoods(5,gid,goods.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdService adService=new AdService();

        try {
            ad=adService.adDetile(ggid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("ad",ad);

        request.getSession().setAttribute("goods",goods);
        request.getSession().setAttribute("postUser",postUser);
        request.setAttribute("recommedGoodsList",goodsList);
        request.getRequestDispatcher("/JSP/usedGoods/detile.jsp").forward(request,response);
    }
}
