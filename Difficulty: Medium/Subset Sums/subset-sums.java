// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        List<Integer> inner = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0 , inner , ans , arr);
        Collections.sort(ans);
        return ans;
        
    }
    public void helper(int indx,List<Integer>inner ,ArrayList<Integer> ans, int[] nums){
        if(indx >= nums.length){
            int sum = 0;
            for(int i=0 ; i<inner.size() ; i++){
                sum += inner.get(i);
            }
            ans.add(sum);
            return;
        }
        inner.add(nums[indx]);
        helper(indx+1 , inner , ans , nums);
        inner.remove(inner.size()-1);
        helper(indx+1 , inner , ans , nums);
    }
}