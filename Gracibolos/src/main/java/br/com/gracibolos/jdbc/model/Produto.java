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

public class Produto implements Serializable{
    
	private static final long serialVersionUID = 8787266867192367340L;

    private Long id;
    private byte[] foto;
    private Integer status;
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate fabricacao;
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate vencimento;
    private String codigo;
    private String nome;
    private Long tipo;
    private Double peso;
    private Long unidade;
    private int estoque;
    private BigDecimal custo;
    private BigDecimal valor;
    private String obs;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
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
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getTipo() {
		return tipo;
	}
	
	public void setTipo(Long tipo) {
		this.tipo = tipo;
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
	
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public BigDecimal getCusto() {
		return custo;
	}
	
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
    
}
