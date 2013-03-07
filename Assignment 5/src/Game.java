
public class Game {


    private boolean showCode;

    public Game(boolean easy){
        showCode = easy;
    }

    public void runGames(){
    Board newGame = new Board(showCode);
    	
    do{
    	char[] game = newGame.opponent(); 
    	newGame.guesser(game);
    }while(newGame.playAgain());
    
    }
}