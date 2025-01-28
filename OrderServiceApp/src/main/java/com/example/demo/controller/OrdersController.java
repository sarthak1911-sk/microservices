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

import com.example.demo.model.Orders;

import com.example.demo.service.OrdersService;




@RestController
public class OrdersController {
	 @Autowired
	 
	    OrdersService os;
	    
	    @GetMapping("/orders")
		public List<Orders>getAllOrdersDetails()
		{
			List<Orders>olist=os.getAllOrdersDetails();
					System.out.println(olist);
			return olist;
		}
	    
	    @PutMapping("/orders/update/{id}")
	    public Orders updateOrders(@PathVariable Integer id,@RequestBody  Orders o)
	    {
	    	return os.updateOrders(id,o);
	    	
	    }
	    
	    @GetMapping("/orders/{id}")
		public Orders getOrdersDetails(@PathVariable Integer id)
		{
			Orders o=os.getOrdersDetails(id);
			return o;
		}
	    
	    @PostMapping("/orders/add")
	    public Orders saveOrders(@RequestBody  Orders o)
	    {
	    		os.saveOrders(o);
	    	return o;
	    }
	    
	    @DeleteMapping("/orders/delete/{id}")
	    public Orders deleteOrders(@PathVariable Integer id)
	    {
	    	return os.deleteOrders(id);
	    }
}
