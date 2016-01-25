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
public class ItemReceita implements Serializable {
    
    public ItemReceita(){
        
    }
    
    public ItemReceita(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private BigDecimal qtd;
    private BigDecimal total;
    private Medida medidaId;
    private MateriaPrima materiaPrimaId;
    private Produto produtoId;

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Medida getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(Medida medidaId) {
        this.medidaId = medidaId;
    }

    public MateriaPrima getMateriaPrimaId() {
        return materiaPrimaId;
    }

    public void setMateriaPrimaId(MateriaPrima materiaPrimaId) {
        this.materiaPrimaId = materiaPrimaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }
    
    
    
}
