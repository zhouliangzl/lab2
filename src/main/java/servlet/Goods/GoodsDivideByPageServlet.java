package servlet.Goods;

import javaBean.Goods;
import javaBean.User;
import services.GoodsServices;
import javaBean.Page;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listByPage")
public class GoodsDivideByPageServlet extends HttpServlet{

    GoodsServices goodsServices = new GoodsServices();
//    HouseService houseServices = new HouseService();
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

        int pageCode = getPageCode(request);
        int pageSize = 3;

        User user = (User)request.getSession().getAttribute("my");
        if(user==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        Page<Goods> page = goodsServices.findByPage( pageCode, pageSize ,user.getUid());
        page.setHouseBeanList(null);
//不将page建立session
        request.setAttribute("page",page);
// 不将page.getGoodsBeanList（）建立session
        request.setAttribute("goodss",page.getGoodsBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
    }
}