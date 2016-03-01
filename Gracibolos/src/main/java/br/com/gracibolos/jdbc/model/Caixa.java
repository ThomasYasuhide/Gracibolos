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
public class Caixa implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9010114990860288031L;

	public Caixa(){
        
    }
    
    public Caixa(Long id) {
        this.id = id;
    }

    public Caixa(Long id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }
    
    private Long id;
    private Integer encomendaId;
    private BigDecimal valor;
    private Boolean gasto;
    private Boolean recebimento;
    private String forma;
    private String descricao;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEncomendaId() {
		return encomendaId;
	}

	public void setEncomendaId(Integer encomendaId) {
		this.encomendaId = encomendaId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getGasto() {
		return gasto;
	}

	public void setGasto(Boolean gasto) {
		this.gasto = gasto;
	}

	public Boolean getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Boolean recebimento) {
		this.recebimento = recebimento;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
