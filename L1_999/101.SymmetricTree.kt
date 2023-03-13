import java.lang.StringBuilder

fun isSymmetric(root: TreeNode?): Boolean {
    var curLeft: List<TreeNode?> = listOf(root?.left)
    var curRight: List<TreeNode?> = listOf(root?.right)

    while (curLeft.isNotEmpty() && curRight.isNotEmpty()) {
        val genLeft = buildNodesTextRepresent(curLeft)
        val genRight = buildNodesTextRepresent(curRight.reversed())
        if (genLeft != genRight) return false

        curLeft = buildNextNodes(curLeft)
        curRight = buildNextNodes(curRight)
    }

    return true
}

fun buildNodesTextRepresent(l: List<TreeNode?>): String {
    val sb = StringBuilder()
    for (n in l) {
        sb.append(n?.`val` ?: "$")
    }

    return sb.toString()
}

fun buildNextNodes(l: List<TreeNode?>): List<TreeNode?> {
    val result = mutableListOf<TreeNode?>()
    for (n in l) {
        if (n != null) {
            result.add(n.left)
            result.add(n.right)
        }
    }

    return result
}