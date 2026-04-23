package interview100questions

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var count = 0

        fun traverse(i: Int, j: Int) {
            if (i !in 0..<m) return
            if (j !in 0..<n) return
            if (grid[i][j] == '0') return

            grid[i][j] = '0'
            traverse(i + 1, j)
            traverse(i, j + 1)
            traverse(i - 1, j)
            traverse(i, j - 1)

        }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == '1') {
                    count++
                    traverse(i, j)
                }
            }
        }

        return count
    }
}