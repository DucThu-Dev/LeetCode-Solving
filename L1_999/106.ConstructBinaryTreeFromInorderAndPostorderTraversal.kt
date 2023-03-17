fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty()) return null
    val rootVal = postorder.last()
    val indexOfRootNodeIO = inorder.indexOf(rootVal)
    val leftIO = inorder.copyOfRange(0, indexOfRootNodeIO)
    val leftPO = postorder.copyOfRange(0, indexOfRootNodeIO)
    val rightIO = inorder.copyOfRange(indexOfRootNodeIO + 1, inorder.size)
    val rightPO = postorder.copyOfRange(indexOfRootNodeIO, postorder.lastIndex)

    val root = TreeNode(rootVal)
    root.left = buildTree(leftIO, leftPO)
    root.right = buildTree(rightIO, rightPO)

    return root
}