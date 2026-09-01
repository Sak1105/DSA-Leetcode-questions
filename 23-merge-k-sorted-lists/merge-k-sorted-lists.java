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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        for(ListNode x:lists){
            if(x!=null){
            pq.add(x);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode temp=pq.poll();
            tail.next=temp;
            tail=tail.next;
            if(temp.next!=null){
                pq.add(temp.next);
            }

            
        }
       return dummy.next; 
    }
}