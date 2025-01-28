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

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    PaymentService ps;
    
    @GetMapping("/payment")
	public List<Payment>getAllPaymentDetails()
	{
		List<Payment>plist=ps.getAllPaymentDetails();
				System.out.println(plist);
		return plist;
	}
    @GetMapping("/payment/{id}")
	public Payment getPaymentDetails(@PathVariable Integer id)
	{
		Payment p=ps.getPaymentDetails(id);
		return p;
	}
    
    @PutMapping("/payment/update/{id}")
    public Payment updatePayment(@PathVariable Integer id,@RequestBody  Payment p)
    {
    	return ps.updatePayment(id,p);
    	
    }
    
    @PostMapping("/payment/add")
    public Payment savePayment(@RequestBody  Payment p)
    {
    		ps.savePayment(p);
    	return p;
    }
    
@DeleteMapping("/payment/delete/{id}")
public Payment deletePayment(@PathVariable Integer id)
{
	return ps.deletePayment(id);
}

}
