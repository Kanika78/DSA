class Solution {
    public int myAtoi(String s) {
        String str = s.trim();
        if(str.length() == 0){
            return 0;
        }

        long result = 0;
        int sign = 1;

        if(str.charAt(0) == '-'){
            sign = -1;
        }

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(i == 0 && ch == '-' || i == 0 && ch == '+'){
                continue;
            }else{
                if(ch - '0' >=0 && ch - '0' <= 9){
                    result = result * 10 + ch - '0';
                }else{
                    break;
                }
                if(result * sign < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(result * sign > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
        }
        return (int)(sign*result);
    
    }
   
}