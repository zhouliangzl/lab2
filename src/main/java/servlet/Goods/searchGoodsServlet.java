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

@WebServlet("/usedGoods/searchGoodsServlet")
public class searchGoodsServlet extends HttpServlet{

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
        int pageSize = 5;
        Page<Goods> page = goodsServices.indexFindByPage( pageCode, pageSize );
//不将page建立session
        request.setAttribute("page",page);
// 不将page.getGoodsBeanList（）建立session
        request.setAttribute("goods",page.getGoodsBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getRequestDispatcher("/JSP/usedGoods/search.jsp").forward(request,response);
    }
}
