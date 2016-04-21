package LinkedList;

public class sortedListToBST {
	 public TreeNode sortedListToBST(ListNode head) {
	        if(head == null) return null;
	        TreeNode root = helper(head);
	        return root;
	        }
	        public TreeNode helper(ListNode head) {
	            if(head == null) return null;
	            ListNode start = head;
	            ListNode slowPointer = head;
	            ListNode fastPointer = head;
	            ListNode previous = null;
	            ListNode next = null;
	            
	            while(fastPointer !=null && fastPointer.next!=null && fastPointer.next.next!=null){
	            	previous = slowPointer;
	            	slowPointer = slowPointer.next;
	                fastPointer = fastPointer.next.next;
	                
	            }
	            
	            TreeNode current = new TreeNode(slowPointer.val);
	            if(previous!=null) previous.next = null;
	            if(start == slowPointer){
	            	current.left = null;
	            //	slowPointer.next = null;
	            }
	            else{
	            	current.left = helper(start);
	            }
	            next = slowPointer.next;
	            current.right = helper(next);
	            slowPointer.next = null;
	            
	            
	            return current;
	        }
}
