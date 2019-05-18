package servlet.user;

import javaBean.Page;
import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/manageUser")
public class ManageUsersServlet extends HttpServlet {

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
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //权限不够，暂时回到主页
        User my = (User)request.getSession().getAttribute("my");
        if(my.getType()!=3)
            request.getRequestDispatcher("/index").forward(request,response);

        UserServices userServices = new UserServices();
        int pageCode = getPageCode(request);
        int pageSize = 4;
        Page<User> page = userServices.findByPage( pageCode, pageSize);
//不将page建立session
        request.setAttribute("pages",page);
// 不将page.getGoodsBeanList（）建立session
        request.setAttribute("users",page.getGoodsBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getRequestDispatcher("/JSP/user/manageUser.jsp").forward(request,response);
    }

}
