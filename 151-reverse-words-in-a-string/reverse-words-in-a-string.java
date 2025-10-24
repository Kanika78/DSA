class Solution {
    public String reverseWords(String s) {
        String ans = "";
        s = reverseString(s);
        for(int i=0 ; i<s.length() ; i++){
            String word = "";
            while (i < s.length() && s.charAt(i) == ' '){
                i++;
            }
            while(i< s.length() && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
            word = reverseString(word);
            if (!word.isEmpty()) {
                if (!ans.isEmpty()) ans += " ";
                ans += word;
            }
        }
        return ans;  
    }
    public String reverseString(String s) {
        if (s == null || s.length() <= 1)
            return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
