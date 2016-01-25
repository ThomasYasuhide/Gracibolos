/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author d637942
 */
public class ItemEncomenda implements Serializable{
    
    public ItemEncomenda(){
        
    }
    
    public ItemEncomenda(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private BigDecimal qtd;
    private Produto produtoId;
    private Encomenda encomendaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Encomenda getEncomendaId() {
        return encomendaId;
    }

    public void setEncomendaId(Encomenda encomendaId) {
        this.encomendaId = encomendaId;
    }
    
    
    
}
