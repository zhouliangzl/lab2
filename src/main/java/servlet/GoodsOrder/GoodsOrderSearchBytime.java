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

@WebServlet("/GoodsOrderSearchBytime")
public class GoodsOrderSearchBytime extends HttpServlet{
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
        String keyWord = request.getParameter("keyWord");
        int pageCode = getPageCode(request);
        int pageSize = 2;
        if(keyWord.equals("")){
            String sortByTime = request.getParameter("sortByTime");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String date = "%";
            if(!year.equals("0")){
                date = year+"-";
                System.out.println("年为："+year);
            }
            else {
                date = date+"-";
            }
            if(!month.equals("0")){
                date = date+"%"+month+"-";
            }
            else {
                date = date+"%-";
            }
            if(!day.equals("0")){
                date = date+"%"+day+"%";
            }
            else {
                date = date+"%";
            }
            Page<GoodsOrder> page = goodsOrderServices.findByPage
                    ( pageCode, pageSize ,user.getUid(), sortByTime, date);
            //不将page建立session
            request.setAttribute("page",page);
            // 不将page.getGoodsBeanList（）建立session
            request.setAttribute("searchGoodsOrders",page.getGoodsOrderBeanList());
            request.setAttribute("PageCode",page.getPageCode());
            request.setAttribute("PageSize",page.getPageSize());
            request.setAttribute("TotalPage",page.getTotalPage());
            request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
        }
        else {
            Page<GoodsOrder> page = goodsOrderServices.findByPage2
                    ( pageCode, pageSize ,user.getUid(), keyWord);
            //不将page建立session
            request.setAttribute("page",page);
            // 不将page.getGoodsBeanList（）建立session
            request.setAttribute("searchGoodsOrders",page.getGoodsOrderBeanList());
            request.setAttribute("PageCode",page.getPageCode());
            request.setAttribute("PageSize",page.getPageSize());
            request.setAttribute("TotalPage",page.getTotalPage());
            request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
        }
    }
}