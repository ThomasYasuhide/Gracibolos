package br.com.gracibolos.jdbc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SaldoAnterior {
	
	private BigDecimal valorSaldoAnterior;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataSaldoAnterior;
	private int parcelaSaldoAnterior;
	private String formaSaldoAnterir;
	private int gastoRecebimentoSaldoAnterior;
	private String descricaoSaldoAnterior;
	
	
	public String getFormaSaldoAnterir() {
		return formaSaldoAnterir;
	}
	public void setFormaSaldoAnterir(String formaSaldoAnterir) {
		this.formaSaldoAnterir = formaSaldoAnterir;
	}
	public BigDecimal getValorSaldoAnterior() {
		return valorSaldoAnterior;
	}
	public void setValorSaldoAnterior(BigDecimal valorSaldoAnterior) {
		this.valorSaldoAnterior = valorSaldoAnterior;
	}
	public LocalDate getDataSaldoAnterior() {
		return dataSaldoAnterior;
	}
	public void setDataSaldoAnterior(LocalDate dataSaldoAnterior) {
		this.dataSaldoAnterior = dataSaldoAnterior;
	}
	public int getParcelaSaldoAnterior() {
		return parcelaSaldoAnterior;
	}
	public void setParcelaSaldoAnterior(int parcelaSaldoAnterior) {
		this.parcelaSaldoAnterior = parcelaSaldoAnterior;
	}
	public int getGastoRecebimentoSaldoAnterior() {
		return gastoRecebimentoSaldoAnterior;
	}
	public void setGastoRecebimentoSaldoAnterior(int gastoRecebimentoSaldoAnterior) {
		this.gastoRecebimentoSaldoAnterior = gastoRecebimentoSaldoAnterior;
	}
	public String getDescricaoSaldoAnterior() {
		return descricaoSaldoAnterior;
	}
	public void setDescricaoSaldoAnterior(String descricaoSaldoAnterior) {
		this.descricaoSaldoAnterior = descricaoSaldoAnterior;
	}
	
	
}
