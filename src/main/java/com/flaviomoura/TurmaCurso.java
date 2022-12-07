package com.flaviomoura;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurmaCurso {
    private String local;
    private int vagas;
    private int vagasDisponiveis;
    private LocalDate inicioAulas;
    private LocalDate fimAulas;
    private LocalDate inicioMatriculas;
    private LocalDate fimMatriculas;
    public List<String> matriculas = new ArrayList<>();


    public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas,
            LocalDate inicioMatriculas, LocalDate fimMatriculas) {

        if(isValid(local)){
            this.local = local;
        }

        this.vagas = vagas;
        this.vagasDisponiveis = vagas;

        if(inicioAulas != null && fimAulas != null && inicioMatriculas != null && fimMatriculas != null){
            if(inicioAulas.isBefore(fimAulas)){
                if(inicioMatriculas.isBefore(fimMatriculas)){
                    if(inicioAulas.isAfter(fimMatriculas)){
                        this.inicioAulas = inicioAulas;
                        this.fimAulas = fimAulas;
                        this.inicioMatriculas = inicioMatriculas;
                        this.fimMatriculas = fimMatriculas;
                    }else{
                        throw new IllegalArgumentException("Periodo da matricula inválido");
                    }
                }
                else{
                    throw new IllegalArgumentException("Periodo da matricula inválido");
                }
            }
            else{
                throw new IllegalArgumentException("Periodo da matricula inválido");
            }
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

    public int getVagasDisponiveis() {
        return this.vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagas){
        this.vagasDisponiveis = vagas;
    }

    public List<LocalDate> getPeriodoMatriculas(){
        List<LocalDate> datasPeriodo = new ArrayList<>();
        datasPeriodo.add(inicioMatriculas);
        datasPeriodo.add(fimMatriculas);
        return datasPeriodo;
    }

    public String getLocal(){
        return this.local;
    }
}
