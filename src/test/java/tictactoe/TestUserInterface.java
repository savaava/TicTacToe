package tictactoe;

public class TestUserInterface extends UserInterface {
    private int nextMove;
    private boolean resultShown = false;
    private boolean boardShown = false;
    private int diffLvl;
    private int mark;
    
    public void setNextMove(int newMove){ /* per simulare l'imput dell'utente */
        nextMove = newMove;
    }
    
    @Override
    public int askMove(Board board){
        return nextMove;
    }
    
    public boolean isResultShown() {
        return resultShown;
    }
    
    @Override
    public void showResult(String message) {
        resultShown=true;
    }
    
    /* --per GameTest-- */
    /* per costruttore */
    public void setMark(int mark){
        this.mark = mark;
    }
    
    @Override
    public int askMark() {
        return mark;
    }
    
    /* per costruttore */
    public void setDiffLvl(int newLvl){
        diffLvl = newLvl;
    }
    
    @Override
    public int askDifficultyLevel(int maxLevel){
        return diffLvl;
    }
    
    /* per play */
    public boolean isBoardoShown(){
        return boardShown;
    }
    
    @Override
    public void showBoard(Board board){
        boardShown = true;
    }
}
