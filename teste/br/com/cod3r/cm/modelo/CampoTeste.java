package br.com.cod3r.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}	
		
	@Test
	void testeVizinholDistancia1() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}
	
	@Test
	void testeVizinholDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}
	
	@Test
	void testeVizinhoDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);

	}
      @Test
	void testeValorPadraoAtributoMarcado() {
		
		assertFalse(campo.isMarcado());
		
	}
      @Test
      void testeAlternarMarcacao() {
    	  campo.alternarMarcacao();
    	  assertTrue(campo.isMarcado());
    	  
      }
	
      @Test
      void testeAlternarMarcacaoDuasChamadas() {
    	  campo.alternarMarcacao();
    	  campo.alternarMarcacao();
    	  assertFalse(campo.isMarcado());
    	  
      }
      
      @Test
      void testeAbrirNaoMinadoNaoMarcado() {
    	  assertTrue(campo.abrir());
    	  
      }
      
      @Test
      void testeAbrirNaoMinadoMarcado() {
    	  campo.alternarMarcacao();
    	  assertFalse(campo.abrir());
    	  
      }
      
      @Test
      void testeAbrirMinadoMarcado() {
    	  campo.alternarMarcacao();
    	  campo.minar();
    	  assertFalse(campo.abrir());
    	  
      }
      
      @Test
      void testeAbrirMinadoNaoMarcado() {
    	  campo.minar();
    	  
    	  assertThrows(ExplosaoException.class, () -> {
    		  campo.abrir();    	  
    	  });
    	  
    	  
      }
}
