package codechef.challenge.rotation;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used the Brute Force approach
 * Runs in 2.58s
 * 
 * @author animesh
 *
 */
class FunWithRotationSecondAttempt {

	public static void main(String[] args) {
		// Stores the value of N, M respectively
		int n = 0, m = 0;
		int[] inputArray = null;
		ArrayList<String[]> queriesArrayList = new ArrayList<String[]>();
		Scanner stdin = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);

		n = stdin.nextInt();
		m = stdin.nextInt();
		inputArray = new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i] = stdin.nextInt();
		}
		for (int j = 0; j < m; j++) {
			String regex = "[CcRrAa]";
			String[] query = new String[2];
			query[0] = stdin.next(regex);
			query[1] = String.valueOf(stdin.nextInt());
			queriesArrayList.add(query);
		}
		int shift = 0;
		int pos = 1;
		for (String[] query : queriesArrayList) {
			// Parse the query. The query will have two elements ; first,
			// the direction and second the number of times rotation has to be
			// done ie., d
			int d = Integer.parseInt(query[1]);

			String queryType = query[0];
			switch (queryType) {
			case "R":
			case "r":
				pos = d + shift;
				if (pos > n) {
					pos = pos - n;
				}
				pw.println(inputArray[pos - 1]);
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
