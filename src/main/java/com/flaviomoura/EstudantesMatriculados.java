package com.flaviomoura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudantesMatriculados {
    private LocalDate dataMatricula;
    private String matricula;
    private TurmaCurso turmaCurso;


    public EstudantesMatriculados(String matricula, LocalDate dataMatricula, TurmaCurso turmaCurso) {
        turmaCurso.matriculas.add(matricula);
        this.dataMatricula = dataMatricula;
        this.turmaCurso = turmaCurso;
        if(podeMatricular(dataMatricula)){
            this.dataMatricula = dataMatricula;
            this.matricula = matricula;
        }
        else{
            throw new IllegalArgumentException("Não pode matricular");
        }
        diminuirVagas();
    }

    public boolean podeMatricular(LocalDate dataMatricula){
        if(this.turmaCurso.getVagasDisponiveis() > 0){
            if(dataMatricula.isAfter(turmaCurso.getPeriodoMatriculas().get(0)) && dataMatricula.isBefore(turmaCurso.getPeriodoMatriculas().get(1))){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public void diminuirVagas(){
        this.turmaCurso.setVagasDisponiveis(this.turmaCurso.getVagasDisponiveis()-1);
    }
}
