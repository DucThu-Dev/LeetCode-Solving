import java.lang.StringBuilder

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.contains("")) return ""
    val sb = StringBuilder()
    var stillMatch = true
    var i = 0
    while (stillMatch) {
        if (strs.first().length > i) {
            val currentChar = strs.first()[i]
            for (j in 1 until strs.size) {
                if (!(strs[j].length > i && strs[j][i] == currentChar)) {
                    stillMatch = false
                    break
                }
            }

            if (stillMatch) {
                sb.append(currentChar)
                i++
            }
        } else {
            stillMatch = false
        }
    }

    return sb.toString()
}

fun longestCommonPrefix1(strs: Array<String>): String {
    var res = ""

    for (i in 0..strs[0].lastIndex) {

        for (s in strs) {
            if (i >= s.length || s[i] != strs[0][i]) {
                return res
            }
        }

        res += strs[0][i]
    }

    return res
}