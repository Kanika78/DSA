// User function Template for Java

class Solution {

    public static boolean isPossible(int a, int b) {
        // Code here
        if(a == b){
            return false;
        }
        if((a == 1 && b == 3) || (a == 3 && b == 1)){
            return false;
        }
        return true;
    }
}