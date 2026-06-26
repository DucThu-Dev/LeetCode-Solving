package interview100questions

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        for(num in nums) {
            if(count.contains(num)) {
                count[num] = count[num]!! + 1
            } else {
                count[num] = 1
            }
        }

       return count.map { Pair(it.key, it.value) }.sortedBy { it.second }.takeLast(k).map { it.first }.toIntArray()
    }
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = HashMap<Int, Int>()

        for(num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val frequencyBucket = MutableList(nums.size + 1,{ mutableListOf<Int>() })

        for((num, frequency) in frequencyMap) {
            frequencyBucket[frequency].add(num)
        }

        val result = IntArray(k)
        var index = 0
        outer@ for(i in frequencyBucket.size - 1 downTo 0) {
            val list = frequencyBucket[i]
            for(num in list) {
                result[index++] = num
                if(index >= k) break@outer;
            }
        }
        return result
    }
}