class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)+1);
            }else{
                map.put(ch , 1);
            }
        }
        List<Map.Entry<Character , Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list ,(a, b) -> b.getValue().compareTo(a.getValue()));

        for(Map.Entry<Character , Integer> entry : list){
            int count = entry.getValue();
            char ch = entry.getKey();
            for(int i = 0 ; i < count ; i++){
                sb.append(ch);
            }
        }
        return sb.toString();




        
    }
}