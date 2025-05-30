class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(1,n,ls,ds,k);
        return ls;
        
    }
    public void solve(int indx,int target,List<List<Integer>> ls,List<Integer> ds,int k){
        if(target == 0){
            if(ds.size() == k){
                ls.add(new ArrayList<>(ds));
            }
            return;
        }
        for(int i = indx ; i<= 9 ; i++){
            if(i > indx && i == i-1){
                continue;
            }
            if(i > target){
                break;
            }
            ds.add(i);
            solve(i+1,target-i,ls,ds,k);
            ds.remove(ds.size()-1);
        }

        
        

    }
}