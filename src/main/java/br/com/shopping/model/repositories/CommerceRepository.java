/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.repositories;

import br.com.shopping.model.entities.Commerce;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tiago
 */
public interface CommerceRepository extends CrudRepository<Commerce, Integer>{
    
}
