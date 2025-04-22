class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int i=0 ; i<gas.length ; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum){
            return -1;
        }
        int start = 0;
        int left = 0;

        for(int i=0 ; i<gas.length ; i++){
            left += gas[i] - cost[i];
            
            if(left < 0){
                left = 0;
                start = i+1;
            }
        }
        return start;
        
    }
}