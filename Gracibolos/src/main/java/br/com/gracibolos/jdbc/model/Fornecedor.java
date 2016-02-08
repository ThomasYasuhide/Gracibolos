package br.com.gracibolos.jdbc.model;

import java.io.Serializable;

public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 3702725812080610435L;
	
	private Integer id;
    private int tipopessoa;
    private String nomerazao;
    private String cpfcnpj;
    private String rgie;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private int estado;
    private int cidade;
    private Integer cep;
    private String tel;
    private String cel;
    private String email;
    private String site;
    private String obs;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(int tipopessoa) {
		this.tipopessoa = tipopessoa;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
