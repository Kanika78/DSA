class Solution {
    int mod = 1000000007;
    public long pow(long x , int n){
        x = x%mod;
        long ans = 1;
        while(n >= 1){
            if(n % 2 == 1){
                ans = (ans*x)%mod;
            }
            x = (x*x)%mod;
            n=n/2;
        }
        return ans;
    }
    public int monkeyMove(int n) {
        int val = (int)pow(2 , n)-2;
        return val + (val < 0 ?mod:0); //if val is negative then mod of it will give wrong ans

        
    }
}