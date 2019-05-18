package servlet.GoodsOrder;
import javaBean.GoodsOrder;
import javaBean.User;
import services.GoodsOrderServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteGoodsOrder")
public class DeleteOrderServlet extends HttpServlet{

    GoodsOrderServices  goodsOrderServices = new GoodsOrderServices();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int oid = Integer.parseInt(request.getParameter("oid"));

        GoodsOrder goods = new GoodsOrder();
        boolean isDeleteSuccess = goodsOrderServices.DeleteGoodsOrder(oid);
        if(isDeleteSuccess){

            request.setAttribute("isDeleteSuccess",isDeleteSuccess);
            request.getRequestDispatcher("/GoodsOrderListByPage").forward(request,response);
        }
    }
}
