package servlet.house;

import javaBean.House;
import javaBean.Page;
import javaBean.User;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/houseListByPage")
public class HouseDivideByPageServlet extends HttpServlet{

    HouseService HouseServices = new HouseService();
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
        User my = (User)request.getSession().getAttribute("my");
        if(my==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        UserServices userServices = new UserServices();
        my = userServices.searchByUid(my.getUid());

        int pageCode = getPageCode(request);
        int pageSize = 3;
        Page<House> page = HouseServices.findByPage( pageCode, pageSize ,my.getUid());
        page.setGoodsBeanList(null);
//        不将page建立session
        request.setAttribute("page",page);
//        不将page.getGoodsBeanList（）建立session
        request.setAttribute("houses",page.getHouseBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getSession().setAttribute("my",my);
        request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
    }
}