package codechef.challenge.rotation;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Runs in 2.27s
 * 
 * @author animesh
 *
 */
class FunWithRotationFinalSubmission {

	public static void main(String[] args) {
		// Stores the value of N, M respectively
		int n = 0, m = 0;
		int[] inputArray = null;
		Scanner stdin = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);

		n = stdin.nextInt();
		m = stdin.nextInt();
		inputArray = new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i] = stdin.nextInt();
		}
		int shift = 0;
		int pos = 1;
		for (int j = 0; j < m; j++) {
			String regex = "[CcRrAa]";
			String queryType = stdin.next(regex);
			int d = stdin.nextInt();
			switch (queryType) {
			case "R":
			case "r":
				pos = d + shift;
				if (pos > n) {
					pos = pos - n;
				}
				pw.println(inputArray[pos - 1]);
				// System.out.println(inputArray[pos - 1]);
				break;
			case "C":
			case "c":
				// For clockwise the rotation will take position to the
				// right in the array after every rotation
				shift = shift + d;
				if (shift > n) {
					shift = shift - n;
				}
				break;
			case "A":
			case "a":
				// For anticlockwise the rotation will take position to the
				// left in the array after every rotation
				shift = shift - d;
				if (shift < 1) {
					shift = shift + n;
				}
				break;
			}
		}
		stdin.close();
		pw.close();
	}
}
