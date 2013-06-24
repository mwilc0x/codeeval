import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String line = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine()) != null) {
				ArrayList<Integer> list = getPrimes(Integer.valueOf(line));
				
				for(int i = 0; i < list.size(); i++) {
					if(i == list.size()-1) {
						System.out.println(list.get(i));
					}
					else {
						System.out.print(list.get(i) + ",");
					}
				}
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
	
	public static ArrayList<Integer> getPrimes(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(num < 2) {
			return null;
		}
		else if(num == 3) {
			list.add(2);
			return list;
		}
		else {
			boolean isPrime = true;
			list.add(2);
			for(int i = 3; i < num; i+=2) {
				for(int j = i-1; j >= 2; j--) {
					if(i%j==0) {
						isPrime = false;
						break;
					}
				}
				
				if(isPrime) {
					list.add(i);
				}
				else {
					isPrime = true;
				}
			}
		}
		return list;
	}
}