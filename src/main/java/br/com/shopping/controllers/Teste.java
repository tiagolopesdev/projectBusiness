/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tiago
 */
@RestController
@RequestMapping(path = "/ola")
public class Teste {
    
    public String ola(){
        return "olá moço quieeeta!!";
    }
}
