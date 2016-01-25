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
public class Status implements Serializable{
    
    public Status(){
        
    }
    
    public Status(String nome) {
        this.nome = nome;
    }
    
    private String nome;
    private Collection<Compra> compraCollection;
    private Collection<Encomenda> encomendaCollection;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Collection<Encomenda> getEncomendaCollection() {
        return encomendaCollection;
    }

    public void setEncomendaCollection(Collection<Encomenda> encomendaCollection) {
        this.encomendaCollection = encomendaCollection;
    }  
        
}
