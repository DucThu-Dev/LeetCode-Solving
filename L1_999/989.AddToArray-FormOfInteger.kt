class AddToArrayFormOfInteger {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val firstNum = num.joinToString(separator = "") { it -> it.toString() }.toBigInteger()
        return (firstNum + k.toBigInteger()).toString().asIterable().map { it -> it.toString().toInt() }
    }
}