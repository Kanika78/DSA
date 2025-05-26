class Solution {
    public int lastRemaining(int n) {
        int steps = 1;
        int head = 1;
        boolean left = true;
        while(n > 1){
            if(left == true || n % 2 != 0){
                head = head + steps;
            }
            steps = steps * 2;
            n = n/2;
            left = !left;
        }
        return head;
        
    }
}