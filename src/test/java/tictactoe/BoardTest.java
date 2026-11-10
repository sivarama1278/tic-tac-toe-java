
package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    // 1. Test board initialization
    @Test
    void testBoardInitialization() {

        Board board = new Board(3);

        assertEquals(3, board.getSize());
    }

    // 2. Test all cells are initially empty
    @Test
    void testAllCellsInitiallyEmpty() {

        Board board = new Board(3);

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {

                assertEquals(Symbol.EMPTY, board.getCell(row, col));
            }
        }
    }

    // 3. Test empty cell detection
    @Test
    void testIsCellEmpty() {

        Board board = new Board(3);

        assertTrue(board.isCellEmpty(0, 0));
    }

    // 4. Test placing a symbol
    @Test
    void testPlaceSymbolMakesCellOccupied() {

        Board board = new Board(3);

        boolean result = board.placeSymbol(0, 0, Symbol.X);

        assertTrue(result);
        assertFalse(board.isCellEmpty(0, 0));
        assertEquals(Symbol.X, board.getCell(0, 0));
    }

    // 5. Test invalid symbol placement
    @Test
    void testPlaceSymbolWithInvalidPosition() {

        Board board = new Board(3);

        assertFalse(board.placeSymbol(-1, 0, Symbol.X));
        assertFalse(board.placeSymbol(3, 0, Symbol.X));
        assertFalse(board.placeSymbol(0, -1, Symbol.X));
        assertFalse(board.placeSymbol(0, 3, Symbol.X));
    }

    // 6. Test placing symbol in an occupied cell
    @Test
    void testCannotPlaceSymbolInOccupiedCell() {

        Board board = new Board(3);

        assertTrue(board.placeSymbol(0, 0, Symbol.X));

        assertFalse(board.placeSymbol(0, 0, Symbol.O));

        assertEquals(Symbol.X, board.getCell(0, 0));
    }

    // 7. Test invalid position in isCellEmpty
    @Test
    void testIsCellEmptyWithInvalidPosition() {

        Board board = new Board(3);

        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(3, 0));
        assertFalse(board.isCellEmpty(0, -1));
        assertFalse(board.isCellEmpty(0, 3));
    }

    // 8. Test board is not full initially
    @Test
    void testBoardIsNotFullInitially() {

        Board board = new Board(3);

        assertFalse(board.isFull());
    }

    // 9. Test board becomes full
    @Test
    void testBoardIsFullAfterAllCellsAreOccupied() {

        Board board = new Board(3);

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {

                assertTrue(board.placeSymbol(row, col, Symbol.X));
            }
        }

        assertTrue(board.isFull());
    }

    // 10. Test board is not full when one cell is empty
    @Test
    void testBoardIsNotFullWhenOneCellIsEmpty() {

        Board board = new Board(3);

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {

                if (row == 2 && col == 2) {
                    continue;
                }

                assertTrue(board.placeSymbol(row, col, Symbol.X));
            }
        }

        assertFalse(board.isFull());
    }
}
