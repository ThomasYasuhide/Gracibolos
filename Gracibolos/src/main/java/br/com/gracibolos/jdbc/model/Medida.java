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
public class Medida implements Serializable{
    
    public Medida(){
        
    }
    
    public Medida(Integer id) {
        this.id = id;
    }

    public Medida(Integer id, String medida) {
        this.id = id;
        this.medida = medida;
    }
    
    private Integer id;
    private String ingrediente;
    private String medida;
    private BigDecimal gramas;
    private BigDecimal litros;
    private Collection<Estoque> estoqueCollection;
    private Collection<ItemReceita> itemreceitaCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getGramas() {
        return gramas;
    }

    public void setGramas(BigDecimal gramas) {
        this.gramas = gramas;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
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
