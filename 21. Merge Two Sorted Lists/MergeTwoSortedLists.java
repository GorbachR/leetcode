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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;

            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null)
            tail.next = list1;
        else if (list2 != null)
            tail.next = list2;

        return dummyNode.next;
    }
}