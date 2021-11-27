/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiago
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("commerce")
@Getter
@Setter
public class Commerce extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    //@NotNull(message = "Cnpj vazio")
    private String cnpj;

    @Column(nullable = false)
    //@NotBlank(message = "Nome do comercio vazio ou nulo")
    private String nome;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "commerce_product", joinColumns
            = @JoinColumn(name = "id_commerce",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product",
                    referencedColumnName = "codigo")
    )
    private List<Product> product = new ArrayList<>();

    public Commerce() {
    }

    public Commerce(String cnpj, String nome, String rua, Integer numero, String bairro, String cidade) {
        super(rua, numero, bairro, cidade);
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public void AddProduct(Product p) {
        if (p != null && !getProduct().contains(p)) {
            getProduct().add(p);
            if (!p.getCommerce().contains(p)) {
                p.getCommerce().add(this);
            }
        }
    }
}
