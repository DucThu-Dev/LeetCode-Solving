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

/// Recursive version
fun isSymmetric1(root: TreeNode?): Boolean {
    return check(root?.left, root?.right)
}

fun check(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    if (left.`val` != right.`val`) return true

    return check(left.left, right.right) && check(left.right, right.left)
}