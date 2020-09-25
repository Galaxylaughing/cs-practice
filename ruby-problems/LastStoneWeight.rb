# source: LeetCode
# https://leetcode.com/problems/last-stone-weight/

# 1046. <easy> Last Stone Weight
=begin
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.

At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
=end

# @param {Integer[]} stones
# @return {Integer}
def last_stone_weight(stones)
    return stones[0] if stones.length < 2
    loop do
        max = nil
        next_max = nil
        # find indices of heaviest stones
        stones.each_with_index do |weight, curr_stone|
            if max.nil? || weight > stones[max]
                next_max = max
                max = curr_stone
            elsif next_max.nil? || weight > stones[next_max]
                next_max = curr_stone
            end
        end
        # if either stone is "nil", we've reached the end
        if stones[max] == 0 || stones[next_max] == 0
            return stones[max] + stones[next_max]
        end

        # otherwise, smash the rocks together
        smash_result = stones[max] - stones[next_max]

        # set one index to the smash result and the other to "nil"
        stones[max] = smash_result
        stones[next_max] = 0
    end
end

=begin
70 / 70 test cases passed.
Runtime: 28 ms
Memory Usage: 9.2 MB
=end

