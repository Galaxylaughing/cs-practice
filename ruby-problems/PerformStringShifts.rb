# source: LeetCode
# https://leetcode.com/problems/perform-string-shifts/

# problem was subscription-locked between when I coded this problem 
# and when I added it to github, so I can no longer access the information.

def reverse(string, start_index, last_index)
  while start_index < last_index
    temp = string[start_index]
    string[start_index] = string[last_index]
    string[last_index] = temp

    start_index += 1
    last_index -= 1
  end
  return string
end
# @param {String} s
# @param {Integer[][]} shift
# @return {String}
def string_shift(s, shift)
  s_length = s.length
  shift_count = 0
  shift.each do |info_pair|
    if info_pair[0] == 0
      shift_count -= info_pair[1]
    else
      shift_count += info_pair[1]
    end
  end
  shift_count = shift_count % s_length
  if shift_count > 0
    divider = s_length - shift_count
    # reverse each side
    front_half = reverse(s, 0, divider - 1)
    back_half = reverse(s, divider, s.length - 1)
    # reverse whole
    s = reverse(s, 0, s_length - 1)
  end
  return s
end

=begin
31 / 31 test cases passed.
Runtime: 32 ms
Memory Usage: 9.3 MB
=end
