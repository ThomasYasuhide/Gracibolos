package br.com.gracibolos.jdbc.model;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Encomenda implements Serializable{
    
	private static final long serialVersionUID = -2187641155037646683L;
	
	private String clientenome;
	private String clientecpfcnpj;
	
		
    private Long id;
    private int clienteid;
    private Integer status;
    private String responsavel;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataentrega;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataencomenda;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datafaturamento;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataproducao;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datafinalizado;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate datacancelamento;
    @JsonProperty("amountOfMoney")
    private BigDecimal totalprodutos;
    private String obs;
    private String nomerazao;
    private Long clienteId;
    private String cpfcnpj;
    private List<ItemEncomenda> listItemEncomenda;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getClientenome() {
		return clientenome;
	}

	public void setClientenome(String clientenome) {
		this.clientenome = clientenome;
	}

	public String getClientecpfcnpj() {
		return clientecpfcnpj;
	}

	public void setClientecpfcnpj(String clientecpfcnpj) {
		this.clientecpfcnpj = clientecpfcnpj;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public LocalDate getDataencomenda() {
		return dataencomenda;
	}
	
	public void setDataencomenda(LocalDate dataencomenda) {
		this.dataencomenda = dataencomenda;
	}
	
	public LocalDate getDataentrega() {
		return dataentrega;
	}
	
	public void setDataentrega(LocalDate dataentrega) {
		this.dataentrega = dataentrega;
	}
	
	public LocalDate getDatafaturamento() {
		return datafaturamento;
	}
	
	public void setDatafaturamento(LocalDate datafaturamento) {
		this.datafaturamento = datafaturamento;
	}
	
	public LocalDate getDataproducao() {
		return dataproducao;
	}
	
	public void setDataproducao(LocalDate dataproducao) {
		this.dataproducao = dataproducao;
	}
	
	public LocalDate getDatafinalizado() {
		return datafinalizado;
	}
	
	public void setDatafinalizado(LocalDate datafinalizado) {
		this.datafinalizado = datafinalizado;
	}
	
	public LocalDate getDatacancelamento() {
		return datacancelamento;
	}

	public void setDatacancelamento(LocalDate datacancelamento) {
		this.datacancelamento = datacancelamento;
	}
	@JsonSerialize(using = PriceJsonSerializer.class)
	public BigDecimal getTotalprodutos() {
		return totalprodutos;
	}
	@JsonSerialize(using = PriceJsonSerializer.class)
	public void setTotalprodutos(BigDecimal totalprodutos) {
		this.totalprodutos = totalprodutos;
	}

	public String getObs() {
		return obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getNomerazao() {
		return nomerazao;
	}

	public void setNomerazao(String nomerazao) {
		this.nomerazao = nomerazao;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public List<ItemEncomenda> getListItemEncomenda() {
		return listItemEncomenda;
	}

	public void setListItemEncomenda(List<ItemEncomenda> listItemEncomenda) {
		this.listItemEncomenda = listItemEncomenda;
	}
	
	public class PriceJsonSerializer extends JsonSerializer<BigDecimal> {

		  @Override
		  public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) 
		    throws IOException, JsonProcessingException {
		      jgen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		  }
		}
}
