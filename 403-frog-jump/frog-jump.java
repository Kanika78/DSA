class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<stones.length ; i++){
            map.put(stones[i],i);
        }
        int dp[][] = new int[2001][2001];
        for(int[]r : dp){
            Arrays.fill(r ,-1);
        }
        return cross(0, 0, stones, map, dp) == 1;
    }
    public int cross(int stone_indx,int prevJump,int[]stones,HashMap<Integer,Integer>map, int[][]dp){
        if(stone_indx == stones.length-1){
            return 1;
        }
        if(dp[stone_indx][prevJump] != -1){
            return dp[stone_indx][prevJump];
        }
        int result = 0;
        for(int nextJump=prevJump-1 ; nextJump<=prevJump+1 ; nextJump++){
            if(nextJump > 0){
                int nextStone = stones[stone_indx] + nextJump;
                if (map.containsKey(nextStone)) {
                    if (cross(map.get(nextStone), nextJump, stones, map, dp) == 1)      {
                        result = 1;
                        break;
                    }
                }
            }
        }
        return dp[stone_indx][prevJump] = result;
    }
}