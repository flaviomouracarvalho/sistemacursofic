package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CursoTest {
    @Test
    @DisplayName("verifica se todos campos informados da classe curso foram informados")
    public void verificaSeTodosCamposDaClasseCursoForamInformados(){
        assertAll((()-> {
            new Curso("SPI", "120h", "Sistema para internet");
        }));
    }

    @Test
    @DisplayName("verifica se todos campos informados da classe curso não foram informados")
    public void verificaSeTodosCamposDaClasseCursoNaoForamInformados(){
        assertThrowsExactly(IllegalArgumentException.class, (()-> {
            new Curso(null, "120h", "Sistema para internet");
        }));
    }

}
