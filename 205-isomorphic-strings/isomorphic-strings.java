class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character , Character> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            char cht = t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch).equals(cht) == false){
                    return false;
                }
            }
            else if(!map.containsKey(ch)){
                if(map.containsValue(cht)){
                    return false;
                }
            }
            map.put(ch , cht);
        }
        return true;
        
    }
}