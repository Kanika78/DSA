class Solution {
    public int countCollisions(String directions) {
        Stack<Character> s = new Stack<>();
        int count = 0;

        for(int i = 0 ; i < directions.length() ; i++){
            char ch = directions.charAt(i);
            if(s.isEmpty()){
                if(ch == 'R'){
                    s.push('R');
                }
                else if(ch == 'S'){
                    s.push('S');
                }
            }
            else if(ch == 'R'){
                s.push('R');
            }
            else if(ch == 'S'){
                while(!s.isEmpty() && s.peek() == 'R'){
                    count += 1;
                    s.pop();
                }
                s.push('S');
            }
            else if(s.peek() == 'R' && ch == 'L'){
                count += 2;
                s.pop();
                while(!s.isEmpty() && s.peek() == 'R'){
                    count += 1;
                    s.pop();
                }
                s.push('S');
            }
            else if(ch == 'L' && s.peek() == 'S') {
                count += 1;
                s.push('S');
            }
        }
        return count;
        
    }
}