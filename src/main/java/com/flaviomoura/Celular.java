package com.flaviomoura;

public class Celular {
    private String numero;

    public Celular(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isValid(){
        if(this.numero != null){
            if(this.numero.trim().isEmpty()){
                throw new IllegalArgumentException("Atributos numero da classe Celular não pode ser vazio!");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Estudante deve ter pelo menos um numero!");
        }
    }

}
