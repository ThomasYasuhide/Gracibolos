/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author d637942
 */
public class TipoProduto implements Serializable{
    
    public TipoProduto(){
        
    }
    
    public TipoProduto(String nome) {
        this.nome = nome;
    }
    
    private String nome;
    private Collection<Produto> produtoCollection;
    
}
