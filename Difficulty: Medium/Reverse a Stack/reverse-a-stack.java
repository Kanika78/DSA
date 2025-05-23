// User function Template for Java

class Solution {
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.isEmpty()){
            return;
        }
        int temp = s.pop();
        reverse(s);
        pushAtBottom(s , temp);
        
    }
    static void pushAtBottom(Stack<Integer> s , int x){
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int topEl = s.pop();
        pushAtBottom(s , x);
        s.push(topEl);
        
    }
}