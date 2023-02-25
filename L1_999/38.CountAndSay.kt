import java.lang.StringBuilder

fun countAndSay(n: Int): String {
    if (n == 1) return "1"

    val input = countAndSay(n - 1)
    var currentC = input.first()
    var count = 1
    val sb = StringBuilder()
    for (i in 1..input.lastIndex) {
        if (input[i] == currentC) {
            count++
        } else {
            sb.append("$count$currentC")
            currentC = input[i]
            count = 1
        }
    }

    sb.append("$count$currentC")

    return sb.toString()
}