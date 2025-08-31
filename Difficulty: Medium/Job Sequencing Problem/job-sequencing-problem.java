//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int arr[][] = new int[profit.length][3];
        for(int i=0 ; i<arr.length ; i++){
            arr[i][0] = i;
            arr[i][1] = deadline[i];
            arr[i][2] = profit[i];
        }
        int maxDeadline = Integer.MIN_VALUE;
        for(int i=0 ; i<deadline.length ; i++){
            maxDeadline = Math.max(maxDeadline , deadline[i]);
        }
        int hash[] = new int[maxDeadline+1];
        Arrays.fill(hash , -1);
        
        Arrays.sort(arr , (a , b)-> b[2] - a[2]);
        
        int totProfit = 0;
        int cnt = 0;
        
        for(int i=0 ; i<arr.length; i++){
            for(int j = arr[i][1] ; j >0 ; j--){
                if(hash[j] == -1){
                    hash[j] = i;
                    totProfit += arr[i][2];
                    cnt = cnt + 1;
                    break;
                }
            }
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(cnt);
        ans.add(totProfit);
        return ans;
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends