class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , i);
        }

        int start=0;
        int end = 0;
        int i=0;
        ArrayList<Integer> list = new ArrayList<>();

        while(i < s.length()){
            end = Math.max(end , map.get(s.charAt(i)));

            if(i == end){
                list.add(end - start + 1);
                start = i+1;
                end = 0;
            }
            i++;
        }
        return list;

        
    }
}