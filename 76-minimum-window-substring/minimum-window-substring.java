class Solution {
    public String minWindow(String s, String t) {
        int l =0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndx = -1;
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0 ; i<t.length() ; i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))-1);
                if(map.get(s.charAt(r)) >=0){
                    cnt = cnt + 1;
                }
            }
            while(cnt == t.length()){
                if(minLen > (r-l+1)){
                    minLen = r-l+1;
                    sIndx = l;
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l) , map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l)) > 0){
                        cnt = cnt - 1;
                    }
                }
                l++;
            }
            r++;
        }
        return sIndx == -1 ? "" : s.substring(sIndx, sIndx + minLen);
    }
}