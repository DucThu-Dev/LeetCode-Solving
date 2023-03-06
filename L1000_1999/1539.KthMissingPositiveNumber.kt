fun findKthPositive(arr: IntArray, k: Int): Int {
    val n = arr.size
    var remain = k
    var rem = -1
    var current = 1
    var checkIndex = 0
    while (remain > 0) {
        if (checkIndex < n && arr[checkIndex] == current) {
            checkIndex++
        } else {
            rem = current
            remain--
        }
        current++
    }

    return rem
}

fun main() {
    val result = findKthPositive(intArrayOf(1, 2, 3, 4), 2)
    print(result)
}