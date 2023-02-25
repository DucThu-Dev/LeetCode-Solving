import java.util.PriorityQueue

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    var remainProject = k
    var profitsList = profits.toMutableList()
    var capitalList = capital.toMutableList()
    var currentW = w
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> if ((o1 ?: 0) < (o2 ?: 0)) 1 else -1 }
    var canProcess = true

    fun getFeasibleCapital(): Int? {
        val remainProfitsList = mutableListOf<Int>()
        val remainCapitalList = mutableListOf<Int>()
        for (pIndex in profitsList.indices) {
            if (capitalList[pIndex] <= currentW) {
                priorityQueue.add(profitsList[pIndex])
            } else {
                remainCapitalList.add(capitalList[pIndex])
                remainProfitsList.add(profitsList[pIndex])
            }
        }

        if(priorityQueue.isEmpty()) {
            canProcess = false
        }

        profitsList = remainProfitsList
        capitalList = remainCapitalList

        return priorityQueue.poll()
    }

    do {
        val result = getFeasibleCapital()
        if (result != null) {
            println("Result is $result")
            currentW += result
            remainProject--
        }
    } while (remainProject > 0 && canProcess)

    return currentW
}

fun main() {
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> if ((o1 ?: 0) < (o2 ?: 0)) 1 else -1 }
    priorityQueue.add(5)
    priorityQueue.add(500)
    priorityQueue.add(250)
    priorityQueue.add(50)
    priorityQueue.add(10)
    while (priorityQueue.isNotEmpty()) {
        val result = priorityQueue.poll()
        println("Result is $result")
    }
}