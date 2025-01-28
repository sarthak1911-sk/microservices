package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.common.Payment;
import com.example.demo.common.TxResponse;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository oRepo;
	
	@Autowired
	private WebClient Builder webClientBuilder;
	
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return oRepo.findAll();
	}

	
	
	
	
	
	public Order getOrderDetails(Integer id)
	{
		Optional<Order> o = oRepo.findById(id);
		return o.get();
	}
	public TxResponse placeOrder(Order order) {
		// TODO Auto-generated method stub
		
		Payment payReq =new Payment();
		payReq.setOrderId(order.getOid());
		payReq.setAmt(order.getPrice()*order.getQty());
		
		
		 oRepo.save(order);
		TxResponse txRes = new TxResponse();
		return txRes;
	}

	public Order updateOrder(Integer id, Order order) {
		// TODO Auto-generated method stub
		Order o = getOrderDetails(id);
		return o;
	}

	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		oRepo.deleteById(id);
		
	}

}