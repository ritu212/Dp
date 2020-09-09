import java.io.*;
import java.util.*;

class SubsetSum 
{
     public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int sum= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[]=new int[n];
        for(int i = 0;i<n;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        boolean flag = subsetPossible(arr,n,sum);
        boolean flag1 = optimisedSubsetSum(arr, sum, n);
        System.out.println(flag);
        System.out.println(flag1);
    }
    
    // space = 0(n*sum)
     public static boolean subsetPossible(int arr[], int n, int sum) {
         boolean val[][] = new boolean[n+1][sum+1];
         int i,j;
         for(i=0 ; i<=n;i++) 
         {
             val[i][0] = true;
         } 
         for(j=1 ; j<=sum;j++)
         {
             val[0][j]=false;
         }
         for(i = 1;i<=n ; i++) {
             for(j = 1;j<=sum;j++) {
                 if(j>=arr[i-1])
                    val[i][j] = val[i-1][j] || val[i-1][j-arr[i-1]];
                 else
                    val[i][j] = val[i-1][j];
             }
         }
        //  for(i=0;i<=n;i++) {
        //      for(j=0;j<=sum;j++) {
        //          System.out.print(val[i][j]+" ");
        //      }
        //      System.out.println();
        //  }
          return val[n][sum];
     }

     public static boolean optimisedSubsetSum(int arr[], int sum, int n) {
         boolean val[][] = new boolean[2][sum+1];
         int i,j;
         for(i = 0;i<=n;i++) {
             for(j=0;j<=sum ; j++) {
                 if(j==0)
                    val[i%2][j]=true;
                 else if(i==0) 
                    val[i%2][j]=false;
                else if(arr[i-1]>j)
                    val[i%2][j] = val[(i+1)%2][j];
                else 
                    val[i%2][j] = val[(i+1)%2][j] || val[(i+1)%2][j-arr[i-1]];
             }
         }
         return val[n%2][sum];
     }
}