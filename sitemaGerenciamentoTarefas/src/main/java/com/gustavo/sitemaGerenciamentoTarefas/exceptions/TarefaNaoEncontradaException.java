package com.gustavo.sitemaGerenciamentoTarefas.exceptions;

public class TarefaNaoEncontradaException extends RuntimeException{
    
    public TarefaNaoEncontradaException(String  msg){
        super(msg);
    }
}
