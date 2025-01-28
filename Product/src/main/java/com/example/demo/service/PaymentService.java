package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	
	private PaymentRepository pRepo;
	
	
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}

	public Payment getPaymentDetails(Integer id)
	{
		Optional<Payment> p = pRepo.findById(id);
		return p.get();
	}
	
	public Payment doPayment(Payment p) {
		// TODO Auto-generated method stub
		p.setPaymentStatus(paymentProcessing());
		p.setTransactionId(UUID.randomUUID().toString());
		
		return pRepo.save(p);
	}

	public Payment updatePayment(Integer id, Payment payment) {
		// TODO Auto-generated method stub
		Payment p = getPaymentDetails(id);
		return p;
	}

	public void deletePayment(Integer id) {
		// TODO Auto-generated method stub
		pRepo.deleteById(id);
	}
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"success":"false";
	}

}