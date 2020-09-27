// source: LeetCode
// https://leetcode.com/problems/middle-of-the-linked-list

// 876. <easy> Middle of the Linked List
/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

Note:
    The number of nodes in the given list will be between 1 and 100.
*/

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

// VERSION 2
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {       
        ListNode walker = head;
        ListNode runner = head;
        
        while (runner != null && runner.next != null) {
            // move walker forward one
            walker = walker.next;
            // move runner forward twice
            runner = runner.next.next;
        }
        
        return walker;
    }
}
/*
15 / 15 test cases passed.
Runtime: 0 ms
Memory Usage: 36.6 MB
*/

// VERSION 1
/*
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head.next;

        while (walker != null && runner != null && runner.next != null) {
            // move walker forward one
            walker = walker.next;
            // move runner forward twice
            runner = runner.next.next;
        }

        // if runner has only one next left,
        // move walker forward one
        // so it will be on the latter half of the middle
        if (runner != null && runner.next == null) {
            walker = walker.next;
        }

        return walker;
    }
}
*/

/*
15 / 15 test cases passed.
Runtime: 0 ms
Memory Usage: 36.6 MB
*/

