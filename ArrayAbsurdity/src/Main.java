import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				if(line.isEmpty()) {
					continue;
				} else {
					int size = getSize(line);
					String numbers = splitSemicolon(line);
					System.out.println(findDup(numbers, size));
				}
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
	
	public static int findDup(String line, int size) {
		HashMap<String, Integer> map = new HashMap<String, Integer>(size);
		List<String> list = Arrays.asList(line.split(","));
		int dup = -1;
		
		for(int i = 0; i < list.size(); i++) {
			if(map.get(list.get(i)) != null) {
				dup = Integer.valueOf(list.get(i));
				break;
			}
			else {
				map.put(list.get(i), 1);
			}
		}
		return dup;
	}
	
	public static int getSize(String line) {
		List<String> list = Arrays.asList(line.split(";"));
		return Integer.valueOf(list.get(0));
	}
	
	public static String splitSemicolon(String line) {
		List<String> list = Arrays.asList(line.split(";"));
		return list.get(1);
	}
}