import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode oneV2 = new ListNode(1);

        Solution s = new Solution();

        ListNode test = s.removeNthFromEnd(oneV2, 1);

        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd(head, n, new ArrayList<ListNode>());
    }

    private ListNode removeNthFromEnd(ListNode head, int n, List<ListNode> listNodeList) {
        if (head == null) {

            int nodeToRemovePos = listNodeList.size() - n;

            if (n == 1 && listNodeList.size() == 1)
                return null;

            if (nodeToRemovePos - 1 == -1) {
                return listNodeList.get(nodeToRemovePos + 1);
            }

            if (nodeToRemovePos + 1 == listNodeList.size())
                listNodeList.get(nodeToRemovePos - 1).next = null;
            else
                listNodeList.get(nodeToRemovePos - 1).next = listNodeList.get(nodeToRemovePos + 1);

            return listNodeList.get(0);
        }

        listNodeList.add(head);

        return removeNthFromEnd(head.next, n, listNodeList);
    }
}