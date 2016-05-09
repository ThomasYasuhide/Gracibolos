package br.com.gracibolos.jdbc.model;

public class GastoRecebimento {
	
	private final Gasto gasto;
	private final Recebimento rec;
	
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
