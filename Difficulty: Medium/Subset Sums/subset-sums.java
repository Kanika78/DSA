// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        
        helper(0 , arr , list,ds);
        return list;
    }
    public void helper(int indx ,int[] arr,ArrayList<Integer> list,ArrayList<Integer>ds){
        if(indx == arr.length){
            if(ds.size() < 1){
                list.add(0);
                return;
            }
            int sum = 0;
            for(int i=0 ; i<ds.size() ; i++){
                sum += ds.get(i);
            }
            list.add(sum);
            return;
        }
        ds.add(arr[indx]);
        helper(indx+1, arr, list,ds);
        ds.remove(ds.size()-1);
        helper(indx+1, arr, list,ds);
        
    }
    
}
