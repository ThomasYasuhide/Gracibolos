/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author d637942
 */
public class Fornecedor implements Serializable{
    
    public Fornecedor(){
        
    }
    
    public Fornecedor(Integer id) {
        this.id = id;
    }
    
    private Integer id;
    private String nomeRs;
    private String cpfCnpj;
    private String rgIe;
    private Integer cep;
    private String numero;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String cel1;
    private String cel2;
    private String site;
    private String email1;
    private String email2;
    private String contato1;
    private String contato2;
    private String complemento;
    private String obs;
    private Collection<Compra> compraCollection;
    private Collection<Conta> contaCollection;
    private Collection<Suporte> suporteCollection;

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

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public String getCel1() {
        return cel1;
    }

    public void setCel1(String cel1) {
        this.cel1 = cel1;
    }

    public String getCel2() {
        return cel2;
    }

    public void setCel2(String cel2) {
        this.cel2 = cel2;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Collection<Conta> getContaCollection() {
        return contaCollection;
    }

    public void setContaCollection(Collection<Conta> contaCollection) {
        this.contaCollection = contaCollection;
    }

    public Collection<Suporte> getSuporteCollection() {
        return suporteCollection;
    }

    public void setSuporteCollection(Collection<Suporte> suporteCollection) {
        this.suporteCollection = suporteCollection;
    }
    
    
    
}
