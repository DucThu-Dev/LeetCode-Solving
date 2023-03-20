fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var i = 0
    var l = flowerbed.size
    var sequenceCount = 0
    var placeable = 0
    var haveBound = false
    while (i < l) {
        if (flowerbed[i] == 0) {
            sequenceCount++
        } else {
            if (!haveBound) {
                placeable += sequenceCount / 2
                haveBound = true
            } else {
                placeable += (sequenceCount - 1) / 2
            }

            sequenceCount = 0
        }
        i++
    }

    if (!haveBound) {
        placeable += (sequenceCount + 1) / 2
    } else {
        placeable += sequenceCount / 2
    }

    return placeable >= n
}