class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        val topLeftValue = grid[0][0]
        val gridSize = grid.first().size
        var isLeaf = true

        out@ for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                if (grid[i][j] != topLeftValue) {
                    isLeaf = false
                    break@out
                }
            }
        }

        if (isLeaf) {
            return Node(topLeftValue == 1, isLeaf)
        }

        val topLeftGrid: Array<IntArray> = subGrid(grid, 0, 0, gridSize / 2)
        val topRightGrid: Array<IntArray> = subGrid(grid, gridSize / 2, 0, gridSize / 2)
        val bottomLeftGrid: Array<IntArray> = subGrid(grid, 0, gridSize / 2, gridSize / 2)
        val bottomRightGrid: Array<IntArray> = subGrid(grid, gridSize / 2, gridSize / 2, gridSize / 2)

        return Node(true, false).apply {
            topLeft = construct(topLeftGrid)
            topRight = construct(topRightGrid)
            bottomLeft = construct(bottomLeftGrid)
            bottomRight = construct(bottomRightGrid)
        }
    }

    fun subGrid(originalGrid: Array<IntArray>, startHorizontal: Int, startVertical: Int, size: Int): Array<IntArray> {
        val result = Array<IntArray>(size) { IntArray(size) }
        for (i in 0 until size) {
            for (j in 0 until size) {
                result[i][j] = originalGrid[i + startHorizontal][j + startVertical]
            }
        }
        return result
    }
}