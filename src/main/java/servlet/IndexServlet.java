package servlet;

import javaBean.Goods;
import javaBean.House;
import javaBean.User;
import services.GoodsServices;
import services.HouseService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<House> houseList = new ArrayList<>();
        List<Goods> goodsList = new ArrayList<>();
        System.out.println();
        HouseService houseService = new HouseService();
        GoodsServices goodsServices = new GoodsServices();
        try {
            goodsList = goodsServices.load(8);
            houseList = houseService.load(8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int goodsSize = goodsList.size();
        Goods[] goodss = (Goods[]) goodsList.toArray(new Goods[goodsSize]);
        int houseSize = houseList.size();
        House[] houses = (House[]) houseList.toArray(new House[houseSize]);

        request.setAttribute("goodss",goodss);
        request.setAttribute("houses",houses);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}