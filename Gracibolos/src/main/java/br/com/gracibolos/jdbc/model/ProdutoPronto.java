/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author d637942
 */
public class ProdutoPronto implements Serializable{
    
    public ProdutoPronto(){
        
    }
    
    public ProdutoPronto(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private Calendar finalizado;
    private Calendar dataValidade;
    private String codigo;
    private Encomenda encomendaId;
    private Produto produtoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Calendar finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Encomenda getEncomendaId() {
        return encomendaId;
    }

    public void setEncomendaId(Encomenda encomendaId) {
        this.encomendaId = encomendaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }
    
    
    
}
