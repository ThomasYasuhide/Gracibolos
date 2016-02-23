/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;

/**
 *
 * @author d637942
 */
public class ItemEncomenda implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5136026907602113969L;

	public ItemEncomenda(){
        
    }
    
    public ItemEncomenda(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private Integer qtd;
    private Integer produtoId;
    private Integer encomendaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getEncomendaId() {
		return encomendaId;
	}

	public void setEncomendaId(Integer encomendaId) {
		this.encomendaId = encomendaId;
	}    
    
}
