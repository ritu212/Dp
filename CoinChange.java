import java.io.*;
import java.util.*;

class CoinChange
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s[]=new int[m];
        for(int i = 0;i<m;i++) {
            s[i]=Integer.parseInt(st.nextToken());
        }
        int count = ways(s,n,m);
        System.out.println(count);
    }

    public static int ways(int s[],int n,int m) {
        int arr[] = new int[n+1];
        Arrays.fill(arr,0);
        arr[0]=1;
        for(int i=0;i<m;i++){
            for(int j=s[i];j<=n;j++)
            {
                arr[j]=arr[j]+arr[j-s[i]];
            }
        }
        return arr[n];
    }
}