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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class FunWithRotationFirstAttempt {

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

			// Convert the input array to arraylist as it's easier to shift the
			// values in arraylist than it is in array. Array will need to shift
			// the whole structure by specified number.
			ArrayList<String> inputArrayList = new ArrayList<String>(
					Arrays.asList(inputArray));
			for (String[] query : queriesArrayList) {
				inputArrayList = executeQuery(inputArrayList, n, m, query);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<String> executeQuery(
			ArrayList<String> inputArrayList, int n, int m, String[] query) {
		// Parse the query. The query will have two elements ; first, the
		// direction and second the number of times rotation has to be done ie.,
		// d
		int d = Integer.parseInt(query[1]);
		String queryType = query[0];
		switch (queryType) {
		case "R":
		case "r":
			System.out.println(getValue(inputArrayList, d));
			break;
		case "C":
		case "c":
			inputArrayList = rotateClockwise(inputArrayList, d);
			break;
		case "A":
		case "a":
			inputArrayList = rotateAntiClockwise(inputArrayList, d);
			break;
		}
		return inputArrayList;

	}

	private static ArrayList<String> rotateClockwise(
			ArrayList<String> inputArrayList, int d) {
		ArrayList<String> rotatinglist = new ArrayList<String>();
		for (int i = 0; i < d; i++) {
			String pop = inputArrayList.remove(0);
			rotatinglist.add(pop);
		}
		inputArrayList.addAll(rotatinglist);
		return inputArrayList;

	}

	private static ArrayList<String> rotateAntiClockwise(
			ArrayList<String> inputArrayList, int d) {
		ArrayList<String> rotatinglist = new ArrayList<String>();
		int size = inputArrayList.size();
		for (int i = d; i > 0; i--) {
			String pop = inputArrayList.remove(size - i);
			size = inputArrayList.size();
			rotatinglist.add(pop);
		}
		// Add all from inputArraylist to the end of rotating list
		rotatinglist.addAll(inputArrayList);
		return rotatinglist;
	}

	private static String getValue(ArrayList<String> inputArrayList, int d) {
		return inputArrayList.get(d - 1);
	}
}
