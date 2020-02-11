package top.bcoder.algorithm.offercode;

/**
 * @author zln
 * @date 2020/2/11
 */
public class Test8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //基础条件判断
        if (pNode == null) {
            return pNode;
        }

        //如果存在右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //不存在右子树的情况
        while (pNode.next != null) {
            //找第一个当前节点是父节点左孩子的节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;


    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}