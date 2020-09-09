import java.io.*;
import java.util.*;

class BinomialCoefficient 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        int coef=binomial(n,k);
        int coef1 = optimized(n,k);
        System.out.println(coef);
        System.out.println(coef1);
    }

    // Space : O(n*k) time: O(n*k)
    public static int binomial(int n,int k)
    {
        int c[][] = new int [n+1][k+1];
        for(int i = 0;i<=n;i++) {
            for(int j=0;j<=Math.min(i,k);j++) {
                if(j==0 || j==i){
                    c[i][j]=1;
                }
                else {
                    c[i][j] = c[i-1][j-1]+c[i-1][j];
                }
            }
        }
        return c[n][k];
    }
    // Space : O(k) time: O(n*k)

    public static int optimized(int n, int k) {
        int c[] = new int[k+1];
        c[0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=Math.min(i,k);j>0;j--) {
                c[j] = c[j] + c[j-1];
            }
        }
        return c[k];
    }
}