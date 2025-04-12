/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)-> a.val - b.val);
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode n:lists){
            if(n != null){
                pq.add(n);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.remove();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
        
    }
}