package com.flaviomoura;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String cargaHoraria;
    private String descricao;

    private List<TurmaCurso> turmaCursos = new ArrayList<>();
    
    public Curso(String nome, String cargaHoraria, String descricao) {
        if(isValid(nome) && isValid(cargaHoraria) && isValid(descricao)){
            this.nome = nome;
            this.cargaHoraria = cargaHoraria;
            this.descricao = descricao;
        }
        else{
            throw new Error("Erro ao instanciar a classe");
        }
    }

    public void AdicionarTurma(TurmaCurso turmaCurso){
        this.turmaCursos.add(turmaCurso);
    }

    public boolean isValid(String val){
        if(val != null){
            if(val.trim().isEmpty()){
                throw new IllegalArgumentException("Não pode conter valor vazio");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Não pode conter valor null");
        }

    }

    public List buscarTurmas(){
        List<TurmaCurso> turmas = new ArrayList<>();
        for(TurmaCurso turma: this.turmaCursos){
            if(turma.matriculas.size()!=0){
                turmas.add(turma);
            } 
        }
        if(turmas.size()!=0){
            return turmas;
        }
        throw new IllegalArgumentException("Turma vazia");
    }
}
