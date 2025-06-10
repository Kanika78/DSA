class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0,dp) -1;
        
    }
    public int solve(String s , int indx,int[]dp){
        if(indx == s.length()){
            return 0;
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = indx ; i<s.length(); i++){
            if(isPalindrome(s,indx,i)){
                int cut = 1 + solve(s,i+1,dp);
                minCost = Math.min(cut , minCost);
                dp[indx] = minCost;
            }
        }
        return dp[indx];
        

    }
    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}