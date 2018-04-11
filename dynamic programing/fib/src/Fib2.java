import java.math.BigInteger;
import java.util.Scanner;

public class Fib2 {
	public static BigInteger count = BigInteger.ZERO;

	public static BigInteger[] fibs;

	public static void main(String[] args) {
		int n;
		
		System.out.print("Enter n for which you want Fib(n) computed: ");
		
		Scanner keys = new Scanner(System.in);
		
		n = keys.nextInt();
		
		keys.close();

		fibs = new BigInteger[n + 1];
		
		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				fibs[i] = BigInteger.ONE;
			}
			else {
				fibs[i] = fibs[i - 1].add(fibs[i - 2]);

				count = count.add(BigInteger.ONE);
			}
		}

		System.out.println("Fib at that n is " + fibs[n]);
		
		System.out.println("Took " + count + " adds");
		

	}
	
}
