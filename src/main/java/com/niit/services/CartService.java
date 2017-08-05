package com.niit.services;



import java.util.List;

import com.niit.model.Cart;



public interface CartService {
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart cart);
	public Cart get(int id);
	public List<Cart> list();

}
