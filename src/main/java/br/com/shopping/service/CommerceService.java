/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.service;

import br.com.shopping.model.entities.Commerce;
import br.com.shopping.model.repositories.CommerceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiago
 */
@Service
public class CommerceService {
    
    @Autowired
    private CommerceRepository commerceRepository;
    
    public Commerce getCommerceById(int id){
        return commerceRepository.findById(id).get();
    }
    
    public Iterable<Commerce> getAllCommerces(){
        return commerceRepository.findAll();
    }
    
//    public List<Commerce> getAllProductsByCommerce(Integer id){
//        return commerceRepository.getAllProductsbyCommerce(id);
//    }
//    
}
