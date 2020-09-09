import java.io.*;
import java.util.*;

//floor size:n*m tile size:1*m
class TilingProblem
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());
        int count = ways(n,m);
        System.out.println(count);
    }

    public static int ways(int n, int m) {
        int count[]=new int [n+1];
        count[0]=0;
        for(int i=1;i<=n;i++)
        {
            if(i<m || i==1)
                count[i]=1;
            else if(i==m)
                count[i] = 2;
            else
                count[i] = count[i-1] + count[i-m];
        }
        return count[n];
    }
}