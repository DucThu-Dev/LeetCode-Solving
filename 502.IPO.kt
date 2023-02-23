fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    var remainProject = k
    val profitsList = profits.toMutableList()
    val capitalList = capital.toMutableList()
    var currentW = w

    fun getFeasibleCapital(): Int? {
        var maxBenefit = 0
        var maxIndex: Int? = null

        for (pIndex in profitsList.indices) {
            println("pIndex $pIndex")
            if (capitalList[pIndex] <= currentW) {
                if (profitsList[pIndex] > maxBenefit) {
                    maxBenefit = profitsList[pIndex]
                    maxIndex = pIndex
                }
            }
        }
        return if (maxIndex != null) {
            val result = profitsList[maxIndex]
            profitsList.removeAt(maxIndex)
            capitalList.removeAt(maxIndex)
            result
        } else {
            null
        }
    }

    while (remainProject > 0 && profitsList.isNotEmpty()) {
        println("Current profitsList length is ${profitsList.size} ${capitalList.size}")
        currentW += getFeasibleCapital() ?: 0
        remainProject--
    }

    return currentW
}

fun main() {
    val result = findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1))
    println(result)
}