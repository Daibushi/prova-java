package br.com.confidencecambio.javabasico.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class AbstractPessoaTest {
	
	protected static AbstractPessoa pessoa;
	private static String errorMessage = "O nome não deve estar em branco!";
	
	@BeforeAll
	public static void init() throws Exception {
		throw new Exception("Deve ser declarado o método init na classe de teste para esse tipo.");
	}
	
	@Test
	@DisplayName("Quando nome for enviado como nulo.")
	public void quandoNomeNuloMostrarErro() {
        String actualMessage = "";
        try {
        	pessoa.setNome(null);
		} catch (Exception e) {
			actualMessage = e.getMessage();
		}
        assertTrue(actualMessage.contains(errorMessage));
	}
	
	@Test
	@DisplayName("Quando nome for enviado como vazio.")
	public void quandoNomeVazioMostrarErro() {
        String actualMessage = "";
        try {
        	pessoa.setNome("");
		} catch (Exception e) {
			actualMessage = e.getMessage();
		}
        assertTrue(actualMessage.contains(errorMessage));
	}
	
	@Test
	@DisplayName("Quando nome for enviado com espaços no fim e começo.")
	public void quandoNomeComEspacosExtras() {
		var nomeComEspacos = " Jaderson Barrozo Nascimento ";
		var nomeSemEspacos = "Jaderson Barrozo Nascimento";
		pessoa.setNome(nomeComEspacos);
    	assertEquals(nomeSemEspacos,pessoa.getNome());
	}
	
	@Test
	@DisplayName("Quando for pedido o primeiro nome da pessoa.")
	public void quandoForPedidoPrimeiroNome() {
		var nome = "João Soares Silva";
		var primeiroNome = "João";
		pessoa.setNome(nome);
    	assertEquals(primeiroNome,pessoa.getPrimeiroNome());
	}
	
	@Test
	@DisplayName("Quando for pedido o ultimo nome da pessoa.")
	public void quandoForPedidoUltimoNome() {
		var nome = "João Soares Silva";
		var ultimoNome = "Soares Silva";
		pessoa.setNome(nome);
    	assertEquals(ultimoNome,pessoa.getUltimoNome());
	}
	
	@Test
	@DisplayName("Quando for pedido o nome maiusculo.")
	public void quandoForPedidoNomeMaiusculo() {
		var nome = "João Soares Silva";
		var nomeMaiusculo = nome.toUpperCase();
		pessoa.setNome(nome);
    	assertEquals(nomeMaiusculo,pessoa.getNomeMaiusculo());
	}
	
	@Test
	@DisplayName("Quando for pedido o nome abreviado.")
	public void quandoForPedidoNomeAbreviado() {
		var nome = "João Soares Silva";
		var nomeAbreviado = "João S. Silva";
		pessoa.setNome(nome);
    	assertEquals(pessoa.getNomeAbreviado(),nomeAbreviado);
    	// Agora o teste master das abreviações
    	// O nome de Dom Pedro II
    	var nomeDomPedro = "Pedro de Alcântara João Carlos Leopoldo Salvador Bibiano Francisco"+
    					   " Xavier de Paula Leocádio Miguel Gabriel Rafael Gonzaga de Bragança"+
    					   " e Bourbon";
    	var nomeDomPedroAbreviado = "Pedro A. J. C. L. S. B. F. X. P. L. M. G. R. G. B. Bourbon";
		pessoa.setNome(nomeDomPedro);
    	assertEquals(nomeDomPedroAbreviado,pessoa.getNomeAbreviado());
	}
}
