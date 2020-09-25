# source: LeetCode
# https://leetcode.com/problems/product-of-array-except-self/

# 238. <medium> Product Of Array Except Self

=begin
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
=end

# @param {Integer[]} nums
# @return {Integer[]}
def product_except_self(nums)
    output = [1]
    product = nums[0]

    # multiply each num by the preceeding numbers
    # doing it one off from the start
    i = 1
    while i < nums.length
        output[i] = product
        product *= nums[i]
        i += 1
    end

    # go backward through the array.
    # multiply each number by the 'following' numbers
    # doing it one off from the end
    i = nums.length - 2
    product = nums[-1]
    while i >= 0
        output[i] *= product
        product *= nums[i]
        i -= 1
    end

    return output
end

=begin
18 / 18 test cases passed.
Runtime: 60 ms
Memory Usage: 13 MB
=end

