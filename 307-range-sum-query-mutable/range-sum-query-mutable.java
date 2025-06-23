class NumArray {
    int[] arr;
    int[]bit;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.bit = new int[n+1];
        this.arr = new int[n];
        for(int i=0 ; i<n ; i++){
            update(i , nums[i]);
        }  
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;
        index++;
        while(index <= n){
            bit[index] += diff;
            index = index + (index & (-index));
        }   
    }
    public int rangeQuery(int indx){
        int res = 0;
        indx = indx+1;
        while(indx>0){
            res += bit[indx];
            indx = indx - (indx & (-indx));

        }
        return res;

    }
    
    public int sumRange(int left, int right) {
        return rangeQuery(right) - rangeQuery(left-1);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */