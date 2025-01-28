package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor

public class Orders {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Integer oid;
@Column
private String name;
@Column
private Integer quantity;
@Column
private Double price;
}
