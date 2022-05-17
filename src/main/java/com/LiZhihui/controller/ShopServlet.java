package com.LiZhihui.controller;

import com.LiZhihui.dao.ProductDao;
import com.LiZhihui.model.Category;
import com.LiZhihui.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set all category into request
        Category category = new Category();
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //set all product into request
        ProductDao productDao = new ProductDao();
        try {
            if(request.getParameter("categoryId")==null) {
                //show all product
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList", productList);
            }else{
                //show only one type of product
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList=productDao.findByCategoryId(catId,con);
                request.setAttribute("productList", productList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //forward
        String path ="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
