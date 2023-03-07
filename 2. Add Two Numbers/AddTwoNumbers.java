public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode nodes1 = new ListNode(2,
        new ListNode(4,
        new ListNode(3)));

        ListNode nodes2 = new ListNode(5,
        new ListNode(6,
        new ListNode(4)));

        ListNode solutionNode = solution.addTwoNumbers(nodes1, nodes2);

        ListNode nextNode = solutionNode;

        while(nextNode != null) { 
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
        }
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, Boolean... add1) {
        
        int solution = l1.val + l2.val;

        ListNode nextL1 = l1.next != null ? l1.next : new ListNode();
        ListNode nextL2 = l2.next != null ? l2.next : new ListNode();

        if(add1.length != 0 && add1[0] == true) solution += 1;
        if(l1.next == null && l2.next == null && solution / 10 < 1 ) return new ListNode(solution);
        
        return new ListNode(solution % 10, addTwoNumbers(nextL1, nextL2, solution / 10 >= 1));
    }

}