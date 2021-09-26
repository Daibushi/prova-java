/**
 * 
 */
package br.com.confidencecambio.javabasico.model;

import java.util.stream.IntStream;

/**
 * @author user
 *
 */
public abstract class AbstractPessoa {
	
	protected String nome;

	public String getNome() {
		return nome;
	}
	
	public String getPrimeiroNome() {
		return nome.substring(0, nome.indexOf(' ')).trim();
	}
	
	public String getUltimoNome() {
		return nome.substring(nome.indexOf(' '),nome.length()).trim();
	}
	
	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}
	
	public String getNomeAbreviado() {
		String[] nomes = nome.split(" ");
		//Filtra todas as palavras da lista de nomes que tem menos de 3 letras geralmente artigos e preposições (e, de, do, da)
		//Caso não seja o primeiro nome nem o último nome abrevia
		String[] filtradoMapeado = IntStream.range(0,nomes.length)
									 .filter( s -> ( nomes[s].length() > 3))
									 .mapToObj( i -> i > 0 && i < nomes.length - 1 ? 
											    nomes[i] = abrevia(nomes[i]) : nomes[i]
								    		  )
									 .toArray(String[]::new);
		return String.join(" ",filtradoMapeado);
	}
	
	private String abrevia(String nome) {
		return nome.charAt(0)+".";
	}

	public void setNome(String nome) {
		if( nome == null || nome.isBlank() || nome.isEmpty()) 
			throw new NullPointerException("O nome não deve estar em branco!");
		this.nome = nome.trim();
	}
}
