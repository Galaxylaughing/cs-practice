# source: LeetCode
# https://leetcode.com/problems/move-zeroes/

# 283. <easy> Move Zeroes
=begin
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
=end

def swap(array, index_1, index_2)
  temp = array[index_1]
  array[index_1] = array[index_2]
  array[index_2] = temp
end
# @param {Integer[]} nums
# @return {Void} Do not return anything, modify nums in-place instead.
def move_zeroes(nums)
  length = nums.length()
  i = 0
  j = 1
  while i < length && j < length
    if nums[i] == 0 && nums[j] != 0
      swap(nums, i, j)
      i += 1
      j += 1
    elsif nums[i] == 0 && nums[j] == 0
      j += 1
    else
      i += 1
      j += 1
    end
  end
end

=begin
21 / 21 test cases passed.
Runtime: 40 ms
Memory Usage: 9.8 MB
=end

