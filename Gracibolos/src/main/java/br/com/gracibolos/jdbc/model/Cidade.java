package br.com.gracibolos.jdbc.model;

import java.io.Serializable;

public class Cidade implements Serializable{

	private static final long serialVersionUID = 3855647080622826030L;
	private int id;
	private String nome;
	private Integer id_estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	
	
	
}
