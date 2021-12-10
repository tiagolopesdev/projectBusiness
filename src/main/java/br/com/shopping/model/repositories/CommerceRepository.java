/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.repositories;

import br.com.shopping.model.entities.Commerce;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tiago
 */
@Repository
public interface CommerceRepository extends JpaRepository<Commerce, Integer>{
    
//    @Query("SELECT c FROM Commerce c "
//            + "JOIN c.product p"
//            + "WHERE p.id = :id")
//    public List<Commerce> getAllProductsbyCommerce(Integer id);
}
