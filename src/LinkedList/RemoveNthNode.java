package LinkedList;

public class RemoveNthNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}

		if (fast == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
