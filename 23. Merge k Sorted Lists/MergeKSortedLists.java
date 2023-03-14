import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a = generateListNode(Arrays.asList(1, 4, 5));
        ListNode b = generateListNode(Arrays.asList(1, 3, 4));
        ListNode c = generateListNode(Arrays.asList(2, 6));

        s.mergeKLists(new ListNode[] { a, b, c });
    }

    static ListNode generateListNode(List<Integer> input) {

        ListNode first = new ListNode(input.get(0));
        ListNode current = first;

        for (int i = 1; i < input.size(); i++) {
            current.next = new ListNode(input.get(i));
            current = current.next;
        }

        return first;
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

// Optimized for time complexity, merge method with divide and conquer approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        return divideAndMerge(lists);
    }

    private ListNode divideAndMerge(ListNode[] lists) {

        if (lists.length == 1)
            return lists[0];

        ListNode[] newLists;

        if (lists.length % 2 == 0)
            newLists = new ListNode[lists.length / 2];
        else {
            newLists = new ListNode[(lists.length / 2) + 1];
            newLists[newLists.length - 1] = lists[lists.length - 1];
        }

        for (int i = 0, j = 0; i < lists.length - 1; i += 2, j++) {
            newLists[j] = merge(lists[i], lists[i + 1]);
        }

        return divideAndMerge(newLists);
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode();
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

        if (list1 == null)
            tail.next = list2;
        else if (list2 == null)
            tail.next = list1;

        return dummyNode.next;
    }
}