package com.gustavo.sitemaGerenciamentoTarefas.dto;

public class TarefaRequest {
    
    private String nome;
    private String descricao;
    private boolean concluida;

    /* Construtor */
    public TarefaRequest(){}

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    
}
