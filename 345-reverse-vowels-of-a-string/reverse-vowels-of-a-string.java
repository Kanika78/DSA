class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int i=0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();

        while(i < j){
            if(!vowels.contains(s.charAt(j))){
                j--;
            }else if(!vowels.contains(s.charAt(i))){
                i++;
            }
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
        
    }
}