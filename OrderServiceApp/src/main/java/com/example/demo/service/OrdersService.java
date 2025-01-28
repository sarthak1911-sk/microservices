package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;

import com.example.demo.repository.OrdersRepository;
@Service
public class OrdersService {
@Autowired
OrdersRepository ordRepo;
	public List<Orders> getAllOrdersDetails() {
		// TODO Auto-generated method stub
		
		return ordRepo.findAll();
	}

	public Orders updateOrders(Integer id, Orders o) {
		// TODO Auto-generated method stub
		Orders o1=getOrdersDetails(id);
		o1.setName(o.getName());
		o=ordRepo.save(o1);
		return o;
		
	}

	public Orders saveOrders(Orders o) {
		// TODO Auto-generated method stub
		ordRepo.save(o);
		return o;
	}

	public Orders deleteOrders(Integer id) {
		// TODO Auto-generated method stub
		Orders o=getOrdersDetails(id);
		ordRepo.deleteById(id);
		return o;
	}

	public Orders getOrdersDetails(Integer id) {
		// TODO Auto-generated method stub
		Optional<Orders> obj=ordRepo.findById(id);
		Orders o=obj.get();
		return o;
	}

}
