/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.service;

import br.com.shopping.model.entities.Product;
import br.com.shopping.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public Product save(Product p) {
        return productRepository.save(p);
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
