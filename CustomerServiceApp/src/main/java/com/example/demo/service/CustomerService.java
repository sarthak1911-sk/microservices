package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	public List<Customer> getAllCustomerDetails()
	{
		return custRepo.findAll();
	}
	public Customer saveCustomer(Customer c) 
	{
		custRepo.save(c);
		return c;
	}
	public Customer updateCustomer(Integer id,Customer c)
	{
		Customer c1=getCustomerDetails(id);
		c1.setCName(c.getCName());
		c=custRepo.save(c1);
		return c;
	}
	
	public Customer getCustomerDetails(Integer id)
	{
		Optional<Customer> obj=custRepo.findById(id);
		Customer c=obj.get();
		return c;
	}
	public Customer deleteCustomer(Integer id)
	{
		Customer c=getCustomerDetails(id);
		custRepo.deleteById(id);
		return c;
	}
}