package br.com.confidencecambio.javabasico.model;

import org.junit.jupiter.api.BeforeAll;

public class ClienteTests extends AbstractPessoaTest {
	
	@BeforeAll
	public static void init() {
		pessoa = new Cliente();
	}
}
