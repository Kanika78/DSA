class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        helper(0 , inner , outer , nums);
        return outer;


        
    }
    public void helper(int indx,List<Integer>inner ,List<List<Integer>> outer, int[] nums){
        if(indx >= nums.length){
            outer.add(new ArrayList<>(inner));
            return;
        }
        inner.add(nums[indx]);
        helper(indx+1 , inner , outer , nums);
        inner.remove(inner.size()-1);
        helper(indx+1 , inner , outer , nums);
    }
}