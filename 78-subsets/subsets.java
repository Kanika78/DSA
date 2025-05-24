class Solution {
    public void subsequence(int indx ,int nums[], List<List<Integer>> ls, List<Integer> ds){
        if(indx >= nums.length){
            ls.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[indx]);
        subsequence(indx+1 , nums , ls ,ds);
        ds.remove(ds.size()-1);
        subsequence(indx+1 , nums , ls , ds);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ls = new ArrayList<>();

        subsequence(0 , nums , ls , ds);
        return ls;


        
    }
}