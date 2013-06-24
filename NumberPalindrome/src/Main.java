public class Main {
	public static void main(String[] args) {
		String max = "";
		for(int i = 0; i <=1000; i++) {
			String num = String.valueOf(i);
			if(num.equals(reverse(num)) && isPrime(num))
				max = num;
		}
		System.out.println(max);
	}
	
	public static String reverse(String num) {
		String reverse = "";
		if(num.isEmpty())
			return "";
		
		char[] numArr = num.toCharArray();
		for(int j = numArr.length-1; j >=0; j--) {
			reverse+=numArr[j];
		}
		return reverse;
	}
	
	public static boolean isPrime(String num) {
		int checkPrime = Integer.valueOf(num);
		for(int i=checkPrime-1; i >=2; i--){
			if(checkPrime%i==0)
				return false;
		}
		return true;
	}
}