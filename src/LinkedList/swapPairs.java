package LinkedList;

public class swapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode previous = null;
		ListNode current = head;
		ListNode fake = current.next;
		ListNode next;
		while (current != null && current.next != null) {
			next = current.next;
			current.next = next.next;
			next.next = current;
			if (previous != null)
				previous.next = next;
			previous = current;
			current = current.next;
		}

		return fake;
	}
}
