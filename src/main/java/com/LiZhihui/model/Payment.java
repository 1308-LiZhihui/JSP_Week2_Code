package com.LiZhihui.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * AbstractPayment entity provides the base persistence definition of the
 * Payment entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public  class Payment implements java.io.Serializable {
	// Fields

	private int paymentId;
	private String paymentType;
	private Boolean allowed;

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(String paymentType, Boolean allowed) {
		this.paymentType = paymentType;
		this.allowed = allowed;
	}

	/** full constructor */
	public Payment(String paymentType, Boolean allowed, Set orders) {
		this.paymentType = paymentType;
		this.allowed = allowed;
	}

	// Property accessors

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Boolean getAllowed() {
		return this.allowed;
	}

	public void setAllowed(Boolean allowed) {
		this.allowed = allowed;
	}

	public static List<Payment> findAllPayment(Connection con){
		List<Payment> list=new ArrayList<Payment>();
		try {
			String queryString = "select * from  Payment";
			PreparedStatement	statement = con.prepareStatement(queryString);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Payment c = new Payment();
				c.setPaymentId(resultSet.getInt("PaymentId"));
				c.setPaymentType(resultSet.getString("PaymentType"));
				c.setAllowed(resultSet.getInt("allowed")==1?true:false);
				list.add(c);
			}
		} catch (Exception re) {
		try {
				throw re;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
public static String findByPaymentId(Connection con,int paymentId){
	String paymentType=null;
	try {
		String queryString = "select PaymentType from  Payment where PaymentId=?";
		PreparedStatement	statement = con.prepareStatement(queryString);
		statement.setInt(1, paymentId);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			paymentType=resultSet.getString("PaymentType");
		}
	} catch (Exception re) {
		try {
			throw re;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return paymentType;
}

}