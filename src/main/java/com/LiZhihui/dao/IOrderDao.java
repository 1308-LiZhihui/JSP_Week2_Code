package com.LiZhihui.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.LiZhihui.model.Item;
import com.LiZhihui.model.Order;

public interface IOrderDao {

	/**
	 * Save Order instance into Order Table 
	 * @param con
	 * @param order
	 * @return int
	 */
	int save(Connection con, Order order) throws SQLException;

	/**
	 * Delete a Order 
	 * @param con
	 * @param order
	 * @return int
	 */
	int delete(Connection con, Order order);

	/**
	 * Update a Order 
	 * @param con
	 * @param order
	 * @return int
	 */
	int update(Connection con, Order order);

	/**
	 *Select a Order by orderId
	 * @param con
	 * @param id
	 * @return com,dabing.model.Order
	 */
	Order findById(Connection con, int id);

	/**
	 * Generic method to get List of Order using propertyname and value
	 * @param con
	 * @param propertyName
	 * @param value
	 * @return List of com.dabing.model.Order 
	 */
	List<Order> findByProperty(Connection con, String propertyName, Object value);

	/**
	 * Get a Order List by first name 
	 * @param con
	 * @param firstName
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByFirstName(Connection con, Object firstName);

	/**
	 * Get a Order List by last name 
	 * @param con
	 * @param lastName
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByLastName(Connection con, Object lastName);

	/**
	 * Get a Order List by address1  
	 * @param con
	 * @param address1
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByAddress1(Connection con, Object address1);

	/**
	 * @param con
	 * @param address2
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByAddress2(Connection con, Object address2);

	/**
	 * @param con
	 * @param city
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByCity(Connection con, Object city);

	/**
	 * @param con
	 * @param state
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByState(Connection con, Object state);

	/**
	 * @param con
	 * @param postalCode
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByPostalCode(Connection con, Object postalCode);

	/**
	 * @param con
	 * @param country
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByCountry(Connection con, Object country);

	/**
	 * @param con
	 * @param phone
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByPhone(Connection con, Object phone);

	/**
	 * @param con
	 * @param notes
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByNotes(Connection con, Object notes);

	/**
	 *
	 * @param con
	 * @param orderTotal
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByOrderTotal(Connection con, Object orderTotal);

	/**
	 * Select All List of Order
	 * @param con
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findAll(Connection con);

	/**
	 * Select Order list by user id
	 * @param con
	 * @param value
	 * @return  List of com.dabing.model.Order 
	 */
	List<Order> findByUserId(Connection con, Object value);

	List<Item> findItemsByOrderId(Connection con, int orderId);
}
