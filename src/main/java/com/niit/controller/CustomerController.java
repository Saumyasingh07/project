package com.niit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Customer;
import com.niit.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
private CustomerService customerService;
@RequestMapping("/all/registrationform")
public String getRegistrationForm(Model model){
	model.addAttribute("customer",new Customer());
	return "registrationpage";
}
@RequestMapping("all/register")
public String registerCustomer(@Valid @ModelAttribute(name="customer") Customer customer,BindingResult result,Model model){
	if(result.hasErrors())
		return "registrationpage"; //nonempty values..
	List<Customer> customers= customerService.getCustomers();
	String username=customer.getUsers().getUsername();
	String email=customer.getEmail();
	for(Customer c:customers){
		//  data in users table               input
	   if(c.getUsers().getUsername().equals(username))
	   {
		   model.addAttribute("duplicateUsername","Username already exists");
		   return "registrationpage";
	   }
	}
	for(Customer c:customers){
		   if(c.getEmail().equals(email))
		   {
			   model.addAttribute("duplicateEmail","EmailId already exists");
			   return "registrationpage";
		   }
		}
	customerService.saveCustomer(customer);
	
	return "login";
}
}
