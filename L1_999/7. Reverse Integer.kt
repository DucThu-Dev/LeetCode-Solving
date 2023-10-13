fun reverse(x: Int): Int {
    val multiply = if (x < 0) -1 else 1
    val reverse = x.toString().reversed().removeSuffix("-")
    val result = reverse.toLong() * multiply
    return if (is32Bit(result)) result.toInt() else 0
}

fun is32Bit(num: Long): Boolean {
    val intVal = num.toInt()
    return intVal.toLong() == num
}