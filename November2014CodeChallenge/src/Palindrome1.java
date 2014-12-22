import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Palindrome1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			// Read all the test cases
			String str = in.next();
			str = str.toLowerCase();
			str = str.replaceAll("[^a-z]", "");
			char[] charArray = str.toCharArray();
			int k = palindrome(charArray);
			if (k == -1) {
				pw.println("YES");
				continue;
			} else {
				String subString = str.substring(0, k)
						+ str.substring(k + 1, str.length());
				if (palindrome(subString.toCharArray()) == -1) {
					pw.println("YES");
					continue;
				} else {
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
