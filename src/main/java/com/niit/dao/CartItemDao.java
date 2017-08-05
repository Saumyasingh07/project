package com.niit.dao;


	import java.util.List;

	import com.niit.model.Cart;
	import com.niit.model.CartItem;

	public interface CartItemDao {
		public boolean save(CartItem cartitem);
		public boolean update(CartItem cartitem);
		public boolean delete(CartItem cartitem);
		public CartItem get(int id);
		public List<CartItem> list(Cart cart);
		public void deletecartitemById(int id);
		public CartItem getCartItemWithCartAndProduct(int productid,int cartid);
		boolean deleteAll(Integer cartId);

		
	}
