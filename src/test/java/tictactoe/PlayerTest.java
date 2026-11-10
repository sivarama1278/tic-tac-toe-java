
package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //Test player initialization
    @Test
    void testPlayerInitialization() {

        Player player = new Player(1, "Siva", Symbol.X);

        assertEquals(1, player.getId());
        assertEquals("Siva", player.getName());
        assertEquals(Symbol.X, player.getSymbol());
    }

    //Test player with O symbol
    @Test
    void testPlayerWithOSymbol() {

        Player player = new Player(2, "Sadhu", Symbol.O);

        assertEquals(2, player.getId());
        assertEquals("Sadhu", player.getName());
        assertEquals(Symbol.O, player.getSymbol());
    }

    //Test different players have independent properties
    @Test
    void testTwoPlayersHaveDifferentProperties() {

        Player player1 = new Player(1, "Siva", Symbol.X);
        Player player2 = new Player(2, "Sadhu", Symbol.O);

        assertNotEquals(player1.getId(), player2.getId());
        assertNotEquals(player1.getName(), player2.getName());
        assertNotEquals(player1.getSymbol(), player2.getSymbol());
    }
}
