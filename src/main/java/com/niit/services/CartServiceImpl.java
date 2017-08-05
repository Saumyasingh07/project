package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.Cart;
@Service
public class CartServiceImpl implements CartService{
	
	
	@Autowired	
	private CartDao cartDao;
	public boolean save(Cart cart) {
		   return cartDao.save(cart);
			
		}
	public boolean update(Cart cart) {
			return cartDao.update(cart);
		}
	public boolean delete(Cart cart) {
			return cartDao.delete(cart);
		}
	public Cart get(int id){
	return cartDao.get(id);
	}
	public List<Cart> list() {
		return	cartDao.list();
			
		}

	}
