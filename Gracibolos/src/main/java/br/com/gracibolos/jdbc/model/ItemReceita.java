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
public class ItemReceita implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2904965076978362910L;

	public ItemReceita(){
        
    }
    
    public ItemReceita(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private BigDecimal qtd;
    private BigDecimal total;
    private Integer medidaId;
    private Integer materiaPrimaId;
    private Integer produtoId;
    
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Integer medidaId) {
		this.medidaId = medidaId;
	}

	public Integer getMateriaPrimaId() {
		return materiaPrimaId;
	}

	public void setMateriaPrimaId(Integer materiaPrimaId) {
		this.materiaPrimaId = materiaPrimaId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}


    
    
}
