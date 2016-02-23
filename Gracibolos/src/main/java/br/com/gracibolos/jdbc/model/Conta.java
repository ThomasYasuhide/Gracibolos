/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

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

    public Conta(Integer id, Calendar dataVencimento) {
        this.id = id;
        this.dataVencimento = dataVencimento;
    }
    
    private Integer id;
    private String codigo;
    private Calendar dataVencimento;
    private Calendar dataPagamento;
    private BigDecimal valor;
    private Integer caixaId;
    private Integer fornecedorId;
    private Integer colaboradorId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getCaixaId() {
		return caixaId;
	}

	public void setCaixaId(Integer caixaId) {
		this.caixaId = caixaId;
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

 
    
}
