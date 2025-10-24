class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int cnt = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) == ')'){
                cnt--;
            }
            if(cnt != 0){
                ans += s.charAt(i);
            }
            if(s.charAt(i) == '('){
                cnt++;
            }
        }
        return ans;
        
    }
}