package interview100questions

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            val rowMark = HashSet<Char>()
            for (j in board.indices) {
                val value = board[i][j]
                if (value == '.') continue
                if (!rowMark.add(value)) return false
            }
        }

        for (i in board.indices) {
            val columnMark = HashSet<Char>()
            for (j in board.indices) {
                val value = board[j][i]
                if (value == '.') continue
                if (!columnMark.add(value)) return false
            }
        }

        for (row in 0 until 3) {
            for (col in 0 until 3) {
                val blockMark = HashSet<Char>()
                for (i in 0 until 3) {
                    for (j in 0 until 3) {
                        val value = board[row * 3 + i][col * 3 + j]
                        if (value == '.') continue
                        if (!blockMark.add(value)) return false
                    }
                }
            }
        }

        return true
    }
}

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        fun isValid(fromRow: Int, toRow: Int, fromCol: Int, toCol: Int): Boolean {
            val set = HashSet<Char>()
            for (i in fromRow..toRow) {
                for (j in fromCol..toCol) {
                    val char = board[i][j]
                    if (char == '.') continue
                    if (!set.add(char)) return false
                }
            }

            return true
        }

        for (i in board.indices) {
            val isRowValid = isValid(i, i, 0, board.size - 1)
            if(!isRowValid) return false
        }

        for (i in board.indices) {
            val isColValid = isValid(0, board.size - 1, i, i)
            if(!isColValid) return false
        }

        for(i in 0..2) {
            for(j in 0..2) {
                val isBlockValid = isValid(i * 3, (i + 1) * 3 - 1, j *3, (j + 1) * 3 - 1)
                if(!isBlockValid) return false
            }
        }

        return true
    }
}