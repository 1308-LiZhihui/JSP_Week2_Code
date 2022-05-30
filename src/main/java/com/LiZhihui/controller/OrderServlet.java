package com.LiZhihui.controller;

import com.LiZhihui.dao.OrderDao;
import com.LiZhihui.model.Item;
import com.LiZhihui.model.Order;
import com.LiZhihui.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    Connection con=null;
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
        //get all payemaent type
        List<Payment> paymentTypeList=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        String path="/WEB-INF/views/order.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = request.getParameter("customerId")!=null?Integer.parseInt(request.getParameter("customerId")) : 0;
        int paymentId = request.getParameter("paymentId")!=null? Integer.parseInt(request.getParameter("paymentId")) : 0;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone =request.getParameter("phone");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String postalCode = request.getParameter("postalCode");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String notes = request.getParameter("notes");
        double orderTotal = request.getParameter("orderTotal")!=null? Double.parseDouble(request.getParameter("orderTotal")) :0.0;

        String message = null;
        if(customerId==0|| paymentId==0|| firstName==null||firstName.trim().length()==0|| phone==null|| phone.trim().length()==0||
                address1==null||address1.trim().length()==0|| postalCode==null||postalCode.trim().length()==0){
            //ERROR
            message = "Error! Enter Require(*) Info.";
            request.setAttribute("message", message);
            List<Payment> paymentTypeList = Payment.findAllPayment(con);
            request.setAttribute("paymentTypeList", paymentTypeList);
            String path = "WEB-INF/views/order.jsp";
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setPaymentId(paymentId);
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setPhone(phone);
        order.setAddress1(address1);
        order.setAddress2(address2);
        order.setCity(city);
        order.setCountry(country);
        order.setState(state);
        order.setNotes(notes);
        order.setPostalCode(postalCode);
        order.setOrderTotal(orderTotal);
        order.setPaymentId(paymentId);
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("cart")!=null){
            ArrayList<Item> cartItems = (ArrayList<Item>) session.getAttribute("cart");
            order.setOrderDetails(new HashSet<Item>(cartItems));//list to set
        }
        //save order
        OrderDao dao = new OrderDao();
        int n = 0;
        try {
            n = dao.save(con,order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //forward
        if(n>0){
            String path = "WEB-INF/views/orderSuccess.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        }
    }
}
