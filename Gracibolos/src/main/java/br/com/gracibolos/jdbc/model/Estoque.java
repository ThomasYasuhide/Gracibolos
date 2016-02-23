/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

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
    
    public Estoque(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private Integer qtd;
    private BigDecimal precoUnit;
    private Calendar venc;
    private BigDecimal total;
    private Integer compraId;
    private Integer materiaPrimaId;
    private Integer medidaId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Calendar getVenc() {
		return venc;
	}

	public void setVenc(Calendar venc) {
		this.venc = venc;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getCompraId() {
		return compraId;
	}

	public void setCompraId(Integer compraId) {
		this.compraId = compraId;
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

    
    
    
}
