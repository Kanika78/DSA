class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return compare(str1 , str2) || compare(str2 , str1); 
    }
    public boolean compare(char s1[] , char s2[]){
        for(int i=0 ; i<s1.length ; i++){
            if(s1[i] < s2[i]){
                return false;
            }
        }
        return true;
        

    }
}