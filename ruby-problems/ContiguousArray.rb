# source: LeetCode
# https://leetcode.com/problems/contiguous-array/

# 525. <medium> Contiguous Array

=begin
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.
=end

# @param {Integer[]} nums
# @return {Integer}
def find_max_length(nums)
    max_window_length = 0
    first_occurrence = { 0 => -1 }
    equal = 0
    for i in 0...nums.length do
        equal += nums[i] == 0 ? 1 : -1
        if first_occurrence.key?(equal)
            max_window_length = [max_window_length, i - first_occurrence[equal]].max
        else
            first_occurrence[equal] = i
        end
    end
    return max_window_length
end

=begin
555 / 555 test cases passed.
Runtime: 156 ms
Memory Usage: 18 MB
=end

