package br.com.gracibolos.jdbc.model;

import java.math.BigDecimal;

public class Saldo {
	
	private long id;
	private BigDecimal saldo;
	
	public Saldo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
}
