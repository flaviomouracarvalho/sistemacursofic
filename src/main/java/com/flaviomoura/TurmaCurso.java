package com.flaviomoura;

import java.time.DateTimeException;
import java.time.LocalDate;

public class TurmaCurso {
    private String local;
    private int vagas;
    private int vagasDisponiveis;
    private LocalDate inicioAulas;
    private LocalDate fimAulas;
    private LocalDate inicioMatriculas;
    private LocalDate fimMatriculas;

    private EstudantesMatriculados estudantesMatriculados;

    public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas,
            LocalDate inicioMatriculas, LocalDate fimMatriculas) {

        if(isValid(local)){
            this.local = local;
        }

        this.vagas = vagas;
        this.vagasDisponiveis = vagas;

        if(inicioAulas != null && fimAulas != null && inicioMatriculas != null && fimMatriculas != null){
            this.inicioAulas = inicioAulas;
            this.fimAulas = fimAulas;
            this.inicioMatriculas = inicioMatriculas;
            this.fimMatriculas = fimMatriculas;
        }
        else{
            throw new IllegalArgumentException("Data não pode ser null");
        }
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

    public EstudantesMatriculados getEstudantesMatriculados() {
        return estudantesMatriculados;
    }

    


}
