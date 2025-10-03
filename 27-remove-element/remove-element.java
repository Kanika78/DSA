class Solution {
    public int removeElement(int[] nums, int val) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(val, 0);
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == val){
                map.put(val, map.get(val)+1);
            }
        }
        int i=0;
        int j = nums.length-1;
        while(i < j){
            if(nums[j] == val){
                j--;
            }
            else if(nums[j] != val && nums[i] == val){
                int temp = nums[j];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                i++;
            }
            else{
                i++;
            }
        }
        return nums.length - map.get(val); 
        
    }
}