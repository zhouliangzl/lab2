package servlet.Goods;

import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsPurchaseServlet")
public class GoodsPurchaseServlet extends HttpServlet {
    UserServices userServices=new UserServices();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        String uid = request.getParameter("uid");
            User user = userServices.searchByUid(uid);
            //这里会覆盖原来的user
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("userNickname",user.getName());
            request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request , response);

    }
}
