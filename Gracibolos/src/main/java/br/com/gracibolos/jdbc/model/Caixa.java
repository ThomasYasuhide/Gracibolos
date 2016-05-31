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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 *
 * @author d637942
 */
@JsonInclude(Include.NON_NULL)
public class Caixa implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9010114990860288031L;

	public Caixa(){
        
    }
       
    private Long id;
    private int gastoRecebimento;
    private Integer fornecedorId;
    private Long encomendaId; //encomenda Id ou materia Prima Id
    private BigDecimal valor; // valor recebido da encomenda, ou valor gasto na compra de materia prima    
    private BigDecimal saldo;
    private String forma; // de pagamento
    private Integer parcela;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataTransacao;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataOperacao;
    private String descricao;
    private Long fornecedorIdFornecedor;
    private String nomerazao;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getGastoRecebimento() {
		return gastoRecebimento;
	}
	public void setGastoRecebimento(int gastoRecebimento) {
		this.gastoRecebimento = gastoRecebimento;
	}
	public Integer getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public Long getEncomendaId() {
		return encomendaId;
	}
	public void setEncomendaId(Long encomendaId) {
		this.encomendaId = encomendaId;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	public Integer getParcela() {
		return parcela;
	}
	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}
	public LocalDate getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public LocalDate getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFornecedorIdFornecedor() {
		return fornecedorIdFornecedor;
	}
	public void setFornecedorIdFornecedor(Long fornecedorIdFornecedor) {
		this.fornecedorIdFornecedor = fornecedorIdFornecedor;
	}
	public String getNomerazao() {
		return nomerazao;
	}
	public void setNomerazao(String nomerazao) {
		this.nomerazao = nomerazao;
	}
	
}
