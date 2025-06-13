class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        int close = n;
        int open = n;
        StringBuilder sb = new StringBuilder();
        solve(list,close,open,sb);
        return list;
        
    }
    public void solve( ArrayList<String> list,int close,int open,StringBuilder sb){
        if(close == 0 && open == 0){
            list.add(sb.toString());
            return;
        }
        if(open != 0){
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append('(');
            solve(list,close,open-1,newSb);
        }
        if(close > open){
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(')');
            solve(list,close-1,open,newSb);
        }
    }
}