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
    
    public ItemReceita(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer materiaPrimaId;
    private Integer produtoId;
    private Integer medidaId;
    private Integer qtd;
    private BigDecimal total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Integer medidaId) {
		this.medidaId = medidaId;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
