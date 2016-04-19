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
    private LocalDate dataentrega;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataencomenda;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datafaturamento;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataproducao;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datafinalizado;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datacancelamento;
    private BigDecimal totalprodutos;
    private String obs;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCliente() {
		return cliente;
	}
	
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public LocalDate getDataencomenda() {
		return dataencomenda;
	}
	
	public void setDataencomenda(LocalDate dataencomenda) {
		this.dataencomenda = dataencomenda;
	}
	
	public LocalDate getDataentrega() {
		return dataentrega;
	}
	
	public void setDataentrega(LocalDate dataentrega) {
		this.dataentrega = dataentrega;
	}
	
	public LocalDate getDatafaturamento() {
		return datafaturamento;
	}
	
	public void setDatafaturamento(LocalDate datafaturamento) {
		this.datafaturamento = datafaturamento;
	}
	
	public LocalDate getDataproducao() {
		return dataproducao;
	}
	
	public void setDataproducao(LocalDate dataproducao) {
		this.dataproducao = dataproducao;
	}
	
	public LocalDate getDatafinalizado() {
		return datafinalizado;
	}
	
	public void setDatafinalizado(LocalDate datafinalizado) {
		this.datafinalizado = datafinalizado;
	}
	
	public LocalDate getDatacancelamento() {
		return datacancelamento;
	}

	public void setDatacancelamento(LocalDate datacancelamento) {
		this.datacancelamento = datacancelamento;
	}

	public BigDecimal getTotalprodutos() {
		return totalprodutos;
	}

	public void setTotalprodutos(BigDecimal totalprodutos) {
		this.totalprodutos = totalprodutos;
	}

	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
