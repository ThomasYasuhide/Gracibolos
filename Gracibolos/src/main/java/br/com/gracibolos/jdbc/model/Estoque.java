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

    public Estoque() {
        
    }
    
    public Estoque(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private BigDecimal qtd;
    private BigDecimal precoUnit;
    private Calendar venc;
    private BigDecimal total;
    private Compra compraId;
    private MateriaPrima materiaPrimaId;
    private Medida medidaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
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

    public Compra getCompraId() {
        return compraId;
    }

    public void setCompraId(Compra compraId) {
        this.compraId = compraId;
    }

    public MateriaPrima getMateriaPrimaId() {
        return materiaPrimaId;
    }

    public void setMateriaPrimaId(MateriaPrima materiaPrimaId) {
        this.materiaPrimaId = materiaPrimaId;
    }

    public Medida getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(Medida medidaId) {
        this.medidaId = medidaId;
    } 
    
    
    
}
