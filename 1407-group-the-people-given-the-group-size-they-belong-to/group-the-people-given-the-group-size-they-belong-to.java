class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int arr[][] = new int[groupSizes.length][2];
        for(int i=0 ; i<arr.length ; i++){
            arr[i][0] = i;
            arr[i][1] = groupSizes[i];
        }
        Arrays.sort(arr , Comparator.comparingDouble(o->o[1]));
        List<List<Integer>> list = new ArrayList<>();

        int first = arr[0][1];
        list.add(new ArrayList<>(Arrays.asList(arr[0][0])));
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i][1] == first && list.get(list.size()-1).size() < arr[i][1]){
                list.get(list.size()-1).add(arr[i][0]);
                first = arr[i][1];
            }else{
                first = arr[i][1];
                list.add(new ArrayList<>(Arrays.asList(arr[i][0])));
            
            }
        }
        return list;

        
    }
}