import java.io.*;
import java.util.*;

class MinJumps
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] =new int[n];
        for(int i = 0;i<n;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minJumps(arr, n));
    }

    public static int minJumps(int arr[], int n) {
        int dp[] = new int[n];
        int i,j;
        dp[0] = 0;
        for(i= 1;i<n;i++) {
            for(j=0;j<i;j++) {
                if((i-j)<=arr[j] && dp[i]>dp[j]+1)
                    dp[i] = dp[j]+1;
                else if((i-j)<=arr[j] && dp[i]==0)
                    dp[i] = dp[j]+1;
            }
        }
        for(i = 0;i < n ;i++)
            System.out.print(dp[i]);
        System.out.println();
        return dp[n-1];
    }
}