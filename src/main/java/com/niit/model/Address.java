package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	private static final String Customer = null;
	private static final String Cart = null;
	private static final String Address = null;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String apartmentnumber;
	@NotEmpty
	private String streetname;
	public void setCart(String cart) {
		this.cart = cart;
	}
	@NotEmpty
	private String city;
	@NotEmpty
	private String country;
	@NotEmpty
	private String zipcode;
	private String cart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApartmentnumber() {
		return apartmentnumber;
	}
	public void setApartmentnumber(String apartmentnumber) {
		this.apartmentnumber = apartmentnumber;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(Address address) {
		this.cart = Address;
	}
	public static String getAddress() {
		return Address;
	}
	public String getShipping() {
		return Cart;
	}
	public void setAddress(Address address) {
    this.cart=Address;
	}
	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.cart=Customer;
	}
	public String getCustomer() {
		// TODO Auto-generated method stub
		return Address;
	}
}