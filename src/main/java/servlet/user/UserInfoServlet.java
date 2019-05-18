package servlet.user;

import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    UserServices us = new UserServices();
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String uid = user.getUid();
//        通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?
        req.getSession().setAttribute("user",user);
        req.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(req , resp);
    }
}
