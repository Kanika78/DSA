class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solve(0,s,list,ans);
        return ans;  
    }
    public void solve(int indx,String s,List<String> list,List<List<String>> ans){
        if(indx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=indx;i<s.length();i++){
            if(isPalindrome(s,indx,i)){
                list.add(s.substring(indx,i+1));
                solve(i+1,s,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}