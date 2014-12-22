import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Runs in 2.31 - 2.35s
 * 
 * @author animesh
 *
 */
public class ChefAndSegment {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			double x = in.nextDouble();
			long k = in.nextLong();
			// Here assume at the start i.e.,k=1, there will be
			// only one division in the middle.
			// At k = 2, there will be one division at the center and then
			// there are two halves. The second mid point can be kept
			// in either of the halves. But as per the question,
			// it has to be kept in left most half.
			// At k = 3, the second half is still undivided and is hence the
			// longest segment which will be now divided into another two.
			// At k = 4, we have total 4 equal parts with us. And hence,
			// we can put the midpoint in the first quarter (left-most)
			// This is forming a pattern where the number of divisions
			// are growing on Power of 2 (2,4,8,16,32...)
			// At each 2^a (a=0,1,2..), the line is divided into equal parts.
			// And the midpoint will be at X/ (2*2^a) - Hence the modulo == 0
			// We have an additional multiplicative 2 since we have to find
			// midpoint of that given segment.
			// For k between 2^a +1 to 2^(a+)-1 we first find out,
			// how much far is it from 2^a as those segments are already
			// covered and hence mid*modulo and then find the mid of the
			// next segment.
			double mid = 0;
			double lengthOfEachSegment = 0;
			long logBaseOf2 = logOfBase(2, k);
			long modulo = k % power(2, logBaseOf2);
			if (modulo == 0) {
				mid = x / (2 * k);
			} else {
				// find the length of each line
				// segment
				lengthOfEachSegment = x / power(2, logBaseOf2);
				// Find the mid-point value of the given segment.
				mid = x / power(2, logBaseOf2 + 1);
				// Mark where the line will be put based on the modulo.
				mid = mid + modulo * lengthOfEachSegment;
			}
			pw.println(mid);
		}
		in.close();
		pw.close();
	}

	public static long logOfBase(int base, long num) {
		return (long) (Math.log(num) / Math.log(base));
	}

	static long power(long base, long powr) {
		if (powr == 0)
			return 1;
		return base * power(base, --powr);
	}
}
