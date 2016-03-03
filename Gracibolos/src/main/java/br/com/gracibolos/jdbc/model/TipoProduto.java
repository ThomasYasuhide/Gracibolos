/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;

/**
 *
 * @author d637942
 */
public class TipoProduto implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5769500126286990226L;

	public TipoProduto(){
        
    }
    
    public TipoProduto(Long id) {
        this.id = id;
    }
    
    private Long id;
    private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
