package com.LiZhihui.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractOrder entity provides the base persistence definition of the Order
 * entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Order implements java.io.Serializable {

	// Fields

	private int orderId;
	private int customerId;
	private int paymentId;
	private Timestamp orderDate;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String phone;
	private String notes;
	private Double orderTotal;
	private Set<Item> orderDetails = new HashSet<Item>(0);//1 order may have items

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(int customerId, int paymentId,
			Timestamp orderDate, String firstName, String lastName,
			String address1) {
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.orderDate = orderDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
	}
	/** full constructor */
	public Order(int customerId, int paymentId,
			Timestamp orderDate, String firstName, String lastName,
			String address1, String address2, String city, String state,
			String postalCode, String country, String phone, String notes,
			Double orderTotal) {
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.orderDate = orderDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.notes = notes;
		this.orderTotal = orderTotal;
	}

	// Property accessors

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Double getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Set<Item> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<Item> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId
				+ ", paymentId=" + paymentId + ", orderDate=" + orderDate
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", phone=" + phone
				+ ", notes=" + notes + ", orderTotal=" + orderTotal
				+ ", orderDetails=" + orderDetails.toString() + "]";
	}

}
