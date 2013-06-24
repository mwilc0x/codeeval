
public class SolveFibN {
	public static int fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		int result = fib(9);
		System.out.println("Result of 10 is " + result);
	}
}