package br.com.gracibolos.jdbc.model;

public class GastoRecebimento {
	
	private Gasto gasto;
	private Recebimento rec;
	
	public GastoRecebimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GastoRecebimento(Gasto gasto, Recebimento rec) {
		super();
		this.gasto = gasto;
		this.rec = rec;
	}

	public Gasto getGasto() {
		return gasto;
	}

	public Recebimento getRec() {
		return rec;
	}

}
