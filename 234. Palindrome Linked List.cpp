// Easy
// Given a singly linked list, determine if it is a palindrome.

// Example 1:

// Input: 1->2
// Output: false
// Example 2:

// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?

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
    bool isPalindrome(ListNode* head) {
//    Get list size.
    int n = 0;
    ListNode *curr = head;

    for (ListNode *count = head; count != NULL; count = count->next) {
        n += 1;
    }

    if (n < 2) {
        return true;
    }

// Reverse the first half.
    int mid_n = n / 2;
    ListNode *prev= nullptr;
    ListNode *next = curr->next;

    for (int i = 1; true; i++) {
        curr->next = prev;
        if (i == mid_n) break;
        prev = curr;
        curr = next;
        next = next->next;
    }

    if (n % 2 == 1) next = next->next;

// Compare first and second half parts.
    while ( curr!= NULL) {
        if (curr->val != next->val) {
            return false;
        } else {
            curr = curr->next;
            next = next->next;
        }
    }
    return true;
    }
};

// Success
// Details 
// Runtime: 20 ms, faster than 92.44% of C++ online submissions for Palindrome Linked List.
// Memory Usage: 12.3 MB, less than 98.28% of C++ online submissions for Palindrome Linked List.
