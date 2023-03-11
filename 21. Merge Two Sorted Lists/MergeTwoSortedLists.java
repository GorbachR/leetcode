public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode cList1 = new ListNode(4);
        ListNode bList1 = new ListNode(2, cList1);
        ListNode aList1 = new ListNode(1, bList1);

        ListNode cList2 = new ListNode(4);
        ListNode bList2 = new ListNode(3, cList2);
        ListNode aList2 = new ListNode(1, bList2);

        System.out.println(s.mergeTwoLists(aList1, aList2));
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

// According to leetcode fairly memory inefficient ( O(n) ) but most
// concise and easy to understand solution since you forego silly conditon
// juggling
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode headNode = list1.val < list2.val ? list1 : list2;

        if (headNode == list1)
            doMerge(list1.next, list2, headNode);
        else
            doMerge(list1, list2.next, headNode);

        return headNode;
    }

    private void doMerge(ListNode list1, ListNode list2, ListNode currentNode) {
        if (list1 == null) {
            currentNode.next = list2;
            return;
        }

        if (list2 == null) {
            currentNode.next = list1;
            return;
        }

        else if (list1.val < list2.val) {
            currentNode.next = list1;
            doMerge(list1.next, list2, currentNode.next);
        }

        else {
            currentNode.next = list2;
            doMerge(list1, list2.next, currentNode.next);
        }
    }
}