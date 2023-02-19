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

        if(resInner.isNotEmpty()) res.add(resInner)
        currentLevelNodesQueue = remNextLevelNodesQueue.reversed()
        remNextLevelNodesQueue = mutableListOf()
        currentLevel++
    }

    return res.toList()
}