import java.io.File;
import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*  Student information for assignment

 *  On my honor, <NAME>
 *  this programming assignment is my own work.
*
*  Student info.
*  Name: Zachary Tschirhart
*  EID: zst75
*  email address: ztschir@gmail.com
*  TA name: Xiuming
*  Unique course ID: 54022
*
*  programming hours: 10
*  Lines of Code: 300
*/

//slip days info
/*
Slip days used on this assignment: 0
Slip days I think I have used for the term thus far 0
*/

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int MORE_POP_ALL_DEC = 7;
	public static final int QUIT = 8;

	// main method. Driver for the whole program
	public static void main(String[] args) {
		try {
			Scanner fileScanner = new Scanner( getFile() );
			Names n = new Names(fileScanner);
			int choice;
			Scanner keyboard = new Scanner(System.in);
			fileScanner.close();
			do{
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else if( choice == MORE_POPULAR )
					morePop(n);
				else if( choice == LESS_POPULAR )
					lessPop(n);
				else if( choice == MORE_POP_ALL_DEC )
					morePopAllDecades(n);
				else
					System.out.println("\n\nGoodbye.");

			}while( choice != QUIT);
		}
		catch(FileNotFoundException e){
			System.out.println("Problem reading the data file. Exiting the program.");
		}
	}

	private static void morePop(Names n) {
		ArrayList<String> found = n.RankedMorePop();
		if(found != null){
			System.out.print(found.size() + " names are more popular in every decade. \n \n");
			for(int i = 0; i < found.size(); i++) 
				System.out.print(found.get(i) + "\n");
			System.out.println("");
		}
		else System.out.println("There were no names that met the critera.");
	}	
	
	private static void lessPop(Names n) {
		ArrayList<String> found = n.RankedLessPop();
		if(found != null){
			System.out.print(found.size() + " names are less popular in every decade. \n \n");
			for(int i = 0; i < found.size(); i++) 
				System.out.print(found.get(i) + "\n");
			System.out.println("");
		}
		else System.out.println("There were no names that met the critera.");
	}
	
	private static void morePopAllDecades(Names n) {
		ArrayList<String> found = n.RankedMorePopAndAllYears();
		if(found != null){
			System.out.print(found.size() +
					" names are more popular in every decade and were ranked in every decade. \n \n");
			for(int i = 0; i < found.size(); i++) 
				System.out.print(found.get(i) + "\n");
			System.out.println("");
		}
		else System.out.println("There were no names that met the critera.");
	}
	
	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		ArrayList<String> found = n.RankedAllDecades();
		if(found != null){
			System.out.print(found.size() + " names appear in every decade. The names are: \n \n");
			for(int i = 0; i < found.size(); i++) 
				System.out.print(found.get(i) + "\n");
			System.out.println("");
		}
		else System.out.println("There were no names that met the critera.");
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		ArrayList<String> found = n.RankedOneDecade();
		if(found != null){
			System.out.print(found.size() + " names appear in exactly one decade. The names are: \n \n");
			for(int i = 0; i < found.size(); i++) 
				System.out.print(found.get(i) + "\n");
			System.out.println("");
		}
		else System.out.println("There were no names that met the critera.");

	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out data for one name, or print a message
	// indicating that the name has never been ranked"
	private static void oneName(Names n, Scanner keyboard) {
		System.out.print("Enter a name: ");
		String search = keyboard.next().toLowerCase();
		NameRecord found = n.searchOneName(search);
		if(found != null){
			System.out.print(found.getName() + ": ");
			for(int i = 0; i < found.getAllRanks().length; i++) 
				System.out.print(found.getAllRanks()[i] + " ");
			System.out.println("");
			for(int i = 0; i < found.getAllRanks().length; i++){
				System.out.println((1900 + (i * 10) + ":" + 
						found.getAllRanks()[i]));
			}
		}
		else System.out.println(search + " does not appear in any decade.");
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data
	private static void search(Names n, Scanner keyboard) {
		System.out.print("Enter a partial name: ");
		String search = keyboard.next().toLowerCase();
		ArrayList<NameRecord> found = n.searchForNames(search);
		if(found != null){
			System.out.println("\nThere are " + found.size() + " matches for " + search);
			System.out.println("The matches with their highest ranking decade are:\n");
			for(int i = 0; i < found.size(); i++){
				System.out.println(found.get(i).getName() + " " + found.get(i).getBestYear());
			}
		}
		else System.out.println(search + " does not appear in any decade.");
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt){
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }
    
    
    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter 1 to search for names.");
		System.out.println("Enter 2 to display data for one name.");
		System.out.println("Enter 3 to display all names that appear in only one decade.");
		System.out.println("Enter 4 to display all names that appear in all decades.");
		System.out.println("Enter 5 to display all names that are more popular in every decade.");
		System.out.println("Enter 6 to display all names that are less popular in every decade.");
		System.out.println("Enter 7 to display all names that are more popular and ranked every decade.");
		System.out.println("Enter 8 to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */
    public static File getFile(){
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}
