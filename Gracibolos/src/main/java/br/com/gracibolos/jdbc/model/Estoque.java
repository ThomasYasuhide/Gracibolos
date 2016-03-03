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
public class Estoque implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8635541850180640498L;

	public Estoque() {
        
    }
    
    public Estoque(Long id) {
        this.id = id;
    }
    
    private Long id;
    private Integer materiaPrimaId;
    private Integer medidaId;
    private Integer compraId;
    private Integer qtd;
    private BigDecimal precoUnit;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate venc;
    private BigDecimal total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMateriaPrimaId() {
		return materiaPrimaId;
	}

	public void setMateriaPrimaId(Integer materiaPrimaId) {
		this.materiaPrimaId = materiaPrimaId;
	}

	public Integer getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Integer medidaId) {
		this.medidaId = medidaId;
	}

	public Integer getCompraId() {
		return compraId;
	}

	public void setCompraId(Integer compraId) {
		this.compraId = compraId;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(BigDecimal precoUnit) {
		this.precoUnit = precoUnit;
	}

	public LocalDate getVenc() {
		return venc;
	}

	public void setVenc(LocalDate venc) {
		this.venc = venc;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
