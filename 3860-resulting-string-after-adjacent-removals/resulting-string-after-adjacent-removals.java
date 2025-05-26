class Solution {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(sb.length() > 0){
                char lastChar = sb.charAt(sb.length()-1);
                int diff  = Math.abs(lastChar - c);
                if(diff == 1 || diff == 25){
                    sb.deleteCharAt(sb.length()-1);
                    continue;
                }

            }
            sb.append(c);

        }
        return sb.toString();
        
    }
}