class Solution {
    public String largestOddNumber(String num) {
        char arr[]= num.toCharArray();
        String ans = ""; 
        for(int i = arr.length-1 ; i>= 0 ; i--){
            if(arr[i] % 2 != 0){
                ans = num.substring(0 , i+1);
                return ans;
            }
            
        }
        return "";
        
    }
}