/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 *
 * @author d637942
 */
public class Cliente implements Serializable{
    
    public Cliente(){
        
    }
    
    public Cliente(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    
    private String nomeRs;
    private String cpfCnpj;
    private String rgIe;
    private Integer cep;
    private String numero;
    private String tel1;
    private String tel2;
    private String email;
    private String status;
    private Character sexo;
    private Calendar aniversario;
    private String complemento;
    private String site;
    private Calendar clienteDesde;
    private String obs;
     private Collection<Encomenda> encomendaCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeRs() {
        return nomeRs;
    }

    public void setNomeRs(String nomeRs) {
        this.nomeRs = nomeRs;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Calendar getAniversario() {
        return aniversario;
    }

    public void setAniversario(Calendar aniversario) {
        this.aniversario = aniversario;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Calendar getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(Calendar clienteDesde) {
        this.clienteDesde = clienteDesde;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     *
     * @return
     */
    public Collection<Encomenda> getEncomendaCollection() {
        return encomendaCollection;
    }

    public void setEncomendaCollection(Collection<Encomenda> encomendaCollection) {
        this.encomendaCollection = encomendaCollection;
    }
    
}
