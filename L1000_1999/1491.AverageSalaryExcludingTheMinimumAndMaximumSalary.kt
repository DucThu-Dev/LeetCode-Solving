fun average(salary: IntArray): Double {
    var max: Int = salary[0]
    var min: Int = salary[1]

    if(max < min) min = max.also { max = min }

    var sum: Int = 0

    for(index in 2 until salary.size) {
        if(salary[index] > max) {
            sum += max
            max = salary[index]
        } else if(salary[index] < min) {
            sum += min
            min = salary[index]
        } else {
            sum += salary[index]
        }
    }

    return sum.toDouble() / ( salary.size - 2)
}