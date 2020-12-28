package linkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode last = dummy.next;

        for(int i=0; i<n; i++) {
            last = last.next;
        }


        while(last!=null) {
            first = first.next;
            last = last.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList runClass = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);

        ListNode p = head;
        for(int i = 2; i<= 5; i++){
            p.next = new ListNode(i);
            p = p.next;
        }

        System.out.println("input listnode is: ");


        ListNode result = runClass.removeNthFromEnd(head, 2);
        while(result!=null) {
            System.out.println(result.val);
            result= result.next;
        }

    }
}
