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

package codechef.challenge.rotation;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Runs in 2.27s
 * 
 * @author Animesh Kumar <animesh143@gmail.com>
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
