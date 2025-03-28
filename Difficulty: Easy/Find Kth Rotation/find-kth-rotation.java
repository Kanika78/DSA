//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int low = 0;
        int high = arr.size() - 1;
        int min = Integer.MAX_VALUE;
        int indx = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(min > arr.get(mid)){
                indx = mid;
                min = arr.get(mid);
            }
            if(arr.get(high) <= arr.get(mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return indx;
    }
}