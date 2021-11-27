/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shopping.model.entities;

import lombok.Getter;

/**
 *
 * @author tiago
 */
@Getter
public enum TypeProduct {
    
    ACOUGUE("Açougue"),
    FRIOS_LATICINIOS("Frios e laticinios"),
    BEBIDAS("Bebidas"),
    HIGIENE_LIMPEZA("Higiene e limpeza"),
    MERCEARIA("Mercearia"),
    HORTIFRUTI("Hortifruti");

    private String descricao;

    private TypeProduct(String descricao) {
        this.descricao = descricao;
    }
}
