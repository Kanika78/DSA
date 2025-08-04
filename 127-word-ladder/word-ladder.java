class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word , int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0 ; i<wordList.size() ; i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            String word = p.word;
            int step = p.steps;
            if(word.equals(endWord)== true){
                return step;
            }
            for(int i=0 ; i<word.length(); i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char replaced[] = word.toCharArray();
                    replaced[i] = ch;
                    String Nextword = new String(replaced);
                    if(set.contains(Nextword)){
                        q.add(new Pair(Nextword , step+1));
                        set.remove(Nextword);
                    }
                }

            }

        }
        return 0;
        
        
    }
}