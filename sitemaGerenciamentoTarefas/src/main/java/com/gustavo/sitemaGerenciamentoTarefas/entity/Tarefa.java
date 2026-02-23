package com.gustavo.sitemaGerenciamentoTarefas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private boolean concluida;
    
    /* Construto vaziu */
    public Tarefa() {}

    /* Getters */
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean getConcluida() {
        return concluida;
    }

    /* Setters */
    public void setId(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("Id inválido");
        }
        this.id = id;
    }
    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    /* ToString */
    public String toString(){
        return String.format("|Id: %5d |Nome: %15s |Descrição: %20s |Concluida: %b", getId(), getNome(), getDescricao(), getConcluida());
    }    

    /* Equals */
    public boolean equals(Object obj){
        if (this == obj) return true;  
	    if (obj ==null) return false;   
	    if (getClass() != obj.getClass()) return false;

        Tarefa other = (Tarefa)obj;

        return getId() == other.getId();
    }

    /* HashCode */
    public int hashCode(){
        return Integer.hashCode(getId());
    }
}
