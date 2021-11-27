/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiago
 */
@Entity
@Getter
@Setter
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = true)
    private String nome;
    
    @Column(nullable = true)
    private Double preco;
    
    @Column(nullable = true)
    @Min(0)
    @Max(1)
    private Double desconto;
    
    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private TypeProduct tp;
    
    @ManyToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Commerce> commerce = new ArrayList<>();

    public Product() {
    }

    public Product(String nome, Double preco, Double desconto, TypeProduct tp, 
            Commerce commerce) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
        this.tp = tp;
        this.commerce = (List<Commerce>) commerce;
    }   
}
