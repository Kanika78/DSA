class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() < s3.length() || s1.length() + s2.length() > s3.length()){
            return false;
        }
        Boolean [][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1]; 
        return solve(0,0,0,s1,s2,s3,dp);
        
    }
    public boolean solve(int i,int j,int k,String s1, String s2, String s3,Boolean dp[][][]){
        if(k == s3.length()){
            if(i == s1.length() && j == s2.length()){
                return true;
            }else{
                return false;
            }
        }
        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        boolean path1 = false;
        if( k < s3.length() && i <s1.length() && s1.charAt(i) == s3.charAt(k)){
            path1 = solve(i+1,j,k+1,s1,s2,s3,dp);
        }

        boolean path2 = false;
        if(j < s2.length() && k <s3.length() && s2.charAt(j) == s3.charAt(k)){
            path2 = solve(i,j+1,k+1,s1,s2,s3,dp);
        }

        return dp[i][j][k] = path1 || path2;

    }
}