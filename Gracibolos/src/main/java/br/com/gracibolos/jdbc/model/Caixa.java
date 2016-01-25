/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author d637942
 */
public class Caixa implements Serializable{
    
    public Caixa(){
        
    }
    
    public Caixa(Integer id) {
        this.id = id;
    }

    public Caixa(Integer id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }
    
    private Integer id;
    private BigDecimal valor;
    private Boolean gasto;
    private Boolean recebimento;
    private String forma;
    private String descricao;
    private Collection<Conta> contaCollection;
    private Encomenda encomendaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Collection<Conta> getContaCollection() {
        return contaCollection;
    }

    public void setContaCollection(Collection<Conta> contaCollection) {
        this.contaCollection = contaCollection;
    }

    public Encomenda getEncomendaId() {
        return encomendaId;
    }

    public void setEncomendaId(Encomenda encomendaId) {
        this.encomendaId = encomendaId;
    }
    
    

}
