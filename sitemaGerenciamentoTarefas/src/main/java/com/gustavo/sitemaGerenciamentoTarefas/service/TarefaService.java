package com.gustavo.sitemaGerenciamentoTarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaRequest;
import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaResponse;
import com.gustavo.sitemaGerenciamentoTarefas.entity.Tarefa;
import com.gustavo.sitemaGerenciamentoTarefas.exceptions.TarefaNaoEncontradaException;
import com.gustavo.sitemaGerenciamentoTarefas.repository.TarefaRepositoy;

@Service
public class TarefaService {
    
    List<Tarefa> lista = new ArrayList<>();
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

        Tarefa p = new Tarefa();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setConcluida(dto.getConcluida());
        return repository.save(p);
    }

    //Buscar por id
    public Tarefa buscarId(int id){
        Optional<Tarefa> op = repository.findById(id);
        return op.orElse(null); 
    }

    //Atualizar
    public Tarefa atualizar(int id, TarefaRequest dto){
        for(Tarefa f : lista){
            if(f.getId() == id){
                f.setNome(dto.getNome());
                f.setDescricao(dto.getDescricao());
                f.setConcluida(dto.getConcluida());
                return f;
            }
        }
        throw new TarefaNaoEncontradaException("Id não encontrada");
    }

    //deletar
    public void deletar(int id){
        repository.deleteById(id);
    }


}
