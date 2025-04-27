//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static class pair implements Comparable<pair>{
        int arrive ;
        int departure;
        
        pair(int arrive , int departure){
            this.arrive = arrive;
            this.departure = departure;
        }
        @Override
        public  int compareTo(pair p2){
            return this.departure - p2.departure;
        }
    }
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int time[][] = new int[arr.length][2];
        for(int i=0 ; i<arr.length ; i++){
            time[i][0] = arr[i];
            time[i][1] = dep[i];
        }
        
        Arrays.sort(time , Comparator.comparingDouble(o->o[0]));
        PriorityQueue<pair> pq = new PriorityQueue<>();
        

        for(int i=0 ; i<time.length ; i++){
            if(!pq.isEmpty() && pq.peek().departure < time[i][0]){
                pq.remove();
                pq.add(new pair(time[i][0] , time[i][1]));
            }else{
                pq.add(new pair(time[i][0] , time[i][1]));
            }
        }
        return pq.size();
    }
}
