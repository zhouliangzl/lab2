package servlet.user;

import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateUserStart")
public class UpdateUserStartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //权限不够，暂时回到主页
        User my = (User)request.getSession().getAttribute("my");
        if(my.getType()!=3)
            request.getRequestDispatcher("/index").forward(request,response);

        String uid = request.getParameter("uid");
        UserServices userServices=new UserServices();

        User updateUser = new User();
        updateUser = userServices.searchByUid(uid);

        request.setAttribute("updateUser",updateUser);
        request.getRequestDispatcher("/JSP/user/updateUser.jsp").forward(request,response);
    }
}
