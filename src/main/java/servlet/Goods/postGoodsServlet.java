package servlet.Goods;

import javaBean.Goods;
import javaBean.User;
import services.GoodsServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/postGoods")
@MultipartConfig(location = "F:\\curriculumDesign\\src\\main\\webapp\\images\\goods")
public class postGoodsServlet extends HttpServlet {

    GoodsServices goodsServices = new GoodsServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("对不起，不支持 get 方式上传图片！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        Part p=request.getPart("photo");
        p.write(p.getSubmittedFileName());

        User user = (User)request.getSession().getAttribute("my");
        //未登录，跳转到登录界面
        if(user==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        Goods goods = new Goods();
        goods.setUid(user.getUid());
        goods.setName(request.getParameter("name"));
        goods.setType(request.getParameter("type"));
        goods.setPrice(Integer.parseInt(request.getParameter("money")));
        goods.setDescription(request.getParameter("description"));
        goods.setOld(request.getParameter("old"));
        goods.setColor(request.getParameter("color"));
        goods.setGimage("/"+p.getSubmittedFileName());

        int gid = 0;
        gid = goodsServices.postGoods(goods);
        //发布类别为二手商品
        int postType = 2;
        request.setAttribute("postId",gid);
        request.setAttribute("postType",postType);
        request.getRequestDispatcher("/JSP/postOver.jsp").forward(request,response);
    }
}
