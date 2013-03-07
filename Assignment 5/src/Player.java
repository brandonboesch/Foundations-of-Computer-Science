import java.util.Random;
public class Player {
	
	
	private char [] playerCode;
	
	public Player(){
		
		//Change lengthOfCode to change the length of the code
		
		int lengthOfCode = 4;
		playerCode = new char[lengthOfCode];
	}
	
	public void humanPlayer(Input data){
		Input keyboard = data;
		playerCode = keyboard.getOutput();
	}
	
	public void computerPlayer(){
		Random RNG = new Random();
		Input colors = new Input();
		
		for(int index = 0; index < playerCode.length; index++){
			playerCode[index] = colors.colorList()[RNG.nextInt(colors.colorList().length)];
		}
	}
	
	public char[] getOutputCode(){
		return playerCode;
	}
	
	public char getOutputCode(int location){
		return playerCode[location];
	}
	 
/*	public static void main(String[] args){
		Player human = new Player();
		Input data = new Input();
		human.humanPlayer(data);
		Player computer = new Player();
		computer.computerPlayer();
		for(int i = 0; i < human.getOutputCode.length(); i++)
			System.out.println(human.getOutputCode()[i]);
		System.out.println(computer.getOutputCode());

	
	}
	*/

}