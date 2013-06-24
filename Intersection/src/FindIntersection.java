import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FindIntersection {
	
	public static ArrayList<String> storeWords(String filepath) {
		ArrayList<String> list = new ArrayList<String>();
		Path path = Paths.get(filepath);
		
		/* Traverse file and store words */
	    try (Scanner scanner =  new Scanner(path)){
	        while (scanner.hasNextLine()){
	          //process each line in some way
	          list.add(scanner.nextLine());
	        }      
	      } catch (IOException e) {
			e.printStackTrace();
		}
	    
		return list;
	}
	
	public static ArrayList<String> checkIntersection(String filepath, ArrayList<String> firstList) throws IOException {
		ArrayList<String> intersection = new ArrayList<String>();
		Path path = Paths.get(filepath);
 
		// Traverse file and check against the first list
		// Store words that match in new intersection list
	    try (Scanner scanner =  new Scanner(path)){
	        while (scanner.hasNextLine()){
	          String line = scanner.nextLine();
	          
	          if(firstList.contains(line)) {
	        	  intersection.add(line);
	          }
	        }      
	      }
		return intersection;
	}
	
	public static void main(String[] args) {
		ArrayList<String> one = storeWords("/home/mike/Jargon");
		ArrayList<String> intersection = new ArrayList<String>();
		
		try {
			intersection = checkIntersection("/home/mike/Jargon2", one);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!intersection.isEmpty()) {
			System.out.println("We have matches!");
		}
	}
}
