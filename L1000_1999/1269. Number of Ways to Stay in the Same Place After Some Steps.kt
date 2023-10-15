fun numWays(steps: Int, arrLen: Int): Int {
    fun navigate(steps: Int, index: Int): Int {
        if (steps == 0) {
            return if (index == 0) 1 else 0
        }
        var com = navigate(steps - 1, index)
        if (index < arrLen - 1) com += navigate(steps - 1, index + 1)
        if (index > 0) com += navigate(steps - 1, index - 1)
        return com
    }
    return navigate(steps - 1, 1) + navigate(steps - 1, 0)
}
