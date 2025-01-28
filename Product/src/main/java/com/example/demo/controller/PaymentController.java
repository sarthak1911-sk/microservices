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

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService pService;
	
	
	@GetMapping
	public List<Payment>getAllPaymentDetails()
	{
		return pService.getAllPaymentDetails();
	}
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment p)
	{
		return pService.doPayment(p);
	}
	
	@PutMapping("/updatePayment/{id}")
	public Payment updatePayment(@PathVariable Integer id,@RequestBody Payment Payment)
	{
		return pService.updatePayment(id, Payment);
	}
	
	@DeleteMapping("/delPayment/{id}")
	public Boolean deletePayment(@PathVariable Integer id)
	{
		pService.deletePayment(id);
		return true;
	}

}