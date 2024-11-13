package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testConstructor(){
        System.out.println("test costruttore Game");
        TestUserInterface tui = new TestUserInterface();
        tui.setMark(Board.CELL_X); //sceglie X
        tui.setDiffLvl(5); //sceglie la difficoltà 5
        Game game = new Game(tui);
        
        Board board = new Board();
    }
    
    @Test
    public void testPlay() {
        System.out.println("test play");
        
    }

    @Test
    public void testMain() {
        System.out.println("test main");
    }    
}
