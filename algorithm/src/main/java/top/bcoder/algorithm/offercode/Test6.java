package top.bcoder.algorithm.offercode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zln
 * @date 2020/2/11
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Test6 {
    //栈
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> result = new ArrayList<>();
//        if (listNode == null) {
//            return result;
//        }
//        //将链表信息放到栈中
//        Stack<Integer> tempStack = new Stack<>();
//        while (listNode != null) {
//            tempStack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!tempStack.empty()) {
//            result.add(tempStack.pop());
//        }
//        return result;
//    }

    //递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        return print(listNode, result);
    }

    private ArrayList<Integer> print(ListNode listNode, ArrayList<Integer> result) {
        if (listNode != null) {
            print(listNode.next, result);
            result.add(listNode.val);
        }
        return result;
    }

    @Test
    public void test() {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ArrayList<Integer> integers = printListFromTailToHead(root);

    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

