# source: LeetCode
# https://leetcode.com/problems/single-number/

# 136. <easy> Single Number
=begin
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4
=end

# @param {Integer[]} nums
# @return {Integer}
def single_number(nums)
    possible = {}
    nums.each do |num|
        if possible[num].nil?
            possible[num] = true
        else
            possible[num] = false
        end
    end
    possible.each do |possible_num, seen_only_once|
        return possible_num if seen_only_once
    end
end

=begin
16 / 16 test cases passed.
Runtime: 40 ms
Memory Usage: 10.9 MB
=end

