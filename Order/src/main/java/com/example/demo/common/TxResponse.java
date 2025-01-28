package com.example.demo.common;

import com.example.demo.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TxResponse {
private Order order;
private Double amount;
private String transactionId;
private String status;
}
