class Solution {
    public boolean predictTheWinner(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        int winner = solve(list,true,0,0);
        int total = 0;
        for(int num : nums){
            total += num;
        }
        return winner >= total - winner;
        
    }
    public int solve(ArrayList<Integer> list , boolean player1,int score1,int score2){
        if(list.isEmpty()){
            return score1;
        }
        ArrayList<Integer> list1 = new ArrayList<>(list);
        ArrayList<Integer> list2 = new ArrayList<>(list);
        
        int option1 = list1.get(0);
        list1.remove(0);

        int option2 = list2.get(list2.size()-1);
        list2.remove(list2.size()-1);

        if(player1){
            return Math.max(
                solve(list1 , false,score1+option1 , score2),
                solve(list2 , false, score1+option2 , score2)
            );
        }else{
            return Math.min(
                solve(list1 , true ,score1 ,score2+option1),
                solve(list2 , true , score1, score2+option2)
            );
        }
    }
}