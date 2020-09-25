# source: LeetCode
# https://leetcode.com/problems/counting-elements/

# problem was subscription-locked between when I coded this problem
# and when I added it to github, so I can no longer access the information.

# @param {Integer[]} arr
# @return {Integer}
require 'set'
def count_elements(arr)
    total = 0
    nums_in_list = Set.new
    arr.each do |num|
        nums_in_list << num
    end
    arr.each do |num|
        if nums_in_list.include?(num + 1)
            total += 1
        end
    end
    return total
end

=begin
35 / 35 test cases passed.
Runtime: 32 ms
Memory Usage: 9.4 MB
=end

