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
public class Encomenda implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2187641155037646683L;

	public Encomenda(){
        
    }
    
    public Encomenda(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private Integer clienteId;
    private String responsavel;
    private Calendar dataInicio;
    private Calendar dataFaltaProd;
    private Calendar dataProducao;
    private Calendar dataFinalizado;
    private Calendar dataEntrega;
    private Boolean entregaRetirada;
    private BigDecimal total;
    private String descricao;
    private Integer numero;
    
    private String statusNome;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFaltaProd() {
		return dataFaltaProd;
	}

	public void setDataFaltaProd(Calendar dataFaltaProd) {
		this.dataFaltaProd = dataFaltaProd;
	}

	public Calendar getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(Calendar dataProducao) {
		this.dataProducao = dataProducao;
	}

	public Calendar getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(Calendar dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getEntregaRetirada() {
		return entregaRetirada;
	}

	public void setEntregaRetirada(Boolean entregaRetirada) {
		this.entregaRetirada = entregaRetirada;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getStatusNome() {
		return statusNome;
	}

	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
	}

}
