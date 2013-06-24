import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		
		try {
			while((line = br.readLine()) != null) {
				char out = findFirstNonRepeat(line);
				
				if(out != '0')	
					System.out.println(out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static char findFirstNonRepeat(String line) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = line.toCharArray();
		char out = 0;
		
		if(line.isEmpty())
			return out;
		
		for(int i = 0; i < chars.length; i++) {
			if(map.get(chars[i]) == null) {
				map.put(chars[i], 1);
			}
			else {
				int count = map.get(chars[i]);
				map.put(chars[i], count++);
			}
		}
		
		for(int j = 0; j < chars.length; j++) {
			if(map.get(chars[j]) == 1) {
				out = chars[j];
				break;
			}
		}
		
		return out;
	}
}
