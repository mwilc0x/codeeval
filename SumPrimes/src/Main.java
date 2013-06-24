public class Main {
	public static void main(String[] args) {
		int sum = 5;
		int counter = 2;
		int primeTest = 4;
		boolean isPrime = true;
		
		while(counter < 1000) {
			for(int i = primeTest -1; i >=2; i--) {
				if(primeTest%i == 0) {
					isPrime=false;
					break;
				}
			}
			
			if(isPrime){
				sum+=primeTest;
				counter++;
			}
			else{
				isPrime = true;
			}
			primeTest++;
		}
		
		System.out.println(sum);
	}
}