/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemEncomenda implements Serializable{
    
	private static final long serialVersionUID = -5136026907602113969L;

    private Long id;
    private int numero;
    private Long produtoId;
    private Long encomendaId;
    private Integer quantidade;
    private BigDecimal valor;
    private BigDecimal total;
    private String nomeProduto;
    private Long produtoIdProduto;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Long getEncomendaId() {
		return encomendaId;
	}

	public void setEncomendaId(Long encomendaId) {
		this.encomendaId = encomendaId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getProdutoIdProduto() {
		return produtoIdProduto;
	}

	public void setProdutoIdProduto(Long produtoIdProduto) {
		this.produtoIdProduto = produtoIdProduto;
	}
	
	
}
