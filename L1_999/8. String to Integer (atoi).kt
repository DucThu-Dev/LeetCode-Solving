fun myAtoi(s: String): Int {
    var index = 0
    while (index < s.length && s[index] == ' ') {
        index++
    }
    var sign = 1
    if (index < s.length && (s[index] == '+' || s[index] == '-')) {
        sign = if (s[index] == '-') -1 else 1
        index++
    }

    var number = ""
    while (index < s.length && s[index].isDigit()) {
        number += s[index]
        index++
    }

    return if (number.isEmpty()) 0 else (number.toIntOrNull()
        ?: (if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE)) * sign
}