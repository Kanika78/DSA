class Solution {
    public int[] prevPermOpt1(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<arr.length ; i++){
            list.add(arr[i]);
        }
        int index = -1;
        for(int i=list.size()-2 ; i>=0 ; i--){
            if(list.get(i) > list.get(i+1)){
                index = i;
                break;
            }
        }

        if(index == -1){
            return arr;
        }

        for(int i=list.size()-1 ; i>=0 ; i--){
            if(list.get(i) < list.get(index) && list.get(i) != list.get(i-1)){
                int temp = list.get(i);
                list.set(i , list.get(index));
                list.set(index , temp);

                break;
            }
        }


        int nums[] = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}