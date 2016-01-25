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
public class Suporte implements Serializable{
    
    public Suporte(){
        
    }
    
    public Suporte(String id) {
        this.id = id;
    }
    
     private String id;
    private String codigo;
    private String status;
    private BigDecimal valor;
    private Encomenda encomendaId;
    private Fornecedor fornecedorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Encomenda getEncomendaId() {
        return encomendaId;
    }

    public void setEncomendaId(Encomenda encomendaId) {
        this.encomendaId = encomendaId;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    
    
    
}
