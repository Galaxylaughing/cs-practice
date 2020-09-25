# source: LeetCode
# https://leetcode.com/problems/maximum-subarray/

# 53. <easy> Maximum Subarray
=begin
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [0]
Output: 0

Example 4:

Input: nums = [-1]
Output: -1

Example 5:

Input: nums = [-2147483647]
Output: -2147483647



Constraints:

    1 <= nums.length <= 2 * 104
    -231 <= nums[i] <= 231 - 1
=end

# @param {Integer[]} nums
# @return {Integer}
def max_sub_array(nums)
    return 0 if nums == nil
    return nil if nums.empty?
    
    current_max = nums[0]
    max_ending_here = 0
    
    nums.each do |num|
        max_ending_here = (max_ending_here < 0) ? (num) : (max_ending_here + num)
        if max_ending_here < 0
            max_ending_here = (current_max < 0) ? num : 0
        end
        if max_ending_here > current_max
            current_max = max_ending_here
        end
    end

    return current_max
end

=begin
202 / 202 test cases passed.
Runtime: 40 ms
Memory Usage: 9.9 MB
=end

