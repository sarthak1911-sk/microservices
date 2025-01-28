package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	
	private OrderService oService;
	
	@GetMapping
	public List<Order>getAllOrderDetails()
	{
		return oService.getAllOrderDetails();
	}
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Order order)
	{
		System.out.println(order);
		return oService.placeOrder(order);
	}
	
	@PutMapping("/updateOrder/{id}")
	public Order updateOrder(@PathVariable Integer id,@RequestBody Order order)
	{
		return oService.updateOrder(id, order);
	}
	
	@DeleteMapping("/delOrder/{id}")
	public Boolean deleteOrder(@PathVariable Integer id)
	{
		oService.deleteOrder(id);
		return true;
	}
}