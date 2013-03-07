
import java.lang.Integer;

public class NameRecord {

	private int[] popList;
	private String name;
	
	public NameRecord(String nameAndPop){
		String[] parsedData = nameAndPop.split("\\s+");
		name = parsedData[0];
		popList = new int[parsedData.length-1]; 
		for(int index = 1; index < parsedData.length; index++){
			Integer popularity = new Integer(parsedData[index]);
			popList[index-1] = popularity;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int[] getAllRanks(){
		return popList;
	}
	
	public int getRank(int year){
		assert (year >= 0) && (year < popList.length): "Violation of Precondition: getRank";
		return popList[year];
	}
	
	public int getBestYear(){
		int maxPop = 1001;
		int year = 0;
		for(int index = 0; index < popList.length; index++){
			if(popList[index] != 0 && popList[index] <= maxPop){
				maxPop = popList[index];
				year = 1900 + (index * 10);
			}
		}
		return year;
	}
	
	public int getTimesRanked(){
		int number = 0;
		for(int index = 0; index < popList.length; index++){
			if(popList[index] != 0) number++;
		}
		return number;
	}
	
	public boolean getRankedAllYears(){
		return (this.getTimesRanked() == popList.length);
	}
	
	public boolean getRankedOnce(){
		return (this.getTimesRanked() == 1);
	}
	
	public boolean getMorePopular(){
		int maxPop = 1001;
		boolean isHigher = false;
		for(int index = 0; index < popList.length; index++){
			if(popList[index] < maxPop && popList[index] != 0){
				isHigher = true;
				maxPop = popList[index];
			}
			else if(popList[index] == 0 && !isHigher){
				isHigher = true;
			}	
			else if(isHigher){
				isHigher = false;
				break;
			}
		}
		return isHigher;
	}
	
	public boolean getLessPopular(){
		int leastPop = 0;
		boolean isLower = false;
		boolean passedOnce = false;
		for(int index = 0; index < popList.length; index++){
			if( popList[index] != 0 && popList[index] > leastPop){
				isLower = true;
				leastPop = popList[index];
			}
			else if(popList[index] == 0 && index < popList.length-1){
				isLower = false;
				break;
			}
			else if((popList[index] == 0) && (!passedOnce)){
				isLower = true;
				passedOnce = true;
			}	
			else if(isLower){
				isLower = false;
				break;
			}
		}
		return isLower;
	}
}
	
/* **********This is all Test code that was created to test NameRecord*************
 
 
 
	public static void main(String[] args) {
		
		NameRecord a1 = new NameRecord("mike 10 11 12 13 200 500 0");
		if(a1.getBestYear() == 1900){
			System.out.println("Passed test 1");
		}
		else{
			System.out.println("Did not pass 1");
		}

		NameRecord a2 = new NameRecord("mike 0 32 45 345 234 3 6");
		if(!a2.getLessPopular()){
			System.out.println("Passed test 2");
		}
		else{
			System.out.println("Did not pass 2");
		}

		NameRecord a3 = new NameRecord("mike 500 400 300 200 100 50 10");
		if(a3.getMorePopular()){
			System.out.println("Passed test 3");
		}
		else{
			System.out.println("Did not pass 3");
		}
		
		NameRecord a4 = new NameRecord("mike 10 11 12 13 200 500 0");
		if(!(a4.getName() == "scott")){
			System.out.println("Passed test 4");
		}
		else{
			System.out.println("Did not pass 4");
		}
		
		NameRecord a5 = new NameRecord("mike 100 500 0 0 0 300 200 800");
		if(!(a5.getRank(3) == 200)){
			System.out.println("Passed test 5");
		}
		else{
			System.out.println("Did not pass 5");
		}
		
		NameRecord a6 = new NameRecord("mike 100 200 300 400 500 600 700 800 900");
		if(a6.getRankedAllYears()){
			System.out.println("Passed test 6");
		}
		else{
			System.out.println("Did not pass 6");
		}
	}
}*/

