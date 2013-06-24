import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreandCheck {
	public static ArrayList<String> storeWords(String filepath) {
		ArrayList<String> list = new ArrayList<String>();
		Path path = Paths.get(filepath);
		
		/* Traverse file and store words */
	    try (Scanner scanner =  new Scanner(path)){
	        while (scanner.hasNextLine()){
	          //process each line in some way
	          list.add(scanner.nextLine().toLowerCase());
	        }      
	      } catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getWordsWithSpaces(String nospaces, ArrayList<String> words) {
		String spaced = "";
		String temp = "";
		
		for(int i = 0; i < nospaces.length(); i++) {
			temp += nospaces.charAt(i);
			
			if(words.contains(temp.toLowerCase())) {
				spaced += temp + " ";
				temp = "";
			}
		}
		return spaced;
	}
	
	public static void main(String[] args) {
		String input = "PeanutButter";
		ArrayList<String> words = storeWords("/home/mike/Jargon");
		String spacedWords = getWordsWithSpaces(input, words);
		
		System.out.println(spacedWords);
	}
}