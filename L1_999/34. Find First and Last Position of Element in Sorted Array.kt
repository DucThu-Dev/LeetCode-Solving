fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)
    var startResult = -1
    var endResult = -1
    var start = 0
    var end = nums.size - 1
    var temp = end / 2
    while (start < end) {
        if (nums[temp] == target) {
            startResult = temp
            endResult = temp
            break
        }
        if (nums[temp] < target) start = temp + 1 else end = temp
        temp = start + ((end - start) / 2)
    }
    if (start == end) {
        return if (nums[start] == target) {
            intArrayOf(start, start)
        } else {
            intArrayOf(-1, -1)
        }
    }
    temp = start + (startResult - start) / 2
    while (start < startResult) {
        if (nums[temp] == target) {
            startResult = temp
        } else {
            start = temp + 1
        }
        temp = start + (startResult - start) / 2
    }
    temp = endResult + (end - endResult) / 2
    while (end > endResult) {
        if (nums[temp] == target) {
            endResult = temp
        } else {
            end = temp - 1
        }
        temp = endResult + (end - endResult) / 2 + 1
    }
    return intArrayOf(startResult, endResult)
}