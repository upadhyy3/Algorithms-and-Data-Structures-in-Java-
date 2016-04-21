package LinkedList;

public class ListPartition {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode current = head;
		ListNode fakeHead = new ListNode(0);
		ListNode newHead = fakeHead;
		ListNode previous = null;
		boolean flag = true;
		ListNode newHead2 = null;
		while (current != null) {
			if (current.val < x) {
				while (current != null && current.val < x) {
					fakeHead.next = current;
					current = current.next;
					fakeHead = fakeHead.next;
				}
				fakeHead.next = null;
				if (previous != null)
					previous.next = current;
			}

			if (flag) {
				newHead2 = current;
				flag = false;
			}
			previous = current;
			if (current != null)
				current = current.next;
		}

		fakeHead.next = newHead2;
		return newHead.next;
	}
}
