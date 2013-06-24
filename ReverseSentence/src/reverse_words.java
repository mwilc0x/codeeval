import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class reverse_words {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			String line;
			br = new BufferedReader(new FileReader(args[0]));
			
			
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					System.out.println(Reverse(line));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static String Reverse(String line) {
		String result = "";
		
		String[] splited = line.split("\\s+");
		
		for(int i = splited.length-1; i >=0; i--) {
			if(!result.isEmpty())
				result+=" " + splited[i];
			else
				result+= splited[i];
		}
		return result;
	}
}
