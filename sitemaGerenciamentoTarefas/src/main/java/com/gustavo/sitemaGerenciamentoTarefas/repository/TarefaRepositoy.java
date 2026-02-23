package com.gustavo.sitemaGerenciamentoTarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.sitemaGerenciamentoTarefas.entity.Tarefa;

public interface TarefaRepositoy extends JpaRepository<Tarefa, Integer>{
    List<Tarefa> findByConcluida(boolean concluida);
}
