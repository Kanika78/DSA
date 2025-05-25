class Solution {

    public void helper(int indx ,HashMap<Integer,String> map,String digits,  StringBuilder sb, List<String> list){
        if(indx == digits.length()){
            list.add(sb.toString());
            return;
        }
        int dig = digits.charAt(indx) - '0';
        String s = map.get(dig);

        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            sb.append(c);
            helper(indx+1 , map,digits,sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(digits.equals("")){
            return list;
        }
        map.put(2 , "abc");
        map.put(3 , "def");
        map.put(4 , "ghi");
        map.put(5 , "jkl");
        map.put(6 , "mno");
        map.put(7 , "pqrs");
        map.put(8 , "tuv");
        map.put(9 , "wxyz");

        helper(0 ,map,digits,sb, list);
        
        return list;

        

        
    }
}