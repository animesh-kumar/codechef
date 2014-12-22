import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Palindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			// Read all the test cases
			String str = in.next();
			// Convert to character array for palindrome processing
			char[] charArray = str.toCharArray();
			// We assume that a Palindrome will always match the
			// required characteristic because, deleting
			// one character from 'middle' will always let it remain a
			// palindrome.
			// Check whether the given String is a Palindrome
			// If Not, return the 'index' where the mismatch happened
			int k = palindrome(charArray);
			if (k == -1) {
				pw.println("YES");
				continue;
			} else {
				// In case of a mismatch
				// There are two possibilities here : Either the mismatch
				// at 'k' prevents the string from being a palindrome
				// or 'length - k' prevents it from being a palindrome
				// Create a substring from start to k-1 and k+1 to length
				// A string without character at 'k' index
				String subString = str.substring(0, k)
						+ str.substring(k + 1, str.length());
				// Check if the above substring forms a palindrome.
				if (palindrome(subString.toCharArray()) == -1) {
					pw.println("YES");
					continue;
				} else {
					// Otherwise, remove character at index 'length-k' and
					// check if it's a palindrome
					subString = str.substring(0, str.length() - 1 - k)
							+ str.substring(str.length() - k, str.length());
					if (palindrome(subString.toCharArray()) == -1) {
						pw.println("YES");
						continue;
					}
				}
				pw.println("NO");
			}
		}

		in.close();
		pw.close();
	}

	public static int palindrome(char[] charArray) {
		// Convert to character array
		int low = 0;
		int length = charArray.length;
		int mid = (low + length) / 2;
		// Move pointers from both end towards the center of
		// the string, if there is a mistmatch,
		// String is not a palindrome
		// Else it's a palindrome.
		if (length % 2 != 0) {
			mid = mid + 1;
		}
		for (int k = 0; k < length; k++) {
			if (k > mid - 1 || k > length - 1 || k < 0)
				return -1;
			if (charArray[k] != charArray[length - 1 - k]) {
				return k;
			}

		}
		return -1;
	}
}
