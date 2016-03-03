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
public class Suporte implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1319997313642607861L;



	public Suporte(){
        
    }
    
    public Suporte(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer fornecedorId;
    private Integer encomendaId;
    private String codigo;
    private String status;
    private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public Integer getEncomendaId() {
		return encomendaId;
	}

	public void setEncomendaId(Integer encomendaId) {
		this.encomendaId = encomendaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}    

}
