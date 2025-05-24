class Solution {
    int mod = 1000000007;
    public long pow(long x , long n){
        long ans = 1;
        x = x % mod;
        while(n >= 1){
            if(n % 2 == 1){
                ans = (ans * x)%mod;
            }
            x = (x*x)%mod;
            n = n/2;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;
        long ans = (pow(5 , even) * pow(4 , odd))%mod;
        return (int)ans;

        
    }
}