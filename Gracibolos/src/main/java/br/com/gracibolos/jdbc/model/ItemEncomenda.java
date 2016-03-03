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
    
    public ItemEncomenda(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer produtoId;
    private Integer encomendaId;
    private Integer qtd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
