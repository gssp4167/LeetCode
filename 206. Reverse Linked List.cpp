Easy


Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        } else {
            ListNode* thead = head;
            ListNode* temp = head->next;
        
            while (temp != NULL) {
                ListNode* i = temp;
                temp = i->next;
                i->next = head;
                head = i;
        }
        
        thead->next = NULL;
        
        return head;
        }
        
    }
};

Success
Details 
Runtime: 16 ms, faster than 5.19% of C++ online submissions for Reverse Linked List.
Memory Usage: 9.3 MB, less than 71.76% of C++ online submissions for Reverse Linked List.
