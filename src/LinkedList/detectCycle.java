package LinkedList;

public class detectCycle {

    public ListNode detectCycl(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && fast.val != slow.val ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) return null;
        fast = head;
        while(fast.val != slow.val){
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
