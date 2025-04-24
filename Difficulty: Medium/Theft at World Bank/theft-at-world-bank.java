//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        double[][] arr = new double[w.length][3];
        for(int i=0 ; i<arr.length ; i++){
            arr[i][0] = p[i];
            arr[i][1] = w[i];
            arr[i][2] = (double) p[i]/w[i];
        }
        Arrays.sort(arr , Comparator.comparingDouble(o->o[2]));
        double profit = 0;
        int i=N-1;
        while(C > 0 && i >= 0 ){
            if(!checkSquare(arr[i][1])) {
                if(arr[i][1] <= C) {
                    profit += arr[i][0];
                    C -= arr[i][1];
                } else {
                    profit += arr[i][2] * C;
                    C = 0;
                }

            }
            i--;
        }
        return profit;
    }
     public static boolean checkSquare(double el){
        double i = (int)Math.sqrt(el);
        return i*i == el;
    }
}