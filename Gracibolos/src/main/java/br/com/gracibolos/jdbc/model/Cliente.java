package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Cliente implements Serializable{

	private static final long serialVersionUID = -5180421697122999699L;
    
    private Integer id;
    private Integer status;
    private Integer tipopessoa;
    private Integer sexo;
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate datanascimento;
    private String nomerazao;
    private String cpfcnpj;
    private String rgie;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private Integer estado;
    private Integer cidade;
    private Integer cep;
    private String tel;
    private String cel;
    private String email;
    private String site;
	@DateTimeFormat(iso = ISO.DATE)
    private LocalDate clientedesde;
    private String obs;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTipopessoa() {
		return tipopessoa;
	}
	public void setTipopessoa(Integer tipopessoa) {
		this.tipopessoa = tipopessoa;
	}
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getNomerazao() {
		return nomerazao;
	}
	public void setNomerazao(String nomerazao) {
		this.nomerazao = nomerazao;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public String getRgie() {
		return rgie;
	}
	public void setRgie(String rgie) {
		this.rgie = rgie;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getCidade() {
		return cidade;
	}
	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public LocalDate getClientedesde() {
		return clientedesde;
	}
	public void setClientedesde(LocalDate clientedesde) {
		this.clientedesde = clientedesde;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
