# source: LeetCode
# https://leetcode.com/problems/diameter-of-binary-tree/

# 543. <easy> Diameter of a Binary Tree
=begin
 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 
=end

# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer}
def diameter_of_binary_tree(root)
    result = diameter_of_binary_tree_helper(root)
    return result[:M]
end

def diameter_of_binary_tree_helper(node)
    return {L: 0, R: 0, M: 0} if node.nil?

    left_result = diameter_of_binary_tree_helper(node.left)
    right_result = diameter_of_binary_tree_helper(node.right)

    max_left_diameter = [left_result[:L], left_result[:R]].max
    max_right_diameter = [right_result[:L], right_result[:R]].max

    max_left_diameter += 1 if node.left
    max_right_diameter += 1 if node.right

    current_node_max_diameter = max_left_diameter + max_right_diameter
    max_diameter_so_far = [left_result[:M], right_result[:M], current_node_max_diameter].max

    return {
        L: max_left_diameter,
        R: max_right_diameter,
        M: max_diameter_so_far
    }
end

=begin
106 / 106 test cases passed.
Runtime: 40 ms
Memory Usage: 11.3 MB
=end

