package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;
    
    @BeforeEach
    public void setUp() {
       board=new Board();
    }
    
    @Test
    public void testDefaultConstructor() {
        System.out.println("test default constructor");
        
        for(int i=0; i<Board.SIZE; i++)
            assertEquals(board.getCellContent(i),Board.CELL_NONE);
        assertEquals(board.getNextMark(), Board.CELL_X);
    }
    
    @Test
    public void testCopyConstructor() {
        System.out.println("test copy constructor");
       
        board.applyMove(0);
        board.applyMove(1);
        board.applyMove(4);
        Board copy=new Board(board);
        for(int i=0; i<Board.SIZE; i++)
            assertEquals(board.getCellContent(i), copy.getCellContent(i));
        assertEquals(board.getNextMark(), copy.getNextMark());
    }
    
    @Test
    public void testGetNextMarkO() {
        System.out.println("test getNextMarkO");
       
        board.applyMove(0);
        board.applyMove(1);
        board.applyMove(4);
        assertEquals(board.getNextMark(), Board.CELL_O);
    }
    @Test
    public void testGetNextMarkX() {
        System.out.println("test getNextMarkX");
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(1);
        board.applyMove(4);
        board.applyMove(8);
        assertEquals(board.getNextMark(), Board.CELL_X);
    }

    
    @Test
    public void testGetCellContent() {
        System.out.println("test getCellContent");
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(1);
        board.applyMove(4);
        
        assertEquals(board.getCellContent(0), Board.CELL_X);
        assertEquals(board.getCellContent(1), Board.CELL_O);
        assertEquals(board.getCellContent(2), Board.CELL_NONE);
        assertEquals(board.getCellContent(3), Board.CELL_NONE);
        assertEquals(board.getCellContent(4), Board.CELL_X);
        for(int i=5; i<Board.SIZE; i++)
            assertEquals(board.getCellContent(i), Board.CELL_NONE);
    }

    @Test
    public void testIsValidMove() {
        System.out.println("test getIsValidMove");
        
        board.applyMove(0);
        board.applyMove(4);
        
        assertTrue(board.isValidMove(2));
        assertFalse(board.isValidMove(4));
        /* per questo metodo di test non devo fare assert per controllare se int move è <0 o >=SIZE
           perchè questi casi non si devono generare per le precondizioni del metodo ???? */
    }

    @Test
    public void testIsEnded1() {
        System.out.println("test IsEnded1");
        
        board.applyMove(0);
        board.applyMove(4);
        
        assertFalse(board.isEnded());
    }
    @Test
    public void testIsEndedParità() {
        System.out.println("test isEndedParità");
        
        board.applyMove(4);
        board.applyMove(0);
        board.applyMove(2);
        board.applyMove(6);
        board.applyMove(3);
        board.applyMove(5);
        board.applyMove(7);
        board.applyMove(1);
        board.applyMove(8);
        
        assertTrue(board.isEnded());
        assertEquals(board.getWinner(), Board.CELL_NONE);
    }
    @Test
    public void testIsEndedX() {
        System.out.println("test IsEndedX");
        
        board.applyMove(0); 
        board.applyMove(3);
        board.applyMove(1);
        board.applyMove(4);
        board.applyMove(2);
        
        assertTrue(board.isEnded());
        assertEquals(board.getWinner(), Board.CELL_X);
    }
    @Test
    public void testIsEndedO() {
        System.out.println("test IsEndedO");
       
        board.applyMove(2);
        board.applyMove(0); 
        board.applyMove(7);
        board.applyMove(6);
        board.applyMove(1);
        board.applyMove(3);
        
        assertTrue(board.isEnded());
        assertEquals(board.getWinner(), Board.CELL_O);
    }

    @Test
    public void testGetOpponentMark() {
        System.out.println("test getOpponentMark");
        
        
        assertEquals(Board.CELL_O, Board.getOpponentMark(Board.CELL_X));
        assertEquals(Board.CELL_X, Board.getOpponentMark(Board.CELL_O));
    }    
}
