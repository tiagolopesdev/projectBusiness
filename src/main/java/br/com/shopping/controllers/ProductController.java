/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.controllers;

import br.com.shopping.model.entities.Commerce;
import br.com.shopping.model.entities.Product;
import br.com.shopping.model.repositories.ProductRepository;
import br.com.shopping.service.CommerceService;
import br.com.shopping.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tiago
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommerceService commerceService;
    
    Commerce c = new Commerce();

    @RequestMapping(value = "/formProduct/{id}")
    public String getForm(@PathVariable(name = "id") Integer id) {
        c.setProduct((List<Product>) commerceService.getCommerceById(id));
//        ModelAndView andView = new ModelAndView("formProduct");
//        andView.addObject("getCommerce", c.getNome());
        return "formProduct";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(Product p) {
        productService.save(p);
        c.getProduct().add(p);
        return "formProduct";
    }
    
//    @GetMapping
//    public ModelAndView searchCommerces() {
//        List<Commerce> allCommerces = (List<Commerce>) commerceRepository.findAll();
//        ModelAndView mav = new ModelAndView("getCommerces");
//        mav.addObject("commerces", allCommerces);
//        return mav;
//    }
}