fun main() {
    val avlTree = AVLTree().apply {
        insert(1)
        insert(4)
        insert(7)
        insert(2)
        insert(3)
        insert(5)
        insert(6)
    }

    println(avlTree)
}

class AVLTree {
    var root: AVLNode? = null

    fun insert(value: Int) {
        root = insert(value, root)
    }

    fun insert(value: Int, node: AVLNode?): AVLNode {
        node ?: return AVLNode(value)
        if (value >= node.value) {
            node.right = insert(value, node.right)
        } else {
            node.left = insert(value, node.left)
        }

        val balanceNode = balance(node)
        balanceNode.height = Math.max(balanceNode.leftHeight, balanceNode.rightHeight) + 1
        return balanceNode
    }

    fun balance(node: AVLNode): AVLNode {
        return when (node.balanceFactor) {
            2 -> {
                if (node.left?.balanceFactor == -1) {
                    return rotateLeftRight(node)
                } else {
                    return rotateRight(node)
                }
            }

            -2 -> {
                if (node.right?.balanceFactor == 1) {
                    return rotateRightLeft(node)
                } else {
                    return rotateLeft(node)
                }
            }

            else -> node
        }
    }

    fun rotateLeft(node: AVLNode): AVLNode {
        val pivot = node.right!!
        pivot.left = node
        node.right = null

        node.height = Math.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Math.max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    fun rotateRight(node: AVLNode): AVLNode {
        val pivot = node.left!!
        pivot.right = node
        node.left = null

        node.height = Math.max(node.leftHeight, node.rightHeight) + 1
        pivot.height = Math.max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    fun rotateLeftRight(node: AVLNode): AVLNode {
        val leftNode = node.left ?: return node
        node.left = rotateLeft(leftNode)
        return rotateRight(node)
    }

    fun rotateRightLeft(node: AVLNode): AVLNode {
        val rightNode = node.right ?: return node
        node.right = rotateLeft(rightNode)
        return rotateLeft(node)
    }

    override fun toString(): String {
        return root.toString()
    }
}

class AVLNode(var value: Int) {
    var left: AVLNode? = null
    var right: AVLNode? = null
    var height = 0

    val leftHeight: Int
        get() = left?.height ?: -1

    val rightHeight: Int
        get() = right?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

    fun printNode() {
        print("[left: (${left?.printNode() ?: "null"})] $value right[(${right?.printNode() ?: "null"})]")
    }

    override fun toString() = diagram(this)
    private fun diagram(
        node: AVLNode?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.left,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }
}