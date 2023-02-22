fun splitArray(nums: IntArray, k: Int): Int {

    var rNum = nums.count() ?: 0
    var lNum = nums.max() ?: 0

    if (k == 1) return rNum

    fun feasible(largest: Int): Boolean {
        var subCount = 1
        var total = 0
        for (n in nums) {
            subCount += n
            if (subCount > largest) {
                subCount = n
                total++
                if (n > k) return false
            }
        }
        return true
    }

    while (lNum < rNum) {
        val midNum = lNum + (rNum - lNum) / 2
        var feasible = feasible(midNum)
        if (feasible) {
            rNum = midNum
        } else {
            lNum = midNum + 1
        }
    }

    return lNum
}