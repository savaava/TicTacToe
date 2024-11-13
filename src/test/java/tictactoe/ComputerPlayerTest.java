package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testDefaultConstructor(){
        System.out.println("test constructor");
        ComputerPlayer cp1 = new ComputerPlayer(Board.CELL_X,2);
        assertEquals(cp1.getMark(), Board.CELL_X);
        
        ComputerPlayer cp2 = new ComputerPlayer(Board.CELL_O,2);
        assertEquals(cp2.getMark(), Board.CELL_O);
    }
    
    @Test
    public void testMakeMove0(){
        System.out.println("test makeMove lvl 0");
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(4);
        Board boardCopy = new Board(board);
        ComputerPlayer cp = new ComputerPlayer(Board.CELL_X, 0);
        cp.makeMove(board);
        
        int move = PlayerTestBase.move(boardCopy, board);
        assertTrue(
                move==1 ||
                move==2 ||
                move==3 ||
                move==5 ||
                move==6 ||
                move==7 ||
                move==8);
    }
    
    @Test
    public void testMakeMove1(){
        System.out.println("test makeMove lvl 1");
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(2);
        board.applyMove(6);
        board.applyMove(4);
        Board boardCopy = new Board(board);
        ComputerPlayer cp = new ComputerPlayer(Board.CELL_X, 1);
        cp.makeMove(board);
        
        int move = PlayerTestBase.move(boardCopy, board);
        assertTrue(move==3);
    }
    
    @Test
    public void testMakeMove2(){
        System.out.println("test makeMove lvl 2");
        Board board = new Board();
        board.applyMove(0);
        board.applyMove(2);
        board.applyMove(3);
        board.applyMove(7);
        board.applyMove(1);
        Board boardCopy = new Board(board);
        ComputerPlayer cp = new ComputerPlayer(Board.CELL_O, 2);
        cp.makeMove(board);
        
        int move = PlayerTestBase.move(boardCopy, board);
        assertTrue(move==6);
    }
    
    @Test
    public void testMakeMove3(){
        System.out.println("test makeMove lvl 3");
        Board board = new Board();
        board.applyMove(4);
        board.applyMove(2);
        board.applyMove(6);
        board.applyMove(7);
        Board boardCopy = new Board(board);
        ComputerPlayer cp = new ComputerPlayer(Board.CELL_X, 3);
        cp.makeMove(board);
        
        int move = PlayerTestBase.move(boardCopy, board);
        assertTrue(move==0 || move==3);
    } 
}
