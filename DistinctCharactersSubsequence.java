/***
Copyright (C) 2014-2015 Animesh Kumar <animesh143@gmail.com>
This program is free software: you can redistribute it and/or modify it
under the terms of the GNU Lesser General Public License version 2.1, as published
by the Free Software Foundation.
This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranties of
MERCHANTABILITY, SATISFACTORY QUALITY, or FITNESS FOR A PARTICULAR
PURPOSE.  See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along
with this program.  If not, see <http://www.gnu.org/licenses/>.
 ***/

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Runs in 0.39s and takes 384M for all the test cases.
 * 
 * @author Animesh Kumar <animesh143@gmail.com>
 *
 */
public class DistinctCharactersSubsequence {

	public static void main(String[] args) {
		// To find distinct characters subsequence, where characters can be from
		// a-z only, we can create an array of 26 elements where we can store
		// all elements from a-z. Now whenever we have a repetition, it will go
		// into it's corresponding bucket only Eg. 'a' will always go into pos
		// '0' hence the size of array will determine number of distinct
		// characters.
		int[] alphabet = new int[26];
		// Scan the input
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");
		OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(outputStream);
		// Get the number of test cases
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			Arrays.fill(alphabet, -1);
			// Get the String Sequence
			String stringSeq = in.next("[a-z]+");
			// Set initial position to 0
			int pos = 0;
			for (char c : stringSeq.toCharArray()) {
				// Get the character position by finding it's ascii and
				// subtracting 97 from it
				// it will come as 0 for 'a' and 25 for 'z'
				int ascii = (int) c;
				pos = ascii - 97;
				alphabet[pos] = 1;
			}
			int count = 0;
			// Find all distinct characters by looping through the array
			for (int j = 0; j < alphabet.length; j++) {
				if (alphabet[j] > -1) {
					count++;
				}
			}
			pw.println(count);
		}
		// ASCII for a to z is 97 to 122
		in.close();
		pw.close();
	}
}

