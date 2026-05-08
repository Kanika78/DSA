class Solution {
    public void nextPermutation(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++){
            list.add(nums[i]);
        }
        int indx = -1;
        for(int i=list.size()-2 ; i>=0 ; i--){
            if(list.get(i) < list.get(i+1)){
                indx = i;
                break;
            }
        }

        if(indx == -1){
            Collections.reverse(list);
            for(int i=0 ; i<list.size() ; i++){
                nums[i] = list.get(i);
            }
            return;
        }else{ 
             for(int i=list.size()-1 ; i>indx ; i--){
                if(list.get(i) > list.get(indx)){
                    int temp = list.get(i);
                    list.set(i,list.get(indx));
                    list.set(indx , temp);

                    break;
                }
            }

        }
        List<Integer> sublist = list.subList(indx+1, list.size() );
        Collections.reverse(sublist);
        for(int i=0 ; i<list.size() ; i++){
            nums[i] = list.get(i);
        }

        
    }
}