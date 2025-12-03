class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i=0 ; i<wordDict.size() ; i++){
            set.add(wordDict.get(i));
        }
        Boolean dp[] = new Boolean[s.length()];
        return solve(0,s , set,dp);
        
    }
    public boolean solve(int indx , String s , Set<String> set,Boolean[]dp){
        if(indx == s.length()){
            return true;
        }
        if(dp[indx] != null){
            return dp[indx];
        }
        for(int i=indx ; i<s.length() ; i++){
            if(set.contains(s.substring(indx , i+1))){
                boolean ans = solve(i+1 , s , set,dp);
                if(ans){
                    return dp[indx] = true;
                }
            }
        }
        return dp[indx] = false;
    }
    
}