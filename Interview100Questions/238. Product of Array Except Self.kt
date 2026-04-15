package interview100questions

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val zeroCount = nums.fold(0) { acc, i -> acc + if (i == 0) 1 else 0 }
        if (zeroCount >= 2) return IntArray(nums.size) { 0 }

        if (zeroCount == 1) {
            val output = IntArray(nums.size)
            for (i in nums.indices) {
                if (nums[i] == 0) {
                    var acc = 1
                    for (j in nums.indices) {
                        if (j != i) acc *= nums[j]
                    }
                    output[i] = acc
                } else {
                    output[i] = 0
                }
            }

            return output
        }

        val allProduct = nums.fold(1) { acc, it -> acc * it }
        val output = IntArray(nums.size)
        for (i in nums.indices) {
            output[i] = allProduct / nums[i]
        }
        return output
    }
}

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeroCount = 0
        var acc = 1
        var zeroIndex = -1

        for (i in nums.indices) {
            if (nums[i] != 0) {
                acc *= nums[i]
            } else {
                zeroCount++
                zeroIndex = i
            }
        }

        if (zeroCount >= 2) return IntArray(nums.size) { 0 }

        if (zeroCount == 1) {
            return IntArray(nums.size) { i ->
                if(i == zeroIndex) acc else 0
            }
        }

        val output = IntArray(nums.size)
        for (i in nums.indices) {
            output[i] = acc / nums[i]
        }
        return output
    }
}