package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="tbl_order")
public class Order {
	@Id
	@Column(insertable=true)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer oid;
	
	@Column(name="oname")
	private String name;
	
	@Column
	private Integer qty;
	
	@Column
	private Double price;
}