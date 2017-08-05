package com.niit.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class Cart implements Serializable {
	
	private static final long serialVersionUID=6778L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY  )
	private int id;
	
	private double grandtotal;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cart",fetch=FetchType.EAGER)
	private Set<CartItem> cartItem;

    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@Valid
	private Users users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}	
	