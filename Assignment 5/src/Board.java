import java.util.ArrayList;


public class Board {
	
	private boolean easyMode = false;
	
	public Board(boolean easy){
		easyMode = easy;
		System.out.println("Welcome to Mastermind.\n\n");
		System.out.println("This is a text version of the classic board game Mastermind.\n" +
						   "The computer will think of a secret code.\n" +
						   "The code consists of 4 colored pegs.\n" +
						   "The pegs may be one of six colors: blue, green, orange, purple, red, or yellow.\n" +
						   "A color may appear more than once in the code.\n");
		System.out.println("You try to guess what colored pegs are in the code and what order they are in\n"+
						   "After making a guess the result will be displayed.\n"+
						   "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n"+
						   "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n");
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
						   "When entering guesses you only need to enter the first character of the color as a capital letter.\n");
		System.out.println("You have 12 tries to guess the answer or you lose the game.");
	}
	
	
	
	public char[] opponent(){
		Input opponent = new Input();
		Input code = new Input();
		Player nemesis = new Player();
		char[] secret;
		
		do{
			System.out.print("\nEnter 1 for Computer Opponent or 2 for Human Opponent: ");
			opponent.getIntInput();
		}while(!opponent.errorIntCheck());
		
		if(opponent.getIntOutput() == 1){
			nemesis.computerPlayer();
			System.out.println("Generating Secret code .....");
			secret = nemesis.getOutputCode();
		}
		else{			
//			nemesis.humanPlayer();			
			do{
			System.out.print("Enter a Secret code: ");
			code.getInput();
			}while(!code.errorCheck());
			secret = code.getOutput();
		}
		return secret;
			
	}

	
	public void guesser(char[] secret){
        Input guess = new Input();
		Player guesser = new Player();
        String secretCode = new String();
        String currentGuess =  new String();
        String check = new String();
        ArrayList<String> guesses = new ArrayList<String>(0);
        int count = 0;     
        
        for(int index = 0; index < secret.length; index++){
        	secretCode += secret[index];
        }
        do {
        	if(easyMode)System.out.println("the code is: " + secretCode);
        	System.out.println("\nYou have " + (12 - count) + " guesses remaining.");


        	do{
        		System.out.println("Type in the characters for your guess and press enter.");
        		System.out.print("Enter guess: ");
        		guess.getInput();
        	}while(!guess.errorCheck());
        	guesser.humanPlayer(guess);    
        	
        	Code checker = new Code(guesser.getOutputCode(), secret);
        	checker.compare();

        	for(int index = 0; index < guesser.getOutputCode().length; index++){
        		currentGuess += guesser.getOutputCode(index);
        		check += checker.getPegs(index);
        	}  
        	guesses.add(currentGuess + " Result: " + check);
      	
        	for (int index = 0; index <= count; index++)
        		System.out.println(guesses.get(index));
        	for (int dots = 11 - count; dots > 0; dots--)
        		System.out.println("....");
        	if (checker.compare()){
        		System.out.println("You won the game! Good job.");
        		break;
        	}
        	count++;
        	currentGuess = "";
        	check = "";
        }
        while (count < 12);

        
        if(count == 12) System.out.println("Sorry you lost the game.");
        System.out.println("");
	}
	
	public boolean playAgain(){
		boolean result = false;
		Input again = new Input();
		do{
			System.out.println("Enter 1 to play another game or 2 to quit.");
			again.getIntInput();
		}while(!again.errorIntCheck());
		if(again.getIntOutput() == 1)
			result = true;
		return result;
	}
}

	
	
	/*
	public void guesser(){
		Player guesser = new Player();
		Input data = new Input();
		guesser.humanPlayer(data);
		System.out.println(this.playAgain());
}*/