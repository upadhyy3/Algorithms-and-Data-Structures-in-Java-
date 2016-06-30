package uber;

import java.util.*;

class Node {
	Node previous;
	Node next;
	int key;
	int value;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	int capacity;
	Node head = null;
	Node end = null;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>(capacity);
	}

	public void setHead(Node current) {
		current.previous = null;
		current.next = head;
		if (head != null)
			head.previous = current;
		
		head = current;
		
		if (head.next == null)
			end = current;
	}

	public void removeNode(Node current) {
		if (current.previous != null) {
			current.previous.next = current.next;
		} else {
			head = current.next;
		}

		if (current.next != null) {
			current.next.previous = current.previous;
		} else {
			end = current.previous;
		}

	}

	public int get(int key) {
		if (map.containsKey(key)) {
			removeNode(map.get(key));
			setHead(map.get(key));
			return map.get(key).value;
		}
		return -1;
	}

	public void set(int key, int value) {
		Node current = new Node(key, value);
		if (map.containsKey(key)) {
			Node temp = map.get(key);
			temp.value = value;
			removeNode(temp);
			setHead(temp);
			map.put(key,temp);
		}
		else{
			if (map.size() < capacity) {
				setHead(current);
				map.put(key,current);
			} else {
				map.remove(end.key);
				removeNode(end);
				setHead(current);
				map.put(key, current);
				
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(3);
		cache.set(1,10);
		cache.set(2,20);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.set(3,30);
		cache.set(4,40);
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		

	}

}
