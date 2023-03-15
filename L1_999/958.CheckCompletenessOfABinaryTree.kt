fun isCompleteTree(root: TreeNode?): Boolean {
    var leveledNodes = mutableListOf(root)
    var continueCheck = true

    while (true) {
        val nex = mutableListOf<TreeNode?>()
        if (leveledNodes.all { it != null }) {

        } else {
            return validateLastLevel(leveledNodes)
        }
        leveledNodes.forEach {
            nex.add(it?.left)
            nex.add(it?.right)
        }
        leveledNodes = nex
    }

    return true
}

fun validateLastLevel(lastLevelNodes: List<TreeNode?>): Boolean {
    if (lastLevelNodes.first() == null) return lastLevelNodes.all { it == null }
    var nullIndex = -1;
    for (i in lastLevelNodes.indices) {
        if (lastLevelNodes[i] == null) {
            nullIndex = i
            break
        }
    }

    if (nullIndex < lastLevelNodes.lastIndex) {
        if (!lastLevelNodes.subList(nullIndex + 1, lastLevelNodes.size).all { it == null }) {
            return false
        }
    }

    val subNodes = mutableListOf<TreeNode?>()
    for (i in 0 until nullIndex) {
        subNodes.add(lastLevelNodes[i]?.left)
        subNodes.add(lastLevelNodes[i]?.right)
    }
    return subNodes.all { it == null }
}


/// Cleaner
fun isCompleteTreeCleaner(root: TreeNode?): Boolean {
    if (root == null) return true
    val nodes = mutableListOf<TreeNode?>(root)
    var index = 0
    while (nodes[index] != null) {
        nodes.add(nodes[index]?.left)
        nodes.add(nodes[index]?.right)
        index++
    }

    for (i in index + 1..nodes.lastIndex) {
        if (nodes[i] != null) return false
    }

    return true
}