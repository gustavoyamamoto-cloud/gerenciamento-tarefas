package com.gustavo.sitemaGerenciamentoTarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaRequest;
import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaResponse;
import com.gustavo.sitemaGerenciamentoTarefas.entity.Tarefa;
import com.gustavo.sitemaGerenciamentoTarefas.exceptions.TarefaNaoEncontradaException;
import com.gustavo.sitemaGerenciamentoTarefas.repository.TarefaRepositoy;

@Service
public class TarefaService {
    
    private final TarefaRepositoy repository;

    /* Construto */
    public TarefaService(TarefaRepositoy repositoy){
        this.repository = repositoy;
    }

    /* ToResponse */
    public TarefaResponse toResponse(Tarefa t){

        return new TarefaResponse(
            t.getId(),
            t.getNome(),
            t.getDescricao(),
            t.getConcluida()
        );
    }

    /* ToEntity */
    public Tarefa toEntity(TarefaRequest dto){
        
        Tarefa f = new Tarefa();
        f.setNome(dto.getNome());
        f.setDescricao(dto.getDescricao());
        f.setConcluida(dto.getConcluida());
        return f;
    }


    //Listar tarefas
    public List<Tarefa> listar(){
        return repository.findAll();
    }

    //Salvar Tarefas
    public Tarefa salvar(TarefaRequest dto){

        Tarefa p = toEntity(dto);
        return repository.save(p);
    }

    //Buscar por id
    public Tarefa buscarId(int id){
        return repository.findById(id)
        .orElseThrow(() -> new TarefaNaoEncontradaException("Id não encontrado"));
    }

    //Atualizar
    public Tarefa atualizar(int id, TarefaRequest dto){
        Tarefa tarefa = repository.findById(id)
        .orElseThrow(() -> new TarefaNaoEncontradaException("Id não encontrada"));

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(dto.getConcluida());

        return repository.save(tarefa);
    }

    //deletar
    public void deletar(int id){
        if(!repository.existsById(id)){
            throw new TarefaNaoEncontradaException("Id não encontrado");
        }
        repository.deleteById(id);
    }

    //Filtrar por status
    public List<Tarefa> filtrarStatus(boolean status){
        return repository.findByConcluida(status);
    }

    //Filtrar por titulo
    public List<Tarefa> filtrarTitulo(String text){
        return repository.findByNomeContaining(text);
    }

}
