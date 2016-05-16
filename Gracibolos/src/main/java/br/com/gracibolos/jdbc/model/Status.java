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
        
    private Long id;
    private String nome;
    private boolean status1;
    private boolean status2;
    private Long numeroEncomenda;
    
    
	public boolean getStatus2() {
		return status2;
	}

	public void setStatus2(boolean status2) {
		this.status2 = status2;
	}

	public boolean getStatus1() {
		return status1;
	}

	public void setStatus1(boolean status) {
		this.status1 = status;
	}

	public Long getNumeroEncomenda() {
		return numeroEncomenda;
	}

	public void setNumeroEncomenda(Long numeroEncomenda) {
		this.numeroEncomenda = numeroEncomenda;
	}

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

        
}
