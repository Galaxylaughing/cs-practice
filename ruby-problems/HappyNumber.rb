# source: LeetCode
# https://leetcode.com/problems/happy-number/

# 202. <easy> Happy Number
=begin
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:

Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
=end

# @param {Integer} n
# @return {Boolean}
def is_happy(n)
    all_sums = {}
    done = false
    while !done
    current_sum = n.to_s.chars().map{ |d| d.to_i ** 2 }.sum()
    if current_sum == 1
      done = true
      return true
    elsif !all_sums[current_sum].nil?
      done = true
      return false
    else
      all_sums[current_sum] = true
      n = current_sum
    end
  end
end

=begin
401 / 401 test cases passed.
Runtime: 40 ms
Memory Usage: 9.3 MB
=end

