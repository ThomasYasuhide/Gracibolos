/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gracibolos.jdbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author d637942
 */
public class Conta implements Serializable{
    
    public Conta(){
        
    }
    
    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, Date dataVencimento) {
        this.id = id;
        this.dataVencimento = dataVencimento;
    }
    
    private Integer id;
    private String codigo;
    private Date dataVencimento;
    private Date dataPagamento;
    private BigDecimal valor;
    private Caixa caixaId;
    private Fornecedor fornecedorId;
    private Colaborador colaboradorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Caixa getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Caixa caixaId) {
        this.caixaId = caixaId;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Colaborador getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Colaborador colaboradorId) {
        this.colaboradorId = colaboradorId;
    }
    
    
    
}
