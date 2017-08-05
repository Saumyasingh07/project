package com.niit.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired	
	private CartItemDao cartItemDao;
	public boolean save(CartItem cartitems){
		return cartItemDao.save(cartitems);
	}
	public boolean update(CartItem cartitems){
		return cartItemDao.update(cartitems);
	}
	public boolean delete(CartItem cartitems){
		return cartItemDao.delete(cartitems);
	}
	public CartItem get(int id){
		return cartItemDao.get(id);
	}
	public List<CartItem> list(Cart cart){
		return cartItemDao.list(cart);
	}
	public void deletecartitemById(int id){
	cartItemDao.deletecartitemById(id);
}
	public CartItem getCartItemWithCartAndProduct(int productid,int cartid){
		return cartItemDao.getCartItemWithCartAndProduct(productid,cartid);
	}
	
	public boolean deleteAll(Integer cartId){
		return cartItemDao.deleteAll(cartId);
		}
		
	}
