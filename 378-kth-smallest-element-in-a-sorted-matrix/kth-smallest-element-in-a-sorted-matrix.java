class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(int[][] matrix, int k) {
        for(int i=0 ; i<matrix.length ; i++){
            insert(matrix[i]);
        }
        for(int i=1 ; i<k ; i++){
            pq.remove();
        }
        return pq.peek();

        
    }
    public void insert(int arr[]){
        for(int i=0 ; i<arr.length ; i++){
            pq.add(arr[i]); 
        }

    }
}