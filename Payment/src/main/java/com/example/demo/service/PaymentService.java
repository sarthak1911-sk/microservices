package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;



@Service
public class PaymentService {
	@Autowired
	PaymentRepository paytRepo;
	public List<Payment> getAllPaymentDetails()
	{
		return paytRepo.findAll();
	}
	public Payment savePayment(Payment p) 
	{
		paytRepo.save(p);
		return p;
	}
	public Payment getPaymentDetails(Integer id)
	{
		Optional<Payment> obj=paytRepo.findById(id);
		Payment p=obj.get();
		return p;
	}
	public Payment deletePayment(Integer id)
	{
		Payment c=getPaymentDetails(id);
		paytRepo.deleteById(id);
		return c;
}
	public Payment updatePayment(Integer id, Payment p) {
		Payment p1=getPaymentDetails(id);
		p1.setPstatus(p.getPstatus());
		p=paytRepo.save(p1);
		return p;
		
	}
}
