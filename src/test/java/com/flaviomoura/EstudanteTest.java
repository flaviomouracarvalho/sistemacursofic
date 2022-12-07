package com.flaviomoura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.flaviomoura.Celular;

public class EstudanteTest {
    private Estudante gerarEstudante(LocalDate data){
        return new Estudante(
            "flavio",
            data,
            "106 sul", 
            "flavio@gmail", 
            new Celular("123"));
    }

    @Test
    @DisplayName("verifica se todos campos informados da classe estudante foram informados")
    public void verificaSeTodosCamposDaClasseEstudanteForamInformados(){
        assertAll(()->{
            new Estudante("Flávio", LocalDate.parse("2000-07-24"), "106 sul", "flavio@gmail", new Celular("1234"));
        });
    }

    @Test
    @DisplayName("verifica se todos campos informados da classe estudante não foram informados")
    public void verificaSeTodosCamposDaClasseEstudanteNaoForamInformados(){
        assertThrowsExactly(IllegalArgumentException.class, ()->{
            new Estudante(null, LocalDate.parse("2000-07-24"), "106 sul", "flavio@gmail", new Celular("1234"));
        });
    }

    @Test
    @DisplayName("Verifica se estudante tem idade maior que 15")
    public void verificaIdadeEstudanteMaior15(){
        assertAll(()->{
            new Estudante("Flávio", LocalDate.parse("2000-07-24"), "106 sul", "flavio@gmail", new Celular("1234"));
        });
    }

    @Test
    @DisplayName("Verifica se estudante não tem idade maior que 15")
    public void verificaIdadeEstudanteNaoMaior15(){
        assertThrowsExactly(IllegalArgumentException.class, ()->{
            new Estudante("Flávio", LocalDate.parse("2019-07-24"), "106 sul", "flavio@gmail", new Celular("1234"));
        });
    }

    @Test
    @DisplayName("Verificando Cadastro de estudantes quando vagas disponiveis for maior a 0")
    public void verificaVagasMaiorQue0(){
        assertAll(() -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando Cadastro de estudantes quando vagas disponiveis for menor a 0")
    public void verificaVagasMenorQue0(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Estudante estudante2 = gerarEstudante(LocalDate.parse("2001-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 1, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
            EstudantesMatriculados estudantesMatriculados2 = new EstudantesMatriculados(estudante2.getMatricula(), LocalDate.now(), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando Cadastro de estudantes quando periodo for correto")
    public void verificaPeriodoCorreto(){
        assertAll(() -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando Cadastro de estudantes quando periodo for errado")
    public void verificaPeriodoErrado(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.parse("2023-01-30"), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando se há vaga no curso para matricular o estudante e se a matricula está sendo feita dentro do prazo correto")
    public void verificaVagaEMatriculaNoPrazo(){
        assertAll(() -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando se não há vaga no curso para matricular o estudante e se a matricula não está sendo feita dentro do prazo correto")
    public void verificaSeNaoHaVagaEMatriculaNoPrazo(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 0, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.parse("2023-01-30"), turmaCurso);
        });
    }

    @Test
    @DisplayName("Verificando periodo das Matriculas correto")
    public void verificaPeriodoMatriculaCorreto(){
        assertAll(() -> {
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
        });
    }

    @Test
    @DisplayName("Verificando periodo das Matriculas errado")
    public void verificaPeriodoMatriculaErrado(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-29"));
        });
    }

    @Test
    @DisplayName("Listando turmas que contem alunos matriculaods")
    public void listarTumasAlunosMatriculados(){
        assertAll(() -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
            curso.buscarTurmas();
        });
    }

    @Test
    @DisplayName("Verificando excessão qunado turmas que não contem alunos matriculaods")
    public void NaoContemAlunosMatriculados(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            Estudante estudante = gerarEstudante(LocalDate.parse("2000-07-24"));
            Curso curso = new Curso("SPI", "120 horas", "Sistema para internet");
            TurmaCurso turmaCurso = new TurmaCurso("sala 25", 2, LocalDate.parse("2023-01-28"), LocalDate.parse("2023-12-16"), LocalDate.parse("2022-12-01"), LocalDate.parse("2023-01-25"));
            curso.AdicionarTurma(turmaCurso);
            //EstudantesMatriculados estudantesMatriculados = new EstudantesMatriculados(estudante.getMatricula(), LocalDate.now(), turmaCurso);
            curso.buscarTurmas();
        });
    }
}
