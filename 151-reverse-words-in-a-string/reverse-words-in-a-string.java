class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String arr[] = s.split("\\s+");
        if(arr.length == 1){
            return arr[0];
        }
        for(int i=arr.length-1 ; i>0 ; i--){
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[0]);
        return sb.toString();
        
    }
}