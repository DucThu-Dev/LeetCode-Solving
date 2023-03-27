// Time Limit Out
//fun minPathSum(grid: Array<IntArray>): Int {
//    if (grid.size == 1) {
//        return grid.first().sum()
//    }
//
//    if (grid.isNotEmpty() && grid.first().size == 1) {
//        return grid.fold(0) { acc, it -> acc + it.first() }
//    }
//
//    fun travelDown(): Int {
//        return if (grid.size > 1) {
//            val newGrid = grid.sliceArray(1 until grid.size)
//            minPathSum(newGrid)
//        } else {
//            Int.MAX_VALUE
//        }
//    }
//
//    fun travelRight(): Int {
//        return if (grid.isNotEmpty() && grid.first().size > 1) {
//            val currentLineSize = grid.first().size
//            val newGrid = Array(grid.size) {
//                grid[it].sliceArray(1 until currentLineSize)
//            }
//            minPathSum(newGrid)
//        } else {
//            Int.MAX_VALUE
//        }
//    }
//
//    val min = Math.min(travelRight(), travelDown())
//
//    return grid.first().first() + min
//}

// Cloned from Vozer
fun minPathSum(grid: Array<IntArray>): Int {
    val height = grid.size
    val width = grid.first().size

    val min: MutableList<IntArray> = MutableList(height) {
        IntArray(width)
    }
    min[0][0] = grid[0][0]

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (i > 0 && j > 0) {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j]
            } else if (i > 0) {
                min[i][j] = min[i - 1][j] + grid[i][j]
            } else if (j > 0) {
                min[i][j] = min[i][j - 1] + grid[i][j]
            }
        }
    }

    return min[height - 1][width - 1]
}

fun main() {
    minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1)))
}

fun minPathSumPractice(grid: Array<IntArray>): Int {
    val height = grid.size
    val width = grid[0].size
    val min = MutableList(height) { IntArray(width) }

    min[0][0] = grid[0][0]

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (i > 0 && j > 0) {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j]
            } else if (i > 0) {
                min[i][j] = min[i - 1][j] + grid[i][j]
            } else if (j > 0) {
                min[i][j] = min[i][j - 1] + grid[i][j]
            }
        }
    }

    return min[height - 1][width - 1]
}