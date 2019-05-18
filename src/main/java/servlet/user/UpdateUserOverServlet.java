package servlet.user;

import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateUserOver")
public class UpdateUserOverServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //权限不够，暂时回到主页
        User my = (User)request.getSession().getAttribute("my");
        if(my.getType()!=3)
            request.getRequestDispatcher("/index").forward(request,response);

        UserServices userServices = new UserServices();
        User user = new User();
        user.setUid(request.getParameter("uid"));
        user.setName(request.getParameter("updateUserName"));
        user.setType(Integer.parseInt(request.getParameter("updateUserType")));
        user.setEmail(request.getParameter("updateUserEmail"));
        user.setCoin(Integer.parseInt(request.getParameter("updateUserCoin")));

        boolean isUpdateSuccessed = userServices.updateService(user);

        request.setAttribute("isUpdateSuccessed",isUpdateSuccessed);
        request.getRequestDispatcher("/user/manageUser").forward(request,response);
    }
}
