package servlet.GoodsOrder;

import javaBean.GoodsOrder;
import javaBean.Page;
import javaBean.User;
import services.GoodsOrderServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsOrderListByPage")
public class GoodsOrderDivideByPageServlet extends HttpServlet{

    GoodsOrderServices goodsOrderServices = new GoodsOrderServices();
    public int getPageCode(HttpServletRequest request){
        // 先获取从客户端传过来的参数
        String pc = request.getParameter("pc");
        // 进行判断
        if(pc == null || pc.trim().isEmpty()){
            // 返回第一页
            return 1;
        }
        return Integer.parseInt(pc);
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("my");
        if(user==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int pageCode = getPageCode(request);
        int pageSize = 3;
        Page<GoodsOrder> page = new Page<>();
        try{
            page = goodsOrderServices.findByPage( pageCode, pageSize ,user.getUid());
        }catch (Exception e) {
           e.printStackTrace();
        }

        //不将page建立session
        request.setAttribute("page",page);
        // 不将page.getGoodsBeanList（）建立session
        request.setAttribute("goodsOrders",page.getGoodsOrderBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
    }
}