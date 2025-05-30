class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ls = new ArrayList<>();
        solve(0,nums,ds,ls);
        return ls;
        
    }
    public void solve(int indx,int[] nums,List<Integer> ds,List<List<Integer>> ls){
        ls.add(new ArrayList<>(ds));
        for(int i=indx ;i<nums.length ; i++){
            if(i > indx && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            solve(i+1,nums,ds,ls);
            ds.remove(ds.size()-1);
        }
    }
}