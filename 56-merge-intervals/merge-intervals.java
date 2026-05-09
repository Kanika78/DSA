class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals , new Comparator<int[]>(){
            public int compare(int []a , int[]b){
                return a[0] - b[0];
            }
        });
        for(int i=0 ; i<intervals.length; i++){
            if(list.isEmpty() || list.get(list.size()-1).get(1) < intervals[i][0]){
                list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }else{
                list.get(list.size()-1).set(1 , Math.max(intervals[i][1],list.get(list.size()-1).get(1)));
            }
        }
        int[][] arr = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }
        return arr;
        
    }
}