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
public class Caixa implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9010114990860288031L;

	public Caixa(){
        
    }
       
    private Long id;
    private int gastoRecebimento;
    private Long encomendaId; //encomenda Id ou materia Prima Id
    private Integer fornecedorId;
    private BigDecimal valor; // valor recebido da encomenda, ou valor gasto na compra de materia prima    
    private String forma; // de pagamento
    private Integer parcela;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;
    private String descricao;
    private String nomeRazao;
    
	public String getNomeRazao() {
		return nomeRazao;
	}
	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}
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
	public Long getEncomendaId() {
		return encomendaId;
	}
	public void setEncomendaId(Long encomendaId) {
		this.encomendaId = encomendaId;
	}
	public Integer getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
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
}
