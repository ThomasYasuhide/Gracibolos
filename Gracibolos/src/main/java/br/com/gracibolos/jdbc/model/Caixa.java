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

    public Caixa(Long id, BigDecimal recebidoGasto) {
        this.id = id;
        this.recebidoGasto = recebidoGasto;
    }
    
    private Long id; 
    private Integer tipoId; //encomenda Id ou materia Prima Id
    private Integer numeroId;
    private BigDecimal recebidoGasto; // valor recebido da encomenda, ou valor gasto na compra de materia prima
    private String forma; // de pagamento
    private Integer parcela;
    private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public Integer getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Integer numeroId) {
		this.numeroId = numeroId;
	}

	public BigDecimal getRecebidoGasto() {
		return recebidoGasto;
	}

	public void setRecebidoGasto(BigDecimal recebidoGasto) {
		this.recebidoGasto = recebidoGasto;
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
