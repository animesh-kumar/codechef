package codechef.challenge.rotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Runs in 3.05s
 * 
 * @author animesh
 *
 */
class FunWithRotationThirdAttempt {

	public static void main(String[] args) {
		// Stores the value of N, M respectively
		int n = 0, m = 0;
		String[] inputArray = null;
		ArrayList<String[]> queriesArrayList = new ArrayList<String[]>();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		// Read the values of n and m
		try {
			line = stdin.readLine();

			String[] input = line.split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			// Read the array
			line = stdin.readLine();
			input = line.split(" ");
			inputArray = input;

			// Read based on the count of the line
			int lineNumber = 0;
			while (lineNumber < m) {
				line = stdin.readLine();
				input = line.split(" ");
				queriesArrayList.add(input);
				lineNumber++;
			}
			int shift = 0;
			int pos = 1;
			for (String[] query : queriesArrayList) {
				// Parse the query. The query will have two elements ; first,
				// the
				// direction and second the number of times rotation has to be
				// done ie.,
				// d
				int d = Integer.parseInt(query[1]);

				String queryType = query[0];
				switch (queryType) {
				case "R":
				case "r":
					pos = d + shift;
					if (pos > n) {
						pos = pos - n;
					}
					System.out.println(inputArray[pos - 1]);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
