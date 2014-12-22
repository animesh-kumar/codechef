import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class ChefAndRBTree1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(out);
		long x, y;
		// Fetch the number of queries user will enter
		int q = in.nextInt();
		// Keep a flag to keep a track whether the root is black or red
		// It's initially black
		char color = 'b';
		for (int i = 0; i < q; i++) {
			// Fetch the command which can be one of the Qb, Qr or Qi
			String command = in.next("Q[rbi]");
			// According to the question,Both children of a red colored node are
			// black and both children of a black colored node are red.
			// Hence the color is always alternated.
			// From this we can deduce that initially black will be
			// at level 0,2,4... and red at the level 1,3,4...
			switch (command) {
			case "Qi":
				// Switch the color of all black nodes to red and vice versa
				if (color == 'b')
					color = 'r';
				else
					color = 'b';
				break;
			case "Qb":
				// Fetch the source
				x = in.nextInt();
				// Fetch the destination
				y = in.nextInt();
				pw.println(findNumberOfNodes(x, y, 'b', color));
				break;
			case "Qr":
				// Fetch the source
				x = in.nextInt();
				// Fetch the destination
				y = in.nextInt();
				// Calculate the number of red nodes from x to y
				pw.println(findNumberOfNodes(x, y, 'r', color));
				break;
			}

		}
		in.close();
		pw.close();
	}

	private static long findNumberOfNodes(long x, long y, char checkColor,
			char color) {
		char nodeColor;
		// Calculate the number of black nodes from x to y
		// We can do this by finding number of alternate levels(blacks)
		// from x to root and then root to y.
		// Find the number of levels from x to root
		long levelsToRootFromX = logOfBase(2, x);
		// Check whether x is same colored as root to find the x node's
		// color
		if (levelsToRootFromX % 2 == 0) {
			nodeColor = color;
		} else {
			if (color == 'b')
				nodeColor = 'r';
			else
				nodeColor = 'b';
		}
		long start = x;
		// Now check if the check color is same as node color
		if (checkColor != nodeColor) {
			start = x / 2;
		}
		HashSet<Long> traversedNodes = new HashSet<Long>();
		// Start from X value
		for (long i = start; i >= 1; i = i / 4) {
			traversedNodes.add(i);
		}
		long levelsToRootFromY = logOfBase(2, x);
		// Check whether x is same colored as root to find the x node's color
		if (levelsToRootFromY % 2 == 0) {
			nodeColor = color;
		} else {
			if (color == 'b')
				nodeColor = 'r';
			else
				nodeColor = 'b';
		}
		start = y;
		// Now check if the check color is same as node color
		if (checkColor != nodeColor) {
			start = y / 2;
		}
		// End at Y value
		for (long i = start; i >= 1; i = i / 4) {
			traversedNodes.add(i);
		}

		return traversedNodes.size();

	}

	public static long logOfBase(int base, long num) {
		return (long) (Math.log(num) / Math.log(base));
	}
}
