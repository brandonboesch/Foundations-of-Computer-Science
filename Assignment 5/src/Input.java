import java.util.Scanner;

public class Input {

	private char[] choice;
	private int opponent;
	private Scanner keyboard;
	
	
	public Input(){
		keyboard = new Scanner(System.in);
	}
	
	public void getInput(){
		String guess = keyboard.nextLine();
		choice = new char[guess.length()];
		for(int index = 0; index < guess.length(); index++){
			choice[index] = guess.charAt(index);
		}
	}
	
	public void getIntInput(){
		opponent = keyboard.nextInt();
	}
	
	public boolean errorCheck(){
		boolean isCorrect = false;
		char[] colorChoice = colorList();
		int count = 0;
		if (choice.length == 4){
			for(int index = 0; index < choice.length; index++){
				for(int colorsIndex = 0; colorsIndex < colorList().length; colorsIndex++){
					if(choice[index] == colorChoice[colorsIndex])
						count++;
				}
			}
		}
		if (count == 4)
			isCorrect = true;
		return isCorrect;
	}
	
	public boolean errorIntCheck(){
		return (opponent == 1 || opponent == 2);
	}
	
	public char[] colorList(){
		/*
		 * B = Blue
		 * G = Green
		 * O = Orange
		 * P = Purple
		 * R = Red
		 * Y = Yellow
		 */
		char[] colors = {'B', 'G', 'O', 'P', 'R', 'Y'};
		return colors;
	}
	
	public char[] getOutput(){
		return choice;
	}
	
	public int getIntOutput(){
		return opponent;
	}
	
/*
	public static void main(String[] args){
		Input things = new Input();
		things.getInput();
		System.out.println(things.errorCheck());
		things.getIntInput();
		System.out.println(things.errorIntCheck());
		for (int i = 0; i < things.colorList(); i++){
			System.out.println(things.colorList()[i];
			System.out.println(things.getOutput()[i]);
			System.out.println(things.getIntOutput());
		}
		
	}*/

}