package servlet.user;

import javaBean.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet
{
    UserServices userServices=new UserServices();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        //
        String type=request.getParameter("type");
        String password=request.getParameter("password");

        User user = new User();
        user=userServices.login(uid,password);

        if(user.getActive().equals("0")){
            String loginMsg="未使用邮箱激活账号，请打开您的邮箱激活！";
            request.setAttribute("loginMsg",loginMsg);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else if(user!=null&&user.getActive().equals("1")) {
            request.getSession().setAttribute("my",user);
            request.getSession().setAttribute("userNickname",user.getName());
            request.getSession().setAttribute("uid",user.getUid());
            request.getSession().setAttribute("type",user.getType());
            request.getRequestDispatcher("/index").forward(request,response);
       }
       else
       {
           String loginMsg="用户名或密码错误";
           request.setAttribute("loginMsg",loginMsg);
           request.getRequestDispatcher("/login.jsp").forward(request,response);
       }
    }
}
