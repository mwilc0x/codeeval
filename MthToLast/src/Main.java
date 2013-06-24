import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				if(line.isEmpty()) {
					continue;
				} else {
					String m = line.substring(line.length()-1, line.length());
					String list = line.substring(0, line.length()-2);
					String out = getMthLast(list, m);
					
					if(!out.isEmpty())
						System.out.println(out);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getMthLast(String line, String size) {
		ArrayList<String> list = new ArrayList(Arrays.asList(line.split(" ")));
		int m = Integer.valueOf(size);
		
		if(m > list.size())
			return " ";
		
		return list.get(list.size()-m);
	}
}