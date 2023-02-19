fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    val res: MutableList<List<Int>> = mutableListOf(listOf(root.`val`))
    var currentLevelNodesQueue: List<TreeNode> = listOf(root)
    var remNextLevelNodesQueue: MutableList<TreeNode> = mutableListOf()
    var currentLevel = 0

    while (currentLevelNodesQueue.isNotEmpty()) {
        val resInner = mutableListOf<Int>()
        forLoop@ for (n in currentLevelNodesQueue) {
            if (n.left == null && n.right == null) continue@forLoop
            if (currentLevel % 2 == 1) {
                if (n.left != null) {
                    resInner.add(n.left!!.`val`)
                    remNextLevelNodesQueue.add(n.left!!)
                }
                if (n.right != null) {
                    resInner.add(n.right!!.`val`)
                    remNextLevelNodesQueue.add(n.right!!)
                }
            } else {
                if (n.right != null) {
                    resInner.add(n.right!!.`val`)
                    remNextLevelNodesQueue.add(n.right!!)
                }
                if (n.left != null) {
                    resInner.add(n.left!!.`val`)
                    remNextLevelNodesQueue.add(n.left!!)
                }
            }
        }

        if (resInner.isNotEmpty()) res.add(resInner)
        currentLevelNodesQueue = remNextLevelNodesQueue.reversed()
        remNextLevelNodesQueue = mutableListOf()
        currentLevel++
    }

    return res.toList()
}

/**
 *  Better version
 */
val binaryTreeZigzagLevelOrderTraversalRes: MutableList<MutableList<Int>> = mutableListOf()
fun zigzagLevelOrder1(root: TreeNode?): List<List<Int>> {
    zigzagLevelOrderImpl(root, 0)
    return binaryTreeZigzagLevelOrderTraversalRes
}

fun zigzagLevelOrderImpl(node: TreeNode?, level: Int) {
    if (node == null) return;
    val currentRow = binaryTreeZigzagLevelOrderTraversalRes.getOrElse(level) {
        mutableListOf<Int>().apply {
            binaryTreeZigzagLevelOrderTraversalRes.add(level, this)
        }
    }
    if (level % 2 == 0) {
        currentRow.add(node.`val`)
    } else {
        currentRow.add(0, node.`val`)
    }

    zigzagLevelOrderImpl(node.left, level + 1)
    zigzagLevelOrderImpl(node.right, level + 1)
}


//val ans = mutableListOf<MutableList<Int>>()
//fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
//    dfs(root, 0)
//    return ans
//}
//
//fun dfs(curr: TreeNode?, index: Int) {
//    if (curr != null) {
//        val row = ans.getOrElse(index) { mutableListOf<Int>().also { ans.add(it) } }
//        if (index % 2 == 0) row.add(curr.`val`)
//        else row.add(0, curr.`val`)
//
//        dfs(curr.left, index + 1)
//        dfs(curr.right, index + 1)
//    }
//}