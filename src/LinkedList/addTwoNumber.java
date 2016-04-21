package LinkedList;

public class addTwoNumber {
   	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode lh1 = l1;
		ListNode lh2 = l2;
		int carry = 0;
		ListNode newHead = new ListNode(0);
		ListNode newNumber = newHead;

		while (lh1 != null || lh2 != null) {
			if (lh1 != null) {
				carry += lh1.val;
				lh1 = lh1.next;
			}

			if (lh2 != null) {
				carry += lh2.val;
				lh2 = lh2.next;
			}

			newNumber.next = new ListNode(carry % 10);
			carry = carry / 10;
			newNumber = newNumber.next;

		}

		if (carry != 0) {
			newNumber.next = new ListNode(carry);
		}

		return newHead.next;
	}
}
