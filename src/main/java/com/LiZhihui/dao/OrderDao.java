
package com.LiZhihui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import com.LiZhihui.model.Item;
import com.LiZhihui.model.Order;

import com.LiZhihui.model.Product;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @author dabing
 */
public class OrderDao implements IOrderDao {

	@Override 
	public int save(Connection con,Order order) throws SQLException {
		int flag=0;
		try {
			//By default,committed right after it is executed,disable the auto commit mode to enable two or more statements to be grouped into a transaction// begin the transaction:
			con.setAutoCommit(false);
			//sql =INSERT INTO userdb.order for mysql
			int orderid = 0;
			String sql10 = "select isnull(max(orderid),0) max from [Order]";
			PreparedStatement preparedStatement = con.prepareStatement(sql10);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				orderid = resultSet.getInt("max");
			}
			String sql="INSERT INTO [dbo].[order](CustomerID,PaymentID,OrderDate,FirstName,LastName,Address1,Address2,city,state,PostalCode,Country,Phone,Notes,OrderTotal,orderid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, order.getCustomerId());
			st.setInt(2, order.getPaymentId());
			Calendar cal = Calendar.getInstance(); 	//date and time
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			st.setTimestamp(3, timestamp);
			st.setString(4, order.getFirstName());
			st.setString(5, order.getLastName());
			st.setString(6, order.getAddress1());
			st.setString(7, order.getAddress2());
			st.setString(8, order.getCity());
			st.setString(9, order.getState());
			st.setString(10, order.getPostalCode());
			st.setString(11, order.getCountry());
			st.setString(12, order.getPhone());
			st.setString(13, order.getNotes());
			st.setDouble(14, order.getOrderTotal());
			st.setInt(15,orderid+1);
			flag = st.executeUpdate();//insert a row in order table
			
			//get newly inserted OrderId-select
				String lastId="SELECT max(orderid) as orderId from [dbo].[order] ";//"SELECT max(orderid) as orderId from userdb.order"; for mysql
				ResultSet rs=con.createStatement().executeQuery(lastId);
				rs.next();
				int orderId=rs.getInt("orderId");
				//set all orderDetails
				Set<Item> orderDetails =order.getOrderDetails();
				//OrderDetailsDao odDao=new OrderDetailsDao();
				Iterator<Item> i=orderDetails.iterator();
			int OrderDetailId = 0;
			String sql9 = "select isnull(max(OrderDetailId),0) max from OrderDetail";
			PreparedStatement preparedStatement1 = con.prepareStatement(sql9);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()){
				OrderDetailId = resultSet1.getInt("max");
			}
				String sql1="INSERT INTO orderdetail(OrderID,ProductID,price,Quantity,Total,OrderDetailId) values(?,?,?,?,?,?)";
				PreparedStatement st1 = con.prepareStatement(sql1);
				while(i.hasNext()){
					Item item= i.next();
					st1.setInt(1, orderId);
					st1.setInt(2, item.getProduct().getProductId());
					st1.setDouble(3, item.getProduct().getPrice());
					st1.setInt(4, item.getQuantity());
					st1.setDouble(5, item.getQuantity()*item.getProduct().getPrice());
					st1.setInt(6,OrderDetailId+1);
					 flag = st1.executeUpdate();
				}
			 con.commit();	//commit the transaction-all SQL statements committed as a single unit
			} catch (Exception re) {
			try {
				con.rollback();//If any statement failed to execute,abort the transaction:
				throw re;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}finally{
			con.setAutoCommit(true);
		}
		return flag;
	}//end save
	@Override 
	public int delete(Connection con,Order order) {
		return 0;
	}
	@Override 
	public int update(Connection con,Order order) {
			return 0;
	}
	@Override 
	public Order findById(Connection con,int id) {

		return findByProperty(con,"orderId", id).get(0);
	}
	@Override 
	public List<Order> findByProperty(Connection con,String propertyName, Object value) {
		System.out.println("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		List<Order> orderList=new ArrayList<Order>();
		try {
			String queryString = "select * from [dbo].[order] as model where model."+ propertyName + "= ?";//use userdb.Order for mysql
			PreparedStatement st = con.prepareStatement(queryString);
			st.setObject(1, value);
			ResultSet	rs = st.executeQuery();
			while(rs.next()){
				Order o=new Order();
				o.setOrderId(rs.getInt("OrderID"));
				o.setCustomerId(rs.getInt("CustomerID"));
				o.setPaymentId(rs.getInt("PaymentID"));
				o.setOrderDate(rs.getTimestamp("OrderDate"));
				o.setFirstName(rs.getString("FirstName"));
				o.setLastName(rs.getString("LastName"));
				o.setAddress1(rs.getString("Address1"));
				o.setAddress2(rs.getString("Address2"));
				o.setCity(rs.getString("city"));
				o.setState(rs.getString("State"));
				o.setPostalCode(rs.getString("PostalCode"));
				o.setCountry(rs.getString("Country"));
				o.setPhone(rs.getString("Phone"));
				o.setNotes(rs.getString("Notes"));
				o.setOrderTotal(rs.getDouble("OrderTotal"));
				
				orderList.add(o);
			}
		} catch (RuntimeException | SQLException re) {
			try {
				throw re;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	@Override 
	public List<Order> findByUserId(Connection con,Object CustomerID) {
		return findByProperty(con,"CustomerID", CustomerID);
	}

	@Override 
	public List<Order> findByFirstName(Connection con,Object firstName) {
		return findByProperty(con,"firstName", firstName);
	}
	@Override 
	public List<Order> findByLastName(Connection con,Object lastName) {
		return findByProperty(con,"LastName", lastName);
	}
	@Override 
	public List<Order> findByAddress1(Connection con,Object address1) {
		return findByProperty(con,"ADDRESS1", address1);
	}
	@Override 
	public List<Order> findByAddress2(Connection con,Object address2) {
		return findByProperty(con,"ADDRESS2", address2);
	}
	@Override 
	public List<Order> findByCity(Connection con,Object city) {
		return findByProperty(con,"CITY", city);
	}
	@Override 
	public List<Order> findByState(Connection con,Object state) {
		return findByProperty(con,"STATE", state);
	}
	@Override 
	public List<Order> findByPostalCode(Connection con,Object postalCode) {
		return findByProperty(con,"POSTAL_CODE", postalCode);
	}
	@Override 
	public List<Order> findByCountry(Connection con,Object country) {
		return findByProperty(con,"COUNTRY", country);
	}
	@Override 
	public List<Order> findByPhone(Connection con,Object phone) {
		return findByProperty(con,"PHONE", phone);
	}
	@Override 
	public List<Order> findByNotes(Connection con,Object notes) {
		return findByProperty(con,"NOTES", notes);
	}
	@Override 
	public List<Order> findByOrderTotal(Connection con,Object orderTotal) {
		return findByProperty(con,"ORDER_TOTAL", orderTotal);
	}
	@Override 
	public List<Order> findAll(Connection con) {

		List<Order> orderList=new ArrayList<Order>();
		try {
			String queryString = "select * from [dbo].[Order]";// userdb.Order for mysql
			PreparedStatement st = con.prepareStatement(queryString);
			//st.setObject(1, value);
			ResultSet	rs = st.executeQuery();
			while(rs.next()){
				Order o=new Order();
				o.setOrderId(rs.getInt("OrderID"));
				o.setCustomerId(rs.getInt("CustomerID"));
				o.setPaymentId(rs.getInt("PaymentID"));
				o.setOrderDate(rs.getTimestamp("OrderDate"));
				o.setFirstName(rs.getString("FirstName"));
				o.setLastName(rs.getString("LastName"));
				o.setAddress1(rs.getString("Address1"));
				o.setAddress2(rs.getString("Address2"));
				o.setCity(rs.getString("city"));
				o.setState(rs.getString("State"));
				o.setPostalCode(rs.getString("PostalCode"));
				o.setCountry(rs.getString("Country"));
				o.setPhone(rs.getString("Phone"));
				o.setNotes(rs.getString("Notes"));
				o.setOrderTotal(rs.getDouble("OrderTotal"));
				
				orderList.add(o);
			}
		} catch (RuntimeException | SQLException re) {
			try {
				throw re;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	
@Override
	public List<Item> findItemsByOrderId(Connection con,int orderId) {
		List<Item> itemList=new ArrayList<Item>();
		try {
			String sql="SELECT 	* FROM orderdetail AS o INNER JOIN product AS p ON o.ProductId=p.ProductId WHERE o.OrderID="+orderId;
			ResultSet rs=con.createStatement().executeQuery(sql);
			while(rs.next()){
				Item i=new Item();
				Product p=new Product();
				p.setProductId(rs.getInt("ProductId"));
				p.setPrice(rs.getDouble("price"));
				p.setProductName(rs.getString("productName"));
				i.setQuantity(rs.getInt("quantity"));
				i.setProduct(p);
				itemList.add(i);
			}
		} catch (RuntimeException | SQLException re) {;
			try {
				throw re;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemList;
	}

}//end