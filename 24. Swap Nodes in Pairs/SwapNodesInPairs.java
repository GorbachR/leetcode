import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode a = generateListNode(Arrays.asList(1, 2, 3, 4));

        Solution s = new Solution();

        ListNode result = s.swapPairs(a);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
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

// Pointer hell
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode first = head;
        ListNode prev = new ListNode(0, first);
        ListNode newFirst = prev;

        while (first != null && first.next != null) {

            ListNode second = first.next;
            ListNode nextValue = second.next;

            prev.next = second;
            second.next = first;
            first.next = nextValue;

            prev = first;
            first = nextValue;
        }
        return newFirst.next;
    }
}