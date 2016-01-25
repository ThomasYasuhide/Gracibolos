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
public class MateriaPrima implements Serializable{
    
    public MateriaPrima(){
        
    }
    
    public MateriaPrima(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private String marca;
    private String tipo;
    private BigDecimal qtd;
    private String descricao;
    private byte[] foto;
    private Collection<Estoque> estoqueCollection;
    private Collection<ItemReceita> itemreceitaCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Collection<Estoque> getEstoqueCollection() {
        return estoqueCollection;
    }

    public void setEstoqueCollection(Collection<Estoque> estoqueCollection) {
        this.estoqueCollection = estoqueCollection;
    }

    public Collection<ItemReceita> getItemreceitaCollection() {
        return itemreceitaCollection;
    }

    public void setItemreceitaCollection(Collection<ItemReceita> itemreceitaCollection) {
        this.itemreceitaCollection = itemreceitaCollection;
    }
    
    
    
}
