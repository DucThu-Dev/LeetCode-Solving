fun sumNumbers(root: TreeNode?): Int {
    if (root == null) return 0
    val allNums = mutableListOf<Int>()
    execute(root, root.`val`, allNums)

    return allNums.fold(0) { curr, e ->
        curr + e
    }
}

fun execute(node: TreeNode, cur: Int, allNums: MutableList<Int>) {
    if (node.left == null && node.right == null) {
        allNums.add(cur)
    } else {
        node.left?.let {
            execute(node.left!!, cur * 10 + node.left!!.`val`, allNums)
        }
        node.right?.let {
            execute(node.right!!, cur * 10 + node.right!!.`val`, allNums)
        }
    }
}