package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@GetMapping("/customers")
	public List<Customer>getAllCustomerDetails()
	{
		List<Customer>clist=cs.getAllCustomerDetails();
				System.out.println(clist);
		return clist;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerDetails(@PathVariable Integer id)
	{
		Customer c=cs.getCustomerDetails(id);
		return c;
	}

	
@PostMapping("/customers/add")
public Customer saveCustomer(@RequestBody  Customer c)
{
		cs.saveCustomer(c);
	return c;
}

@PutMapping("/customers/update/{id}")
public Customer updateCustomer(@PathVariable Integer id,@RequestBody  Customer c)
{
	return cs.updateCustomer(id,c);
	
}

@DeleteMapping("/customers/delete/{id}")
public Customer deleteCustomer(@PathVariable Integer id)
{
	return cs.deleteCustomer(id);
}



}
