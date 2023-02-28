fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
    val repMap = HashMap<String, Int>()
    val result = mutableListOf<TreeNode?>()

    traversal(root, repMap, result)

    return result
}

fun traversal(root: TreeNode?, repMap: HashMap<String, Int>, result: MutableList<TreeNode?>): String {
    if (root == null) return ""
    val repNodeText = "(${traversal(root.left, repMap, result)})${root.`val`}(${traversal(root.right, repMap, result)})"
    repMap[repNodeText] = ((repMap[repNodeText] ?: 0) + 1).apply {
        if (this == 2) {
            result.add(root)
        }
    }
    return repNodeText
}
