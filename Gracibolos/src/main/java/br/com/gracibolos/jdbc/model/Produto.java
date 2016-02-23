/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author d637942
 */
public class Produto implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8787266867192367340L;

	public Produto(){
        
    }
    
    public Produto(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private String tipoProdutoNome;
    private String nome;
    private BigDecimal valor;
    private String receita;
    private byte[] foto;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoProdutoNome() {
		return tipoProdutoNome;
	}

	public void setTipoProdutoNome(String tipoProdutoNome) {
		this.tipoProdutoNome = tipoProdutoNome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getReceita() {
		return receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}      
    
}
