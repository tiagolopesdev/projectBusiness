/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.controllers;

import br.com.shopping.model.entities.Address;
import br.com.shopping.model.entities.Commerce;
import br.com.shopping.model.entities.Product;
import br.com.shopping.model.repositories.CommerceRepository;
import br.com.shopping.model.repositories.ProductRepository;
import br.com.shopping.service.CommerceService;
import br.com.shopping.service.ProductService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    private CommerceRepository commerceRepository;

    @Autowired
    private CommerceService commerceService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/formCommerce")
    public String getFormCommerce() {
        return "formCommerce";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCommerce(Commerce c, Errors errors) {
        if (errors.hasErrors()) {
            return "formCommerce";
        }
        commerceRepository.save(c);
        return "formCommerce";
    }

    @GetMapping
    public ModelAndView searchCommerces() {
        List<Commerce> allCommerces = (List<Commerce>) commerceRepository.findAll();
        ModelAndView mav = new ModelAndView("getCommerces");
        mav.addObject("commerces", allCommerces);
        return mav;
    }

//    @PostMapping
//    public Commerce newCommerce(@Valid Commerce c){
//        commerceRepository.save(c);
//        return c;
//    }  
//    @GetMapping
//    public Iterable<Commerce> getCommerces(){
//        return commerceRepository.findAll();
//    }
//    
//    @GetMapping("/{id}")
//    public Optional<Commerce> getCommercesForId(@PathVariable int id){
//        return commerceRepository.findById(id);
//    }
//    
//    @DeleteMapping("/{id}")
//    public void deleteCommerce(@PathVariable int id) {
//        commerceRepository.deleteById(id);
//    }
}
