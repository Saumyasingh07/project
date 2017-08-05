package com.niit.dao;


import java.util.List;

	import org.hibernate.Query;

	import org.hibernate.HibernateException;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

	import com.niit.dao.CartItemDao;
	import com.niit.model.Cart;
	import com.niit.model.CartItem;
@EnableTransactionManagement
	@Repository("cartitemdao")
	@Transactional
	public class CartItemDaoImpl implements CartItemDao{
		@Autowired
		SessionFactory sessionfactory;
	    public CartItemDaoImpl(SessionFactory sessionfactory){
	    	this.sessionfactory=sessionfactory;
	    }

		public boolean save(CartItem cartitem) {
			try{
				sessionfactory.getCurrentSession().save(cartitem);
				return true;
			}catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
		}
	
		public boolean update(CartItem cartitems) {
			
			sessionfactory.getCurrentSession().update(cartitems);
			return false;
		}
	
		public boolean delete(CartItem cartitems) {
	try{
				
				sessionfactory.getCurrentSession().delete(cartitems);	
					
				 return true;	
				}catch(Exception e){e.printStackTrace();}
				return false;

			
		}
		public CartItem get(int id) {
			return (CartItem) sessionfactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
		} 
	
		public List<CartItem> list(Cart cart) {
					
	List<CartItem> list = ((Query) sessionfactory.getCurrentSession().createQuery("from CartItem where cart_id = :id").setParameter("id", cart.getId())).list();
				return list;
			}
		public void deletecartitemById(int id) {
			CartItem cartitem=new CartItem();
			cartitem.setId(id);
			sessionfactory.getCurrentSession().delete(cartitem);
			
		}
	
		public CartItem getCartItemWithCartAndProduct(int productid, int cartid) {
			try{
			Query q=(Query) sessionfactory.getCurrentSession().createQuery("From CartItem where cart_id=:cartid and product_id=:proid");
			q.setParameter("cartid", cartid);
			q.setParameter("proid", productid);
			return (CartItem)q.list();
			}catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
	
		public boolean deleteAll(Integer cartId) {
			try {
				sessionfactory.getCurrentSession().createQuery("Delete from CartItems where cart_id=:id")
				.setParameter("id", cartId).executeUpdate();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
}
	