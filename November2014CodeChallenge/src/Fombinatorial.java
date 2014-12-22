import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Fombinatorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);
		long t = in.nextLong(); // Number of test cases
		// loop over all test cases
		for (long i = 0; i < t; i++) {
			long n = in.nextLong(); // N value
			long m = in.nextLong(); // Modulo value
			long q = in.nextLong(); // Q is number of r values that have to come
			// Read all the r values
			for (long j = 0; j < q; j++) {
				long r = in.nextLong();
				// Calculate the difference between n and r
				long diff = n - r;
				// Formula F(n) / F(r) * F(N-r)
				long divisor1 = 1;// Use them to reduce the calculations
				long divisor2 = 1;
				long product = 1;
				for (long k = 2; k <= n; k++) {
					product = product * power(k, k);
					if (k == r) {
						divisor1 = product;
					} else if (k == diff) {
						divisor2 = product;
					}
				}
				// Calculate the quotient
				long quotient = product / divisor1;
				quotient = quotient / divisor2;
				long result = quotient % m;
				pw.println(result);
			}

		}

		in.close();
		pw.close();
	}

	static long power(long base, long powr) {
		if (powr == 0)
			return 1;
		return base * power(base, --powr);
	}

}