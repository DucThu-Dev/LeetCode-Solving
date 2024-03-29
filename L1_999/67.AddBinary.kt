fun addBinary(a: String, b: String): String {
    if (a == "0") return b
    if (b == "0") return a
    val aLength = a.length
    val bLength = b.length
    val largestLength = if (aLength > bLength) aLength else bLength
    val result = StringBuffer()
    var lastSumRem = "0";
    for (i in 0 until largestLength) {
        val aNum = a.getOrNull(aLength - i - 1)
        val bNum = b.getOrNull(bLength - i - 1)
        when ("${aNum ?: ""}${bNum ?: ""}") {
            "00", "0" -> {
                if (lastSumRem == "0") {
                    result.append("0")
                } else {
                    result.append("1")
                }
                lastSumRem = "0"
            }

            "01", "10", "1" -> {
                lastSumRem = if (lastSumRem == "0") {
                    result.append("1")
                    "0"
                } else {
                    result.append("0")
                    "1"
                }
            }

            "11" -> {
                if (lastSumRem == "0") {
                    result.append("0")
                } else {
                    result.append("1")
                }
                lastSumRem = "1"
            }
        }
    }

    if (lastSumRem == "1") {
        result.append("1")
    }

    return result.reversed().toString()
}

fun addBinary1(a: String, b: String): String {
    return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
}

fun addBinary2(a: String, b: String): String {
    if (a == "0") return b
    if (b == "0") return a

    var i = a.length - 1
    var j = b.length - 1
    var carry = false
    val sb = StringBuffer()

    while (i >= 0 || j >= 0) {
        var sum = if (carry) 1 else 0
        if (i >= 0) sum += a[i--] - '0'
        if (j >= 0) sum += b[j--] - '0'
        sb.append(sum % 2)
        carry = sum >= 2
    }

    if (carry) sb.append('1')
    sb.reverse()
    return sb.toString()
}