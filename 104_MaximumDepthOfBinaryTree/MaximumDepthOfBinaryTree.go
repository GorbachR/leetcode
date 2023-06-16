package MaximumDepthOfBinaryTree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	return treeTraversal(root, 0)
}

func treeTraversal(node *TreeNode, count int) int {
	if node == nil {
		return count
	}
	count++

	leftMax, rightMax := treeTraversal(node.Left, count), treeTraversal(node.Right, count)

	if leftMax > rightMax {
		return leftMax
	} else {
		return rightMax
	}
}
