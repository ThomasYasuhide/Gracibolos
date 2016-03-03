/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author d637942
 */
public class ProdutoPronto implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4235054391330860543L;

	public ProdutoPronto(){
        
    }
    
    public ProdutoPronto(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer produtoId;
    private Integer encomendaId;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate finalizado;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataValidade;
    private String codigo;

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

	public LocalDate getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(LocalDate finalizado) {
		this.finalizado = finalizado;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}    
    
}
