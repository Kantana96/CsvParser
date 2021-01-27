package com.example.demo.models;

import com.opencsv.bean.CsvBindByName;

public class Sale {
	@CsvBindByName(column = "Row ID")
	private String id;
	@CsvBindByName(column = "Order ID")
	private String orderId;
	@CsvBindByName(column = "Order Date")
	private String orderDate;
	@CsvBindByName(column = "Ship Date")
	private String shipDate;
	@CsvBindByName(column = "Ship Mode")
	private String shipMode;
	@CsvBindByName(column = "Customer ID")
	private String customerId;
	@CsvBindByName(column = "Customer Name")
	private String customerName;
	@CsvBindByName(column = "Segment")
	private String segment;
	@CsvBindByName(column = "Country")
	private String country;
	@CsvBindByName(column = "City")
	private String city;
	@CsvBindByName(column = "State")
	private String state;
	@CsvBindByName(column = "Postal Code")
	private String postalCode;
	@CsvBindByName(column = "Region")
	private String region;
	@CsvBindByName(column = "Product ID")
	private String productId;
	@CsvBindByName(column = "Category")
	private String category;
	@CsvBindByName(column = "Sub-Category")
	private String subCategory;
	@CsvBindByName(column = "Product Name")
	private String productName;
	@CsvBindByName(column = "Sales")
	private double sales;
	@CsvBindByName(column = "Quantity")
	private int quantity;
	@CsvBindByName(column = "Discount")
	private double discount;
	@CsvBindByName(column = "Profit")
	private double profit;
	public Sale() {}
	public Sale(String id, String orderId, String orderDate, String shipDate, String shipMode, String customerId,
			String customerName, String segment, String country, String city, String state, String postalCode,
			String region, String productId, String category, String subCategory, String productName, double sales,
			int quantity, int discount, double profit) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.shipMode = shipMode;
		this.customerId = customerId;
		this.customerName = customerName;
		this.segment = segment;
		this.country = country;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.region = region;
		this.productId = productId;
		this.category = category;
		this.subCategory = subCategory;
		this.productName = productName;
		this.sales = sales;
		this.quantity = quantity;
		this.discount = discount;
		this.profit = profit;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getShipMode() {
		return shipMode;
	}
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}	
}
