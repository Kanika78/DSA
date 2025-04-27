class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();
        Stack<Character> st = new Stack<>();

        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length() ; i++){
            map.put(s.charAt(i) , i);
        }


        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(!set.contains(ch)){
            while(!st.isEmpty() && ch < st.peek() && i < map.get(st.peek())){
                set.remove(st.pop());
            }
            set.add(ch);
            st.push(ch);

            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
           
    }
}