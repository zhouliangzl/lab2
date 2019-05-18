package servlet.house;

import javaBean.House;
import javaBean.Page;
import javaBean.SignHouse;
import javaBean.User;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet("/SignHouseListByPage")
public class SignHouseDivideByPage extends HttpServlet{

    HouseService signHouseServices = new HouseService();
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
        User user = (User)request.getSession().getAttribute("my");
        if(user==null)
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        HouseService houseService = new HouseService();
        int pageCode = getPageCode(request);
        int pageSize = 2;
        Page<SignHouse> page = new Page<>();
        List<House> houseList = new ArrayList<>();

        try{
            page = signHouseServices.SignfindByPage( pageCode, pageSize ,user.getUid());
            houseList = houseService.loadBySignList(page);
        } catch (Exception e){
            System.out.println("SignHouseDivideByPage:联级查询合同和租房信息失败！");
            e.printStackTrace();
        }

        //不将page建立session
        request.setAttribute("page",page);
        // 不将page.getGoodsBeanList（）建立session
        request.setAttribute("housess", houseList);
        request.setAttribute("housesSize",houseList.size()-1);
        request.setAttribute("signHouses",page.getSignHouseBeanList());
        request.setAttribute("PageCode",page.getPageCode());
        request.setAttribute("PageSize",page.getPageSize());
        request.setAttribute("TotalPage",page.getTotalPage());
        request.getRequestDispatcher("/JSP/user/userInfo.jsp").forward(request,response);
    }
}