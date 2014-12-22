import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ChefAndSegment {

        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
                PrintWriter pw = new PrintWriter(outputStream);
		int t = in.nextInt();
                for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int k = in.nextInt();	
			int length = x;
			double low = 0;			
			double high = length;
			int count = 2;
			double[] segments = new double[k-1];
			double mid = (low + high)/2;
			segments[0] = mid;
			while (count<=k) { 

				if(high - mid > mid - low) { 
					mid = (mid + high)/2;
				}else { 
					mid = (low + mid)/2;
				} 


			count++;
			}
			pw.println(mid);				
                }
		in.close();
		pw.close();
        }
}

