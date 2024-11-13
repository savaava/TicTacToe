package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
    @Test
    public void testDefaultConstructor(){
        System.out.println("test constructor");
        TestUserInterface tui = new TestUserInterface();
        HumanPlayer hp1 = new HumanPlayer(Board.CELL_X, tui);        
        assertEquals(hp1.getMark(),Board.CELL_X);
        HumanPlayer hp2 = new HumanPlayer(Board.CELL_O, tui);        
        assertEquals(hp2.getMark(),Board.CELL_O);
    }

    @Test
    public void testMakeMove(){
        System.out.println("test makeMove");
        
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(4);
        Board boardCopy = new Board(board);
        
        TestUserInterface tui = new TestUserInterface();
        HumanPlayer hp = new HumanPlayer(Board.CELL_X, tui);
        tui.setNextMove(2);
        hp.makeMove(board);
        
        assertEquals(PlayerTestBase.move(boardCopy,board), 2);
    }
    
    @Test
    public void testNotifyResult() {
        TestUserInterface tui = new TestUserInterface();
        HumanPlayer hp = new HumanPlayer(Board.CELL_X, tui);
        assertFalse(tui.isResultShown());
        hp.notifyResult(Board.CELL_X);
        assertTrue(tui.isResultShown());
    }    
}
