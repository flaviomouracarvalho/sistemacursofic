package com.flaviomoura;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estudante {
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String endereco;
    private String emailInstitucional;
    private List<Celular> celulars = new ArrayList<>();

    public Estudante(String nome, LocalDate dataNascimento, String endereco,
            String emailInstitucional, Celular numero){
            if(isValid(nome) || isValid(matricula) || isValid(endereco) || isValid(emailInstitucional)){
                this.nome = nome;
                this.matricula = gerarMatricula();
                this.dataNascimento = dataNascimento;
                this.endereco = endereco;
                this.emailInstitucional = emailInstitucional;
                if(numero.isValid()){
                    this.celulars.add(numero);
                }
                if(isValidDate(dataNascimento)){
                    this.dataNascimento = dataNascimento;
                }
    
            }
            else{
                throw new Error("Erro ao instanciar a classe");
            }
    }

    public boolean isValid(String att){
        if(att != null){
            if(att.trim().isEmpty()){
                throw new IllegalArgumentException("Atributos não pode ser vazio!");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Atributos não pode ser nulo!");
        }
    }

    public boolean isValidDate(LocalDate data){
        if(ChronoUnit.YEARS.between(data, LocalDate.now()) > 15){
            return true;
        }
        else{
            throw new IllegalArgumentException("Estudante deve ter no minimo 15 anos");
        }
    }

    public static String gerarMatricula(){
        //Este e a maneira que fiz para gerar matricula, so que como o senhor mandou.
        return String.valueOf(LocalDate.now().getYear()) + (String.valueOf(new Random().nextInt() * 10));
        //So que como esse método gera um numero aleatorio, e não da pra pega-lo,  e la na classe EstudanteMatriculado para
        //buscar um aluno foi usado, um String matricula, a matricula sera informada manualmente.
    }

    public String getMatricula(){
        return this.matricula;
    }
    
}
