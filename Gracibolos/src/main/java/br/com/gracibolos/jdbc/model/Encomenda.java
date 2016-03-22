package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Encomenda implements Serializable{
    
	private static final long serialVersionUID = -2187641155037646683L;
	
    private Long id;
    private Integer cliente;
    private Integer status;
    private String responsavel;
    
    
    
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataInicio;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataFaltaProd;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataProducao;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataFinalizado;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataEntrega;
    
    private Boolean entregaRetirada;
    private BigDecimal total;
    private String descricao;
    private Integer numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFaltaProd() {
		return dataFaltaProd;
	}

	public void setDataFaltaProd(LocalDate dataFaltaProd) {
		this.dataFaltaProd = dataFaltaProd;
	}

	public LocalDate getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(LocalDate dataProducao) {
		this.dataProducao = dataProducao;
	}

	public LocalDate getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(LocalDate dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
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
	
}
