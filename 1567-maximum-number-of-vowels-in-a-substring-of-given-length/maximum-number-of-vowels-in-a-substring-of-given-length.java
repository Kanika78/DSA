class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                cnt += 1;
            }
            if(r-l+1 > k){
                if(set.contains(s.charAt(l))){
                    cnt -= 1;
                }
                l++;
            }
            max = Math.max(max , cnt);
            r++;

        }
        return max;
        
    }
}