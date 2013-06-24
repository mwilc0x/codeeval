import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				ArrayList<String> listOne = getFirstSet(line);
				ArrayList<String> listTwo = getSecondSet(line);
				
				ArrayList<String> intersect = getIntersection(listOne, listTwo);
				print(intersect);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try{
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<String> getIntersection(ArrayList<String> one, ArrayList<String> two) {
		ArrayList<String> intersect = new ArrayList<String>();
		
		for(int i = 0; i < two.size(); i++) {
			if(one.contains(two.get(i))) {
				intersect.add(two.get(i));
			}
		}
		return intersect;
	}
	
	public static void print(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size()-1) {
				System.out.println(list.get(i));
			}
			else {
				System.out.print(list.get(i) + ",");
			}
		}
	}
	
	public static ArrayList<String> getFirstSet(String line) {
		List<String> list = Arrays.asList(line.split(";"));
		
		String firstSet = list.get(0);		
		return new ArrayList(Arrays.asList(firstSet.split(",")));
	}
	
	public static ArrayList<String> getSecondSet(String line) {
		List<String> list = Arrays.asList(line.split(";"));
		
		String firstSet = list.get(1);		
		return new ArrayList(Arrays.asList(firstSet.split(",")));
	}
}
