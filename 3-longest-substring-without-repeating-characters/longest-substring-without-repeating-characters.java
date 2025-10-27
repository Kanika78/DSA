class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r = 0;
        int maxlen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && l <= map.get(ch)){
                l = map.get(ch) + 1;
            }
            map.put(ch , r);
            maxlen = Math.max(maxlen , r-l+1);
            r++;
        }
        return maxlen;
    }
}