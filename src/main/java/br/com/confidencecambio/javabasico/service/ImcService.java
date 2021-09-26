package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Component;

@Component
public class ImcService {
	private int peso;
	private int altura;

	public float retornaImc(String peso, String altura) throws Exception {
		try {
			this.altura = Integer.parseInt(altura);
			this.peso = Integer.parseInt(peso);
		}catch(Exception e){
			throw new Exception("Os valores supridos devem ser numeros inteiros válidos. (Peso em quilos e altura em centimetros)");
		}
		
		if(this.peso <= 0 || this.altura <= 0) throw new Exception("Os valores inseridos devem ser maior que zero!");
		
		return toOneDecimal(getRawImc(this.peso,this.altura));
	}
	
	private float parseCentimetroParaMetro(int centimetros) {
		return (float) centimetros / 100;
	}
	
	protected float getRawImc(int peso, int altura) {
		return (float) (peso / Math.pow(parseCentimetroParaMetro(altura), 2));
	}
	
	protected float toOneDecimal(float number) {
		return (float) (Math.round(number * 10)) / 10;
	}
}
