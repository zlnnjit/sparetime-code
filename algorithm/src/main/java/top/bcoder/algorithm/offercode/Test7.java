package top.bcoder.algorithm.offercode;

import org.junit.Test;

/**
 * @author zln
 * @date 2020/2/11
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Test7 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length < 1 || in.length < 1) {
            return null;
        }
        if (pre.length != in.length) {
            throw new RuntimeException("Error Tree Data");
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStartIndex, int preEndIndex, int[] in, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex) {
            return null;
        }
        int value = pre[preStartIndex];
        int index = 0;

        while (index <= inEndIndex && in[index] != value) {
            index++;
        }

        if (index > inEndIndex) {
            throw new RuntimeException("Error Tree Data");
        }

        TreeNode treeNode = new TreeNode(value);
        treeNode.left = reConstructBinaryTree(pre,
                preStartIndex + 1,
                preStartIndex + index - inStartIndex,
                in, inStartIndex, index - 1);

        treeNode.right = reConstructBinaryTree(pre,
                preStartIndex + index - inStartIndex + 1,
                preEndIndex,
                in, index + 1, inEndIndex);
        return treeNode;
    }

    // 中序遍历二叉树
    public void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }

    @Test
    public void test1() {
        int[] preorder = {1,2,3,4,5,6,7};
        int[] inorder = {3,2,4,1,6,5,7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
