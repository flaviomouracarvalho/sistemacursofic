package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TurmaCursoTest {
    @Test
    @DisplayName("Cadastrando TurmaCurso válido")
    public void CadastrandoTurmaCursoValido(){
        assertAll(() -> new TurmaCurso("sala 210", 10, LocalDate.of(2022, 1, 28), LocalDate.of(2022, 12, 16), LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 25)));
    }

    @Test
    @DisplayName("Cadastrando TurmaCurso com atributos null")
    public void CadastrandoTurmaCursoComAtributosNull(){
        //Testando com o atributo String local
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso(null, 10, LocalDate.parse("2022-01-28"), LocalDate.parse("2022-12-16"), LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-25"));
        });

        //Testando com os atributos do tipo data
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso(null, 10, null, LocalDate.parse("2022-12-16"), LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-25"));
        });
    }

    @Test
    @DisplayName("Cadastrando TurmaCurso com atributos vazios")
    public void CadastrandoTurmaCursoComAtributosVazios(){
        //Testando com o atributo String local
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("", 10, LocalDate.parse("2022-01-28"), LocalDate.parse("2022-12-16"), LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-25"));
        });
    }
}
