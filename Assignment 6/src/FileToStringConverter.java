import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JFileChooser;

public class FileToStringConverter {

	private String fileAsString;
	
	/**
	 * Pick a new File and convert it to a String.
	 */
	public void chooseNewFile(){
		// create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
	    StringBuffer text = new StringBuffer();
	    int retval = chooser.showOpenDialog(null);

	    chooser.grabFocus();

	    //read in the file
		if (retval == JFileChooser.APPROVE_OPTION)
		{   File source = chooser.getSelectedFile();
			try
			{   Scanner s = new Scanner( new FileReader( source ) );

				while( s.hasNextLine() )
				{   text.append( s.nextLine() );
					text.append(" ");
				}

				s.close();
			}
			catch(IOException e)
			{   System.out.println("An error occured while trying to read from the file: " + e);
			}
		}

		fileAsString = text.toString();
	}
	
	/**
	 * Get the selected File as a String.
	 * @return the selected File as a String.
	 */
	public String getFileAsString(){
		return fileAsString;
	}
	
	/**
	 * Return the "words" from the file. Words are any collection of characters seperated by whitespace.
	 * This leads to some non standard "words". For example: <tt>"No,</tt> could be a word with 
	 * the quote and comma included.
	 * @return the words in the file.
	 */
	public String[] getWords(){
		return fileAsString.split("\\s+");
	}

}
