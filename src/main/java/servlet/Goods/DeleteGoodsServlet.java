package servlet.Goods;

import javaBean.User;
import services.GoodsServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Goods/delete")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录，跳转到登录界面
        if((User)request.getSession().getAttribute("my")==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        int gid = Integer.parseInt(request.getParameter("gid"));
        String uid = request.getParameter("uid");
        GoodsServices houseService=new GoodsServices();
        boolean isDeleteSuccess = houseService.deleteByGid(gid);
        if(isDeleteSuccess){
            //这里的uid会覆盖登录人的uid！！！
            request.setAttribute("uid",uid);
            request.setAttribute("isDeleteSuccess",isDeleteSuccess);
            request.getRequestDispatcher("/listByPage").forward(request,response);
        }
    }
}
