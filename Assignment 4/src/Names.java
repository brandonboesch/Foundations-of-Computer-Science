import java.util.ArrayList;
import java.util.Scanner;

public class Names {

	private ArrayList<NameRecord> listOfNames;
	
	public Names(Object fileScanner){
		assert (fileScanner != null): "Violation of Precondition: Names()";
		String line;
		listOfNames = new ArrayList<NameRecord>();
		while( ((Scanner) fileScanner).hasNextLine() ){
			line = ((Scanner) fileScanner).nextLine();
			NameRecord record = new NameRecord(line);
			listOfNames.add(record);
		}
		
	}

	public ArrayList<NameRecord> searchForNames(String search){
		ArrayList<NameRecord> matches = new ArrayList<NameRecord>();
		for(int index = 0; index < listOfNames.size(); index++){	
			if(listOfNames.get(index).getName().toLowerCase().contains(search)){
				matches.add(listOfNames.get(index));
			}
		}
		if(matches.isEmpty()) return null;
		else return matches;
	}
	
	public NameRecord searchOneName(String search){
		NameRecord matches = new NameRecord("");
		boolean matchThere = false;
		for(int index = 0; index < listOfNames.size(); index++){	
			if(listOfNames.get(index).getName().toLowerCase().matches(search)){
				matches = listOfNames.get(index);
				matchThere = true;
				break;
			}
		}
		if (matchThere) return matches;
		else return null;
	}
	
	public ArrayList<String> RankedAllDecades(){
		ArrayList<String> names = new ArrayList<String>();
		for(int index = 0; index < listOfNames.size(); index++){
			if(listOfNames.get(index).getRankedAllYears()){
				names.add(listOfNames.get(index).getName());
			}
		}
		return names;
	}
	
	public ArrayList<String> RankedOneDecade(){
		ArrayList<String> names = new ArrayList<String>();
		for(int index = 0; index < listOfNames.size(); index++){
			if(listOfNames.get(index).getRankedOnce()){
				names.add(listOfNames.get(index).getName());
			}
		}
		return names;
	}
	
	public ArrayList<String> RankedMorePop(){
		ArrayList<String> names = new ArrayList<String>();
		for(int index = 0; index < listOfNames.size(); index++){
			if(listOfNames.get(index).getMorePopular()){
				names.add(listOfNames.get(index).getName());
			}
		}
		return names;
	}
	
	public ArrayList<String> RankedLessPop(){
		ArrayList<String> names = new ArrayList<String>();
		for(int index = 0; index < listOfNames.size(); index++){
			if(listOfNames.get(index).getLessPopular()){
				names.add(listOfNames.get(index).getName());
			}
		}
		return names;
	}
	
//  This method lists all the names that were ranked more popular and Ranked in all decades.
	
	public ArrayList<String> RankedMorePopAndAllYears(){
		ArrayList<String> names = new ArrayList<String>();
		for(int index = 0; index < listOfNames.size(); index++){
			if(listOfNames.get(index).getMorePopular() && listOfNames.get(index).getRankedAllYears()){
				names.add(listOfNames.get(index).getName());
			}
		}
		return names;
	}
}
