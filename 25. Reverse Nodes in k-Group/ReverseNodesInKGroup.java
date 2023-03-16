import java.util.Arrays;
import java.util.List;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode a = generateListNode(Arrays.asList(1, 2, 3, 4));
        Solution s = new Solution();

        ListNode result = s.reverseKGroup(a, 2);

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

// EZ
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode[] currentValues = new ListNode[k];

        ListNode first = head;
        ListNode prev = new ListNode(0, first);
        ListNode newFirst = prev;

        currentValues = populateArr(currentValues, first);
        while (currentValues != null) {
            populateArr(currentValues, first);

            ListNode nextVal = currentValues[currentValues.length - 1].next;

            for (int i = currentValues.length - 1; i > 0; i--) {
                currentValues[i].next = currentValues[i - 1];
            }

            prev.next = currentValues[currentValues.length - 1];
            currentValues[0].next = nextVal;
            prev = currentValues[0];
            first = nextVal;

            currentValues = populateArr(currentValues, first);
        }

        return newFirst.next;
    }

    private ListNode[] populateArr(ListNode[] values, ListNode start) {
        ListNode newStart = start;
        for (int i = 0; i < values.length; i++, newStart = newStart.next) {
            if (newStart != null)
                values[i] = newStart;
            else
                return null;
        }
        return values;
    }
}