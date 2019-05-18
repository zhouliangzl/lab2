package servlet.GoodsOrder;

import javaBean.Goods;
import javaBean.GoodsOrder;
import javaBean.House;
import javaBean.User;
import services.GoodsOrderServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddGoodsOrder")
public class AddOrderServlet extends HttpServlet {

    GoodsOrderServices goodsOrderServices = new GoodsOrderServices();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        User user = (User)request.getSession().getAttribute("my");
        if(user==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        Goods goods = (Goods)request.getSession().getAttribute("goods");
        int oid=0;
        try {
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setGid(goods.getGid());
            goodsOrder.setUid(user.getUid());
            goodsOrder.setName(request.getParameter("name"));
            goodsOrder.setAddress(request.getParameter("address"));
            goodsOrder.setPhone(request.getParameter("phone"));
            goodsOrder.setPrice(goods.getPrice());
            goodsOrder.setOimage(goods.getGimage());
            oid = goodsOrderServices.insertService( goodsOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("orderId",oid);
        request.getRequestDispatcher("/JSP/usedGoods/orderOver.jsp").forward(request,response);
    }
}
