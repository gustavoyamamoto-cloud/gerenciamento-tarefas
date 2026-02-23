package com.gustavo.sitemaGerenciamentoTarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaRequest;
import com.gustavo.sitemaGerenciamentoTarefas.dto.TarefaResponse;
import com.gustavo.sitemaGerenciamentoTarefas.entity.Tarefa;
import com.gustavo.sitemaGerenciamentoTarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaControler {
    
    private final TarefaService service;

    /* Construtor */
    public TarefaControler(TarefaService service){
        this.service = service;
    }


    //Listar
    @GetMapping
    public List<TarefaResponse> listar(){
        return service.listar()
            .stream()
            .map(service::toResponse)
            .toList();
    }

    //Salvar
    @PostMapping
    public TarefaResponse salvar(@RequestBody TarefaRequest dto){
        Tarefa p = service.salvar(dto);
        return service.toResponse(p);
    }

    //Buscar por id
    @GetMapping("/{id}")
    public TarefaResponse buscarId(@PathVariable int id){

        Tarefa f = service.buscarId(id);
        return service.toResponse(f);
    }

    //Atualizar
    @PutMapping("/{id}")
    public TarefaResponse atualizar(@PathVariable int id, @RequestBody TarefaRequest dto){
        Tarefa f = service.atualizar(id, dto);
        return service.toResponse(f);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        service.deletar(id);
    }

}
