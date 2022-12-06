package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flaviomoura.Celular;

public class EstudanteTest {
    

    @Test
    @DisplayName("Cadastrando usuário com pelo menos um número ")
    public void verificaEstudanteComNumeroCelular(){
        assertAll(() -> new Estudante("flavio", "123456", LocalDate.of(2000, 7, 24), "casa", "flavio@gmial", new Celular("1234")));
    }

    @Test
    @DisplayName("Cadastrando usuário com número null")
    public void verificaEstudanteComNumeroCelularNull(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("flavio", "", LocalDate.of(2000, 7, 24), "casa", "flavio@gmial", new Celular(null));
        }
        );
    }

    @Test
    @DisplayName("Cadastrando usuário com número vazio")
    public void verificaEstudanteComNumeroCelularVazio(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("flavio", "", LocalDate.of(2000, 7, 24), "casa", "flavio@gmial", new Celular(""));
        }
        );
    }

    @Test
    @DisplayName("Cadastrando usuário com atributo null")
    public void verificaEstudanteComAtributoNull(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante(null, "123456", LocalDate.of(2000, 7, 24), "casa", "flavio@gmial", new Celular("1234"));
        }
        );
    }

    @Test
    @DisplayName("Cadastrando usuário com atributo vazio")
    public void verificaEstudanteComAtributoVazio(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("", "123456", LocalDate.of(2000, 7, 24), "casa", "flavio@gmial", new Celular("1234"));
        }
        );
    }

    @Test
    @DisplayName("Cadastrando usuário que não tem 15 anos")
    public void verificaEstudanteNaoTem15Anos(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("flavio", "123456", LocalDate.of(2019, 7, 24), "casa", "flavio@gmial", new Celular("1234"));
        }
        );
    }
}
