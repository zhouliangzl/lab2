package servlet;

import javaBean.Goods;
import javaBean.Page;
import services.GoodsServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Index/GoodsSearchServlet")
public class IndexGoodsSearchServlet extends HttpServlet {
    GoodsServices goods = new GoodsServices();

    public int getPageCode(HttpServletRequest request) {
        // 先获取从客户端传过来的参数
        String pc = request.getParameter("pc");
        // 进行判断
        if (pc == null || pc.trim().isEmpty()) {
            // 返回第一页
            return 1;
        }
        return Integer.parseInt(pc);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        int pageCode = getPageCode(request);
        int pageSize = 3;
        Page<Goods> page = goods.findByPageIndex(pageCode, pageSize, keyWord);
        //不将page建立session
        request.setAttribute("page", page);
        // 不将page.getGoodsBeanList（）建立session
        request.setAttribute("IndexGoods", page.getGoodsBeanList());
        request.setAttribute("PageCode", page.getPageCode());
        request.setAttribute("PageSize", page.getPageSize());
        request.setAttribute("TotalPage", page.getTotalPage());
        request.getRequestDispatcher("/JSP/usedGoods/search.jsp").forward(request, response);

    }
}
