/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Johnathan
 */
public class Produto {

    private Integer idProduto;
    private String nome;
    private String descricao;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidade;
    private boolean disponivel;
    private Date dtCadastro;

    public Produto()
    {
        
    }
    
    public Produto(String nome, String descricao, Double precoCompra, Double precoVenda, Integer quantidade, boolean disponivel)
    {
     this.nome = nome;
     this.descricao = descricao;
     this.precoCompra = precoCompra;
     this.precoVenda = precoVenda;
     this.quantidade = quantidade;
     this.disponivel = disponivel;
     this.dtCadastro = new Date(System.currentTimeMillis());
    }
    
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Object getDisponivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
