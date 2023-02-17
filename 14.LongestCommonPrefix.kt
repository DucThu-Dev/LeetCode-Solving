import java.lang.StringBuilder

fun longestCommonPrefix(strs: Array<String>): String {
    val sb = StringBuilder()
    var stillMatch = true
    var i = 0
    while (stillMatch) {
        val currentChar = strs.first()[i]
        for (j in 1 until strs.size) {
            if (strs[j][i] != currentChar) {
                stillMatch = false
                break
            }
        }

        if (stillMatch) {
            sb.append(currentChar)
            i++
        }
    }

    return sb.toString()
}