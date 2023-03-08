fun maxArea(height: IntArray): Int {
    var max = 0
    for (i in 0 until height.lastIndex) {
        if (height[i] * (height.lastIndex - i) < max) continue
        for (j in i + 1 until height.size) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i))
            println(max)
        }
    }

    return max
}

fun maxAreaImprovement(height: IntArray): Int {
    var max = 0
    var start = 0
    var end = height.lastIndex
    while (start < end) {
        max = Math.max(max, Math.min(height[start], height[end]) * (end - start))
        if (height[start] < height[end]) start++ else end--
    }

    return max
}