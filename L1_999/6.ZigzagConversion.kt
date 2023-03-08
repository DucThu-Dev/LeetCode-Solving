import java.lang.StringBuilder

fun convert(s: String, numRows: Int): String {
    val sb = StringBuilder()
    if (numRows == 1) return s
    val rem: MutableList<MutableList<Char>> = MutableList(numRows) { mutableListOf<Char>() }
    val phaseNodeCount = numRows * 2 - 2

    var rowIndex = 0
    for (i in s.indices) {
        val delta = i % phaseNodeCount
        if (delta < numRows) {
            rowIndex = delta
        } else {
            rowIndex = numRows - 2 - (delta - numRows)
        }
        rem[rowIndex].add(s[i])
    }

    for (l in rem) {
        for (c in l) {
            sb.append(c)
        }
    }

    return sb.toString()
}

fun main() {
    convert("PAYPALISHIRING", 3)
}