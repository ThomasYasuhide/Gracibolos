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
public class Produto implements Serializable{
    
    public Produto(){
        
    }
    
    public Produto(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private String nome;
    private BigDecimal valor;
    private String receita;
    private byte[] foto;
    private Collection<ProdutoPronto> produtoprontoCollection;
    private Collection<ItemEncomenda> itemencomendaCollection;
    private TipoProduto tipoProdutoNome;
    private Collection<ItemReceita> itemreceitaCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Collection<ProdutoPronto> getProdutoprontoCollection() {
        return produtoprontoCollection;
    }

    public void setProdutoprontoCollection(Collection<ProdutoPronto> produtoprontoCollection) {
        this.produtoprontoCollection = produtoprontoCollection;
    }

    public Collection<ItemEncomenda> getItemencomendaCollection() {
        return itemencomendaCollection;
    }

    public void setItemencomendaCollection(Collection<ItemEncomenda> itemencomendaCollection) {
        this.itemencomendaCollection = itemencomendaCollection;
    }

    public TipoProduto getTipoProdutoNome() {
        return tipoProdutoNome;
    }

    public void setTipoProdutoNome(TipoProduto tipoProdutoNome) {
        this.tipoProdutoNome = tipoProdutoNome;
    }

    public Collection<ItemReceita> getItemreceitaCollection() {
        return itemreceitaCollection;
    }

    public void setItemreceitaCollection(Collection<ItemReceita> itemreceitaCollection) {
        this.itemreceitaCollection = itemreceitaCollection;
    }
    
    
    
}
