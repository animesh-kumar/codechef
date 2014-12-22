import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Fombinatorial { 

public static void main(String[] args){ 
Scanner in = new Scanner(System.in);
OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
PrintWriter pw = new PrintWriter(outputStream);
int t = in.nextInt(); // Number of test cases
int n = in.nextInt(); // N value
int m = in.nextInt(); // Modulo value
int q = in.nextInt(); // Q is number of r values that have to come
// loop over all test cases
for (int i=0;i<t;i++){ 
// Read all the r values
for (int j=0;j<q;j++){ 
int r = in.nextInt();
// Calculate the difference between n and r
int diff = n -r;
// Formula F(n) / F(r) * F(N-r)
int divisor1 = 1;// Use them to reduce the calculations
int divisor2 = 1;
int product = 1;
for (int k=2;k<=n;k++){ 
product = product * power(k,k);
if(k==r){ 
divisor1 = product;
}else if(k==diff){ 
divisor2 = product;
}
}
// Calculate the quotient
int quotient = product / divisor1;
quotient = quotient/ divisor2;
int result = quotient % m;
pw.println(result);
}

}

in.close();
pw.close();
}

static int power(int base, int powr){
    if(powr == 0) return 1;
    return base * power(base, --powr);
}

}
