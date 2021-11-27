/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiago
 */
@Entity
@Getter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    @Setter
    private Date data;

    @Column(nullable = true)
    @Min(1)
    private Integer quantidade;

    @Column(nullable = true)
    @Min(0)
    @Setter
    private Double total;

    @Column(nullable = true)
    @Min(0)
    @Setter
    private Double preco;

    @ManyToMany()
    @JoinTable(name = "request_product",
            joinColumns = @JoinColumn(name = "request_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    referencedColumnName = "codigo"))
    @Setter
    private List<Product> produc = new ArrayList<>();

    public Request() {
    }

    public Request(Date data, Integer quantidade, Double total, Double preco) {
        this.data = data;
        this.quantidade = quantidade;
        this.total = total;
        this.preco = preco;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = produc.size();
    }

}
