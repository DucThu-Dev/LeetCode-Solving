fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.size == 1) {
        val oneLine = grid.first().sum()
        return oneLine
    }

    if (grid.isNotEmpty() && grid.first().size == 1) {
        val oneColumn = grid.fold(0) { acc, it -> acc + it.first() }
        return oneColumn
    }

    fun travelDown(): Int {
        return if (grid.size > 1) {
            val newGrid = grid.sliceArray(1 until grid.size)
            minPathSum(newGrid)
        } else {
            Int.MAX_VALUE
        }
    }

    fun travelRight(): Int {
        return if (grid.isNotEmpty() && grid.first().size > 1) {
            val currentLineSize = grid.first().size
            val newGrid = Array(grid.size) {
                grid[it].sliceArray(1 until currentLineSize)
            }
            minPathSum(newGrid)
        } else {
            Int.MAX_VALUE
        }
    }

    val min = Math.min(travelRight(), travelDown())

    val result = grid.first().first() + min
    return result
}

fun main() {
    val result = minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1)))
    println(result)
}