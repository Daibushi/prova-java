package br.com.confidencecambio.javabasico.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

    private static HelloService service;

    @BeforeAll
    public static void init(){
         service = new HelloService();
    }


    @Test
    public void quandoPassarUmNomeQueroEleDeResposta(){
        var nome = "Meu Nome";
        String valorValido = service.retornaValorValido(nome);
        assertEquals(nome,valorValido);
    }

    @Test
    public void quandoPassarNuloQueroOPadrao(){

        String valorValido = service.retornaValorValido(null);
        assertEquals("Mundo",valorValido);
    }

}