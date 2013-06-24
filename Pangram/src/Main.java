import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static HashMap<Character, Boolean> hashMap;
	
	public static void main(String[] args) {
		BufferedReader br = null;
		String line = "";
		String out = "";
		
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				out = getMissingLetters(line);
				
				if(out.isEmpty())
					out = null;
				
				System.out.println(out);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static String getMissingLetters(String sentence) {
		char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		HashMap lettersMap = new HashMap();
		String missingLetters = "";
		
		// put chars into HashMap and mark each value as false, we will mark them off as true while going through the string
		for(int k = 0; k < chars.length; ++k) {
			lettersMap.put(chars[k], false);
		}
		
		// Now we will iterate through the string and check each letter, marking it's bucket in the HashMap as true
		// if the char is present
		for(int l = 0; l < sentence.length(); ++l) {
			char letter = sentence.charAt(l);
			lettersMap.put(letter, true);
		}
		
		// Now iterate through the HashMap checking each key (alpha letter) and check if that key's value
		// is true, if it is then we just keep going, otherwise we append that character to the missingChars
		// string that we will report back to the user with 
		for(int m = 0; m < chars.length; ++m) {
			boolean value = (Boolean) lettersMap.get(chars[m]);
			if(!value) {
				missingLetters += chars[m];
			}
		}
		
		return missingLetters;
	}
}