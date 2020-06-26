// Easy

// Remove all elements from a linked list of integers that have value val.

// Example:

// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } 
            else {
                prev = curr;       
            }         
            curr = curr.next;   
        }
        return sentinel.next;
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 86.74% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 40.5 MB, less than 43.98% of Java online submissions for Remove Linked List Elements.
