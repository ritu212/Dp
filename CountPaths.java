import java.io.*;
import java.util.*;

class CountPaths
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(count(n,m));
    }

    public static int count(int n, int m) {
        int dp[][] = new int [n][m];
        int i,j;
        for(i=0 ;i<n;i++)
            dp[i][0] = 1;
        for(i=0 ;i<m;i++)
            dp[0][i] = 1;
        for(i = 1;i<n;i++) {
            for(j=1;j<m;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[n-1][m-1];
    }
}