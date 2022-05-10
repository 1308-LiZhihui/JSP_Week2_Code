package com.LiZhihui.controller;

import com.LiZhihui.dao.ProductDao;
import com.LiZhihui.model.Category;
import com.LiZhihui.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con = null ;
    private static final Logger Log = Logger.getLogger(String.valueOf(AddProductServlet.class));

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();//just puts "destroy" in log
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        try {
            List<Category> categoryList=category.findAllCategory(con);
            req.setAttribute("categoryList",categoryList);
            String path = "/WEB-INF/views/admin/addProduct.jsp";
            req.getRequestDispatcher(path).forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        Double price = req.getParameter("price")!=null?Double.parseDouble(req.getParameter("price")):0.0;
        int categoryId =req.getParameter("categoryId")!=null?Integer.parseInt(req.getParameter("categoryId")):8;
        String productDescription = req.getParameter("productDescription");
        InputStream inputStream = null;
        Part filePart = req.getPart("picture");
        if(filePart!=null){
            //print out some information for debugging
            System.out.println("file name:"+filePart.getName()+"size"+filePart.getSize()+"fileType"+filePart.getContentType());
            inputStream =filePart.getInputStream();//obtains input stream of the upload file

        }
        //t in model
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        product.setPicture(inputStream);
        ProductDao dao = new ProductDao();
        int i = 0;

        try {
            i = dao.save(product,con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i>0){
            //response.senRedirect("productList");//next class
        }

    }//end post
}
