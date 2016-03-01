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
public class Conta implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2779691061004133271L;

	public Conta(){
        
    }
    
    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, LocalDate dataVencimento) {
        this.id = id;
        this.dataVencimento = dataVencimento;
    }
    
    private Integer id;
    private Integer fornecedorId;
    private Integer colaboradorId;
    private Integer caixaId;
    private String codigo;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataVencimento;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataPagamento;
    private BigDecimal valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public Integer getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Integer colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public Integer getCaixaId() {
		return caixaId;
	}

	public void setCaixaId(Integer caixaId) {
		this.caixaId = caixaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
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
