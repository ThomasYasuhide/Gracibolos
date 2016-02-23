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
public class Status implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5010061579993426738L;

	public Status(){
        
    }
    
    public Status(String nome) {
        this.nome = nome;
    }
    
    private Integer id;
    private String nome;
    
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

        
}
