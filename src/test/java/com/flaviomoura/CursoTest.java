package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CursoTest {
    @Test
    @DisplayName("Cadastrando Curso válido")
    public void CadastrandoCursoAtributosValidos(){
        assertAll(() -> {
            new Curso("SPI", "120", "Sistemas para Internet");
        });
    }

    @Test
    @DisplayName("Cadastrando curso com atributos null")
    public void CadastrandoCursoComAtributosNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Curso(null, null, null);
        });
    }

    @Test
    @DisplayName("Cadastrando curso com atributos vazios")
    public void CadastrandoCursoComAtributosVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Curso("", "", "");
        });
    }

    @Test
    @DisplayName("Matricular estudantes em uma turma de um curso")
    public void MatricularEstudantes(){
        // Atributos Ultilizado
        Curso curso1 = new Curso("SPI", "120h", "Sistemas para internet");
        //Curso curso2 = new Curso("Engenharia", "300h", "Engenharia Elétrica");

        TurmaCurso turmaCurso1 = new TurmaCurso("Sala 1", 1, LocalDate.parse("2022-12-10"), LocalDate.parse("2022-12-25"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-09"));
        // TurmaCurso turmaCurso2 = new TurmaCurso("Sala 2", 1, null, null, null, null);
        // TurmaCurso turmaCurso3 = new TurmaCurso("Sala 1", 1, null, null, null, null);
        // TurmaCurso turmaCurso4 = new TurmaCurso("Sala 2", 1, null, null, null, null);

        Celular celular1 = new Celular("1234");
        //Celular celular2 = new Celular("1234");

        Estudante estudante1 = new Estudante("Flávio", "1234", LocalDate.parse("2000-07-24"), "106 sul", "flavio@gmail", celular1);
        // Estudante estudante2 = new Estudante(null, null, null, null, null, celular2)
        // Estudante estudante3 = new Estudante(null, null, null, null, null, celular2)
        // Estudante estudante4 = new Estudante(null, null, null, null, null, celular2)
        // Estudante estudante5 = new Estudante(null, null, null, null, null, celular2)
        // Estudante estudante6 = new Estudante(null, null, null, null, null, celular2)
        // Estudante estudante7 = new Estudante(null, null, null, null, null, celular2)

        System.out.println(new Scanner(System.in).nextLine());
        
    }
}
