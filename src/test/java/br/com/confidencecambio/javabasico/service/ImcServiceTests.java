package br.com.confidencecambio.javabasico.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImcServiceTests {
	private static ImcService service;
	private static String errorMessage = "Os valores inseridos devem ser maior que zero!";

    @BeforeAll
    public static void init(){
         service = new ImcService();
    }

    @Test
    @DisplayName("Valores Corretos")
    public void quandoPassarOsValoresCorretosRetonarImc(){
        var peso = "105";
        var alturaCm = "180";
        var imc = 32.4f;
        float valorValido = 0;
		try {
			valorValido = service.retornaImc(peso,alturaCm);
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertEquals(imc,valorValido,0);
    }
    
    @Test
    @DisplayName("Altura zero")
    public void quandoAlturaZeroRetornarErro(){
        var peso = "105";
        var alturaCm = "0";
        String actualMessage = "";
        try {
        	service.retornaImc(peso,alturaCm);
		} catch (Exception e) {
			actualMessage = e.getMessage();
		}
        assertTrue(actualMessage.contains(errorMessage));
    }

    @Test
    @DisplayName("Peso zero")
    public void quandoPesoZeroRetornarErro(){
    	var peso = "0";
    	var alturaCm = "180";
        String actualMessage = "";
        try {
        	service.retornaImc(peso,alturaCm);
		} catch (Exception e) {
			actualMessage = e.getMessage();
		}
        assertTrue(actualMessage.contains(errorMessage));
    }
}
