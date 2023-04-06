/// Cloned from Editorial
fun closedIsland(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid.first().size

    val visit = MutableList(m) {
        MutableList(n) { false }
    }

    var count = 0

    fun bfs(x: Int, y: Int): Boolean {
        var x = x
        var y = y

        val q = mutableListOf<IntArray>()
        q.add(intArrayOf(x, y))
        visit[x][y] = true
        var isClosed = true
        val dirx = intArrayOf(0, 1, 0, -1)
        val diry = intArrayOf(-1, 0, 1, 0)

        while (q.isNotEmpty()) {
            val temp = q.removeAt(0)
            x = temp[0]
            y = temp[1]

            for (i in 0 until 4) {
                val r = x + dirx[i]
                val c = y + diry[i]
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    isClosed = false
                } else if (grid[r][c] == 0 && !visit[r][c]) {
                    q.add(intArrayOf(r, c))
                    visit[r][c] = true
                }
            }
        }

        return isClosed
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 0 && !visit[i][j] && bfs(i, j)) {
                count++
            }
        }
    }

    return count
}