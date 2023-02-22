fun splitArray(nums: IntArray, k: Int): Int {
    var rNum = nums.sum() ?: 0
    var lNum = nums.max() ?: 0

    if (nums.size == 1) return rNum
    fun feasible(largest: Int): Boolean {
        var subCount = 1
        var total = 0
        for (n in nums) {
            total += n
            if (total > largest) {
                total = n
                if (++subCount > k) return false
            }
        }

        return true
    }

    while (lNum < rNum) {
        val midNum = lNum + (rNum - lNum) / 2
        if (feasible(midNum)) {
            rNum = midNum
        } else {
            lNum = midNum + 1
        }
    }

    return lNum
}