
public class Code {
	
	private char[] guess, check, pegs;
	
	
	public Code(char[] first, char[] second){
	assert (first.length == second.length);
		guess = first;
		check = second;
		pegs = new char[guess.length];
	}
	
	public boolean compare(){
		boolean[] used = new boolean[guess.length];
		boolean win = true;
		char white = 'W';
		char black = 'B';
		int countBlack = 0;
		int countWhite = 0;
		
		for(int index = 0; index < guess.length; index++){
			if(guess[index] == check[index]) {
				pegs[countBlack] = black;
				countBlack++;
				used[index] = true;
			}
		}
		if(countBlack < 4){
			for(int guessIndex = 0; guessIndex < guess.length; guessIndex++){
				for(int checkIndex = 0; checkIndex < check.length; checkIndex++){
					if(guessIndex < guess.length && guess[guessIndex] == check[checkIndex] && !used[checkIndex]){
						if(guessIndex != checkIndex){
							pegs[countBlack + countWhite] = white;
							countWhite++;
							used[checkIndex] = true;
							break;
						}
					}
				}
			}			
		}
		if(pegs.length == check.length){
			for(int index = 0; index < pegs.length; index++){
				if(pegs[index] != 'B' && pegs.length == check.length){
					win = false;
					break;
				}
			}
		}
		else win = false;
		return win;		
		
	}
	
	public char[] getPegs(){
		return pegs;
	}
	
	public char getPegs(int location){
		return pegs[location];
	}
	
/*	public static void main(String[] args){
		
		char[] first1 = {'R', 'R', 'R', 'R'};
		char[] second2 = {'R', 'R', 'R', 'R'};
		Code test = new Code(first1, second2);
		System.out.println(test.compare());
		for(int i = 0; i < test.getPegs().length; i++){
			System.out.println(test.getPegs());
			System.out.println(test.getPegs(i));
		}
		
		first1 = {'Y', 'B', 'G', 'O'};
		second2 = {'O', 'G', 'B', 'Y'};
		test = new Code(first1, second2);
		System.out.println(test.compare());
		for(int i = 0; i < test.getPegs().length; i++){
			System.out.println(test.getPegs());
			System.out.println(test.getPegs(i));
		}
		
		first1 = {'Y', 'B', 'G', 'O'};
		second2 = {'R', 'R', 'R', 'R'};
		test = new Code(first1, second2);
		System.out.println(test.compare());
		for(int i = 0; i < test.getPegs().length; i++){
			System.out.println(test.getPegs());
			System.out.println(test.getPegs(i));
		}
		
		first1 = {'Y', 'B', 'B', 'O'};
		second2 = {'G', 'B', 'G', 'B'};
		test = new Code(first1, second2);
		System.out.println(test.compare());
		for(int i = 0; i < test.getPegs().length; i++){
			System.out.println(test.getPegs());
			System.out.println(test.getPegs(i));
		}
	}*/

}