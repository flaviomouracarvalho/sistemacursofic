package com.flaviomoura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudantesMatriculados {
    private LocalDate dataMatricula;
    private List<Estudante> estudantes = new ArrayList<>();


    public EstudantesMatriculados(String matricula, LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public List getEstudantes(){
        return this.estudantes;
    }

    public Estudante getEstudante(String matricula){
        for(Estudante estudante: this.estudantes){
            if(estudante.getMatricula() == matricula){
                return estudante;
            }
        }
        return null;
    }
}
