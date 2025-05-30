class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(0 , candidates,target,ls,ds);
        return ls;
        
    }
    public void solve(int indx,int[] candidates,int target,List<List<Integer>> ls,List<Integer> ds){
        if(target == 0){
            ls.add(new ArrayList<>(ds));
            return;
        }
        for(int i=indx ; i<candidates.length ; i++){
            if(i > indx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            ds.add(candidates[i]);
            solve(i+1 , candidates,target-candidates[i],ls,ds);
            ds.remove(ds.size()-1);
        }


        
        

    }
}