import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String line = "";
		boolean isPalindrome = false;
		int iterations = 1;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			
			while((line = br.readLine())!= null) {
				while(isPalindrome == false) {
					int reverse = reverse(Integer.valueOf(line));
					int numToCheck = reverse + Integer.valueOf(line);
					
					if(numToCheck == reverse(numToCheck)) {
						System.out.println(iterations + " " + numToCheck);
						isPalindrome = true;
					}
					else {
						line = String.valueOf(numToCheck);
						iterations++;
					}
				}
				isPalindrome = false;
				iterations = 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static int reverse(int num) {
		String number = String.valueOf(num);
		char[] chars = number.toCharArray();
		String reverse = "";
		
		for(int i = chars.length-1; i >=0; i--) {
			reverse+=chars[i];
		}
		
		return Integer.valueOf(reverse);
	}
}