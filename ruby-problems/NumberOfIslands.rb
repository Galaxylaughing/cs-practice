# source: LeetCode
# https://leetcode.com/problems/number-of-islands/

# 200. <medium> Number Of Islands

=begin
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
=end

WATER = '0'
LAND = '1'

def was_seen(coord, seen)
  return !seen[coord.first][coord.last].nil?
end

def inbounds(coord, grid)
  return coord.first >= 0 && coord.last >= 0 && coord.first < grid.length && coord.last < grid[0].length
end

# @param {Character[][]} grid
# @return {Integer}
def num_islands(grid)
  island_count = 0

  seen = Array.new(grid.length)
  for row_index in 0...grid.length
    seen[row_index] = Array.new(grid[row_index].length)
  end

  for row_index in 0...grid.length
    for column_index in 0...grid[row_index].length
      # if new land
      if grid[row_index][column_index] == LAND && !was_seen([row_index, column_index], seen)
        island_count += 1
        check_neighbors(grid, seen, row_index, column_index)
      end
    end
  end
  return island_count
end

def check_neighbors(grid, seen, row_index, column_index)
  top = [row_index-1, column_index]
  bottom = [row_index + 1, column_index]
  left = [row_index, column_index - 1]
  right = [row_index, column_index + 1]

  [top, bottom, left, right].each do |coord|
    if inbounds(coord, grid) && grid[coord.first][coord.last] == LAND && !was_seen(coord, seen)
      seen[coord.first][coord.last] = 1
      check_neighbors(grid, seen, coord.first, coord.last)
    end
  end
end

=begin
47 / 47 test cases passed.
Runtime: 92 ms
Memory Usage: 13.2 MB
=end

