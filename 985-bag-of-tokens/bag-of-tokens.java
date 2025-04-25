class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<tokens.length ; i++){
            list.add(tokens[i]);
        }

        int score = 0;
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i) <= power){ //faceup
                power -= list.get(i);
                score++;
            }else if(score > 0){
                if(list.size()-1 == i){
                    return score;
                }
                power += list.get(list.size()-1);
                score--;
                list.remove(list.size()-1);
                if(list.isEmpty()){
                    return score;
                }
                else{
                    if(list.get(i) < power){
                        power -= list.get(i);
                        score++;
                    }
                }
            }
        }
        return score;
        
        
    }
}