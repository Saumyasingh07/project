package com.niit.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;
import com.niit.model.Users;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class CustomerDaoImplTest {
	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testSaveCustomer() {
		Customer customer=new Customer();
		customer.setFirstname("james");
		customer.setLastname("smith");
		customer.setEmail("j.s@abc.com");
		customer.setPhone("0987654312");
		
		BillingAddress billingAddress=new BillingAddress();
		billingAddress.setStreetname("abc");
		billingAddress.setApartmentnumber("123");
		billingAddress.setCity("chennai");
		billingAddress.setCountry("India");
		billingAddress.setZipcode("600010");
		
		ShippingAddress shippingAddress=new ShippingAddress();
		shippingAddress.setStreetname("abc");
		shippingAddress.setApartmentnumber("123");
		shippingAddress.setCity("chennai");
		shippingAddress.setCountry("India");
		shippingAddress.setZipcode("600010");
		
		Users users=new Users();
		users.setUsername("james");
		users.setPassword("123");
		users.setEnabled(true);
		
		Authorities authorities=new Authorities();
		authorities.setUsername("james");
		authorities.setRole("ROLE_USER");
		
		Cart cart=new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		customer.setUsers(users);
		
		customerDao.saveCustomer(customer);
		
		assertTrue(customer.getId()>0);
		assertTrue(customer.getBillingAddress().getId()>0);
		
		
	}

	@Test
	public void testGetCustomers() {
	  List<Customer> customers=customerDao.getCustomers();	
	  assertTrue(customers.size()>0);
	}

}
