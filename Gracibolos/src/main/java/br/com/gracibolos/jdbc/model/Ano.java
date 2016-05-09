package br.com.gracibolos.jdbc.model;

import java.io.Serializable;

public class Ano implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String nome;
	private double total;
	
	public Ano() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
