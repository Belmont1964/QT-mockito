package jogo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JogoTest {
	
	private Jogador mockedJogador;
	private Dado mockedDadinho1;
	private Dado mockedDadinho2;
	private Jogo game;
	
	@BeforeEach
	void prepararTeste() {
		mockedJogador = mock(Jogador.class);
		mockedDadinho1 = mock(Dado.class);
		mockedDadinho2 = mock(Dado.class);
	    game = new Jogo(mockedJogador, mockedDadinho1, mockedDadinho2); 
	}
	
	
	@Test
	@DisplayName ("jogador ganha no 2 turno")
    void deveGanharNoSegundoTurnoAcertandoOPonto() {
		when (mockedJogador.lancar(mockedDadinho1, mockedDadinho2)).thenReturn (5,8,5);
		assertTrue(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador ganha no 1 turno com 7")
    void deveGanharNoPrimeiroTurnoCom7() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(7);
		assertTrue(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador ganha no 1 turno com 11")
    void deveGanharNoPrimeiroTurnoCom11() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(11);
		assertTrue(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador perde no 1 turno com 2")
    void devePerderNoPrimeiroTurnoCom2() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(2);
		assertFalse(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador perde no 1 turno com 3")
    void devePerderNoPrimeiroTurnoCom3() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(3);
		assertFalse(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador perde no 1 turno com 12")
    void devePerderNoPrimeiroTurnoCom12() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(12);
		assertFalse(game.jogo());
	}
	
	@Test
	@DisplayName ("jogador perde no 2 turno com 7")
    void devePerderNoSegundoTurnoCom7() {
		when (mockedJogador.lancar(mockedDadinho1,mockedDadinho2)).thenReturn(4,9,7);
		assertFalse(game.jogo());
	}

}
