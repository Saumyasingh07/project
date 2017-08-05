package com.niit.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.services.CartItemService;
import com.niit.services.CartService;
import com.niit.services.CategoryService;
import com.niit.services.CustomerService;
import com.niit.services.ProductService;
import com.niit.model.Customer;

@Controller
@RequestMapping
public class CartController {
	

	@Autowired
	CustomerService customerService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	
	
	
	

	@RequestMapping("customer/product/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addToCart(Principal principal,@PathVariable("id") Integer id,ModelMap model)
	{
	
			 	   Customer customer=customerService.getcustomerbyname(principal.getName());
	    	  Cart cart=customer.getCart();
	    	     	  
	    		    if(cart==null){
	    	cart=new Cart();
	    	customer.setCart(cart);
	    	cart.setCustomer(customer);
	       customerService.update(customer);
	    }
	    	  
Product product=productService.getProductById(id);
CartItem cartItem= (CartItem) cartItemService.getCartItemWithCartAndProduct(id,cart.getId());
	     if(cartItem==null){
	    	    	 cartItem=new CartItem();
	    	    	 cartItem.setCart(cart); 
	    	   	  cartItem.setProduct(product);
	    	   	  cartItem.setQuantity(1);
	    	   	  
	    	   	  cartItem.setTotalPrice(product.getPrice() );
	    	   	  
     cart.setGrandtotal(cart.getGrandtotal() + cartItem.getTotalPrice());
	    	   	 
	    	   	  
	    	   	cartItemService.save(cartItem);
	    	   	System.out.println("hello");
	    	     }else{
	  
	  cartItem.setQuantity(cartItem.getQuantity()+1);
	  cartItem.setTotalPrice(cartItem.getTotalPrice()+product.getPrice());
	 
	  cartItem.getCart().setGrandtotal(cart.getGrandtotal()+product.getPrice());
	  cartItemService.update(cartItem);
	    	     }
	 
	  


	}		
	@RequestMapping("/customer/viewCart")
	public ModelAndView viewCustomerCart( Principal principal)
	{
		Customer customer =  customerService.getcustomerbyname(principal.getName());
		Cart cart =  customer.getCart();
		ModelAndView model = new ModelAndView("viewCart");
		model.addObject("userClickViewCart", true);
		model.addObject("cartId", cart.getId());
		model.addObject("cart", cart);
	    model.addObject("cartItems", cartItemService.list(cart));
		return model;
	
	}
	    	   
	@RequestMapping("/customer/{id}/removeCartItem")
	public String customerRemoveCartItem(@PathVariable Integer id , Principal principal,ModelMap model)
	{
		Customer customer =  customerService.getcustomerbyname(principal.getName());
		Cart cart =  customer.getCart();
		
		CartItem cartItem =  cartItemService.get(id);

		cart.setGrandtotal(cart.getGrandtotal()-cartItem.getTotalPrice());
		cartService.update(cart);
		cartItemService.deletecartitemById(id);
		return "redirect:/customer/viewCart";
	}	   
	 
	@RequestMapping("/customer/checkout")
	public ModelAndView cart( Principal principal)
	{Customer  customer =  customerService.getcustomerbyname(principal.getName());
	Cart cart =  customer.getCart();
	ModelAndView m1=new ModelAndView("viewCart");
	ModelAndView model = new ModelAndView("order");	
		if(cart.getGrandtotal()==0)
	{
			
		//m1.addObject("userClickOrder",true);
	//	m1.addObject("cartId", cart.getId());
	
		return m1;
	}else
			
		model.addObject("userClickOrder", true);
		model.addObject("cartId", cart.getId());
	    model.addObject("cartItems", cartItemService.list(cart));
		return model;
		}
	
	 
	}	