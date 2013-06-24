import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			while((line = br.readLine()) != null) {
				ArrayList<Character> list = getDelims(line);
				String result = Scrub(line, list);
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String Scrub(String line, ArrayList<Character> delims) {
		String out = "";
		String temp = line.substring(0, line.indexOf(','));
		temp.trim();
		char[] chars = temp.toCharArray();
		
		for(int k = 0; k < chars.length; k++) {
			if(!delims.contains(chars[k])) {
				out+=chars[k];
			}
			else if(chars[k] == ' ') {
				out+=" ";
			}
		}
		return out;
	}
	
	public static ArrayList<Character> getDelims(String line) {
		char[] chars;
		int commaIndex = line.indexOf(',');
		
		if(commaIndex == -1)
			return null;
		
		String delims = line.substring(commaIndex+1, line.length());
		delims.trim();
		chars = delims.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(int i = 0; i < chars.length; i++) {
			list.add(chars[i]);
		}
		return list;
	}
}