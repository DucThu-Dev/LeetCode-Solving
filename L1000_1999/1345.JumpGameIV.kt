fun minJumps(arr: IntArray): Int {
    if (arr.size <= 1) return 0
    if (arr.first() == arr.last()) return 1
    val n = arr.size

    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in arr.indices) {
        graph.getOrElse(arr[i]) { mutableListOf<Int>().also { graph[arr[i]] = it } }.add(i)
    }

    var curs = mutableListOf<Int>().also { it.add(0) }
    val visited = mutableSetOf<Int>()
    var step = 0

    while (curs.isNotEmpty()) {
        val nex = mutableListOf<Int>()

        for (nodeIndex in curs) {
            if (nodeIndex == n - 1) return step
            for (child in graph.get(arr[nodeIndex])!!) {
                if (!visited.contains(child)) {
                    visited.add(child)
                    nex.add(child)
                }
            }

            graph.get(arr[nodeIndex])!!.clear()

            if (nodeIndex + 1 < n && !visited.contains(nodeIndex + 1)) {
                visited.add(nodeIndex + 1)
                nex.add(nodeIndex + 1)
            }

            if (nodeIndex - 1 >= 0 && !visited.contains(nodeIndex - 1)) {
                visited.add(nodeIndex - 1)
                nex.add(nodeIndex - 1)
            }
        }

        curs = nex
        step++
    }

    return -1
}

fun main() {
    val result = minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404))

    println(result)
}

fun minJumpsPractice(arr: IntArray): Int {
    if (arr.size <= 1) return 0
    if (arr.first() == arr.last()) return 1

    val arraySize = arr.size
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val visitedIndex = mutableSetOf<Int>()
    var currents = mutableListOf<Int>(0)
    var steps = 0

    for (i in arr.indices) {
        graph.getOrElse(arr[i]) { mutableListOf<Int>().also { graph[arr[i]] = it } }.add(i)
    }

    while (currents.isNotEmpty()) {
        val nextIndexs = mutableListOf<Int>()

        for (index in currents) {
            if (index == arraySize - 1) return steps

            for (nodeIndex in graph[arr[index]]!!) {
                nextIndexs.add(nodeIndex)
                visitedIndex.add(nodeIndex)
            }

            if (index + 1 < arraySize && !visitedIndex.contains(index + 1)) {
                nextIndexs.add(index + 1)
                visitedIndex.add(index + 1)
            }

            if (index - 1 >= 0 && !visitedIndex.contains(index - 1)) {
                nextIndexs.add(index - 1)
                visitedIndex.add(index - 1)
            }
        }

        currents = nextIndexs
        steps++
    }

    return -1
}