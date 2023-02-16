fun addBinary(a: String, b: String): String {
    val largestLength = if (a.length > b.length) a.length else b.length
    val result = StringBuffer()
    var lastSumRem = "0";
    for (i in (0 until largestLength).reversed()) {
        val aNum = a.getOrNull(i)
        val bNum = b.getOrNull(i)
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
                    result.append("")
                } else {
                    result.append("1")
                }
                lastSumRem = "1"
            }
        }
    }

    return result.reversed().toString()
}