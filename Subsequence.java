import java.io.*;
import java.util.*;

class Subsequence
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxLength(arr,n));
    }

    public static int maxLength(int arr[], int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int i,j,max=1;
        for(i=1;i<n;i++) {
            for(j=0;j<i;j++) {
                if(Math.abs(arr[i]-arr[j])<=1 && dp[i]<(dp[j]+1))
                    dp[i] = dp[j]+1;
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}