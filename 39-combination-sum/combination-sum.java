class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        helper(0 , inner , outer , candidates,target , 0);
        return outer;
        
    }
    public void helper(int indx,List<Integer>inner ,List<List<Integer>> outer, int[] nums, int target , int sum){

        if(sum > target){
            return;
        }
        if(indx >= nums.length){
            if(sum == target){
                outer.add(new ArrayList<>(inner));
            }
            return;
        }
        inner.add(nums[indx]);
        sum += nums[indx];
        helper(indx , inner , outer , nums, target , sum);
        inner.remove(inner.size()-1);
        sum -= nums[indx];
        helper(indx+1 , inner , outer , nums, target , sum);
    }
}