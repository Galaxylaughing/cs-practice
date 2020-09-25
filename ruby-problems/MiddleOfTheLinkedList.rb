# source: LeetCode
# https://leetcode.com/problems/middle-of-the-linked-list/

# 876. <easy> Middle of the Linked List
=begin
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
=end

# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def middle_node(head)
    go_to_end = head
    go_to_middle = head

    while !go_to_end.nil? && !go_to_end.next.nil?
        go_to_middle = go_to_middle.next
        go_to_end = go_to_end.next.next
    end

    return go_to_middle
end

=begin
15 / 15 test cases passed.
Runtime: 32 ms
Memory Usage: 9.3 MB
=end

