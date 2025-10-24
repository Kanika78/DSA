class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) == '('){
                cnt++;
                max = Math.max(cnt , max);
            }
            if(s.charAt(i) == ')'){
                cnt--;
            }
            i++;
        }
        return max;
        
    }
}