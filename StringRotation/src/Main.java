import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				List<String> list = Arrays.asList(line.split(","));
				HashMap<Character, Integer> map = Store(list.get(0).trim());
				System.out.println(CheckChars(map, list.get(1).trim()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean CheckChars(HashMap<Character, Integer> map, String line) {
		char[] chars = line.toCharArray();
		boolean hasAllChars = true;
		
		for(int i = 0; i < chars.length; i++) {
			if(map.get(chars[i]) == null) {
				hasAllChars = false;
				break;
			}
			else {
				int num = map.get(chars[i]);
				
				if(num == 0) {
					return false;
				}
				else {
					map.put(chars[i], num--);
				}
			}
		}
		return hasAllChars;
	}
	
	public static HashMap<Character, Integer> Store(String line){
		char[] chars = line.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < chars.length; i++) {
			if(map.get(chars[i]) != null) {
				
				System.out.println("putting in " + chars[i] + " for a dup time");
				map.put(chars[i], map.get(chars[i]++));
			}
			else {
				System.out.println("putting in " + chars[i] + " for the first time");
				map.put(chars[i], 1);
			}
		}
		return map;
	}
}