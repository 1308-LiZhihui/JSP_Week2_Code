package com.LiZhihui.controller;


import com.LiZhihui.dao.ProductDao;
import com.LiZhihui.model.Item;
import com.LiZhihui.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    if(session!=null&& session.getAttribute("user")!=null){
        //user has logged in
        if(request.getParameter("action")==null){
            displayCart(request,response);
        }else if(request.getParameter("action").equals("add")){
            buy(request,response);
        }else if(request.getParameter("action").equals("remove")){
            remove(request,response);
        }
    }else{
        //no login
        response.sendRedirect("login");
    }
    }
    private  void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //remove item cart
        List<Item> cart = (List<Item>) request.getSession().getAttribute("cart");
        int id = 0;
        if(request.getParameter("productId")!=null){
            id = Integer.parseInt(request.getParameter("productId"));
        }
        int index = isExisting(id,cart);
        cart.remove(index);
        request.getSession().setAttribute("cart",cart);
        String path=request.getContextPath()+"/cart";
        response.sendRedirect(path);
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //add item cart -
        HttpSession session = request.getSession();
        int id =request.getParameter("productId")!=null? Integer.parseInt(request.getParameter("productId")):0;
        int quantity =request.getParameter("quantity")!=null? Integer.parseInt(request.getParameter("quantity")):1;
        if(id == 0 || quantity == 0){
            //error
            return;
        }
        ProductDao productDao = new ProductDao();
        if(session.getAttribute("cart")==null){
            //create new cart
            List<Item> cart = new ArrayList<Item>();
            Product p=productDao.findById(id,con);
            cart.add(new Item(p,quantity));
            session.setAttribute("cart",cart);
            }else{
            //have cart - need to add item
            List<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
            //check if product already in cart - add quantity++ or not - add new item into cart
            int index=isExisting(id,cart);
            if(index==-1){
                //new item
                Product p=productDao.findById(id,con);
                cart.add(new Item(p,1));
            }else{
                //only quantity++
               int newQuantity= cart.get(index).getQuantity()+1;//add 1
                cart.get(index).setQuantity(newQuantity);

            }
            session.setAttribute("cart",cart);
        }//end else
        response.sendRedirect(request.getContextPath()+"/cart");
        }

    private int isExisting(int id, List<Item> cart) {
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getProduct().getProductId()==id){
                return i;//index of in the cart list
            }
        }
        return -1;//if item is not in cart

    }


    private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Your Cart");
        String path="/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
