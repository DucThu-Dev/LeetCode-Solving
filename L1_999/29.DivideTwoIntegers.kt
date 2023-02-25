fun divide(dividend: Int, divisor: Int): Int {
    val result = dividend.toDouble() / divisor.toDouble()
    return if (result > 0) Math.floor(result).toInt() else Math.ceil(result).toInt()
}