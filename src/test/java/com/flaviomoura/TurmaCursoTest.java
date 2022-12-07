package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TurmaCursoTest {
    @Test
    @DisplayName("Verifica se todos os campos da classe turma curso foram informados")
    public void verificaSeTodosCamposDaClasseTurmaCursoForaminformados(){
        assertAll(() -> new TurmaCurso("sala 210", 10, LocalDate.of(2022, 1, 28), LocalDate.of(2022, 12, 16), LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 25)));
    }

    @Test
    @DisplayName("Verifica se todos os campos da classe turma curso não foram informados")
    public void verificaSeTodosCamposDaClasseTurmaCursoNãoForaminformados(){
        assertThrowsExactly(IllegalArgumentException.class, () -> new TurmaCurso(null, 10, LocalDate.of(2022, 1, 28), LocalDate.of(2022, 12, 16), LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 25)));
    }

}
