package br.com.gracibolos.jdbc.model;

public class GastoRecebimento {
	
	private Gasto gasto;
	private Recebimento rec;
	
	
	public GastoRecebimento(Gasto gasto, Recebimento rec) {
		super();
		this.gasto = gasto;
		this.rec = rec;
	}

	public GastoRecebimento() {
		super();
	}

	public Gasto getGasto() {
		return gasto;
	}

	public Recebimento getRec() {
		return rec;
	}

}
