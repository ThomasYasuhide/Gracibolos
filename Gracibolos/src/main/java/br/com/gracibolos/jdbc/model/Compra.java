/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author d637942
 */
public class Compra implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4217638610804900594L;

	public Compra (){
        
    }
    
    public Compra(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer fornecedorId;
    private String statusNome;
    private String tipo;
    private String numero;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;
    private BigDecimal total;

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

	public String getStatusNome() {
		return statusNome;
	}

	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
