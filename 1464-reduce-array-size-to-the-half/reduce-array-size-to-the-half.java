class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i])+1);
                
            }else{
                map.put(arr[i] , 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
       entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int sum = 0;
        int pair = 0;
        int minPair = Integer.MAX_VALUE;
        int half = arr.length/2;


        for (Map.Entry<Integer, Integer> entry : entryList) {
            if(entry.getValue() > half){
                return 1;
            }
            else{
                sum += entry.getValue();
                pair++;
                if(sum >= half){
                    minPair = Math.min(minPair , pair);
                    sum = 0;
                    pair = 0;
                }

            }
            
        }
        return minPair;


        
    }
}