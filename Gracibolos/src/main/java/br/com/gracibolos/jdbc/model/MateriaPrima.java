/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author d637942
 */
public class MateriaPrima implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8191626366030745848L;

	public MateriaPrima(){
        
    }
    
    public MateriaPrima(Long id) {
        this.id = id;
    }
    
    private Long id;
    private String nome;
    private Double estoque;
    private Double peso;
    private Long unidade; 
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fabricacao;
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate vencimento;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Long getUnidade() {
		return unidade;
	}

	public void setUnidade(Long unidade) {
		this.unidade = unidade;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
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