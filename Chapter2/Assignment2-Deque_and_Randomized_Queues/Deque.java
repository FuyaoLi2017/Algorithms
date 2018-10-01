import java.util.Iterator;
/**
 * 
 * @author Fuyao Li
 * @Description 使用双向链表实现双向队列 48N constant worst-case time
 * @Note 单向链表在addLast时间不符合O(n), 变长数组内存使用不符合 8N-56N
 * @param <Item>
 */

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;
	private int size;
	
//	define Node
	private class Node{
		Item item;
		Node pre;
		Node next;
	}
	
//	construct an empty deque
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}
	
//	is the deque empty?
	public boolean isEmpty() {
		return first ==null;
	}
	
//	return the number of items on the deque
	public int Size() {
		return size;
	}

//	add the item to the front
	public void addFirst(Item item) {
		if(item == null)
			throw new java.lang.IllegalArgumentException("add null item.");
		Node newFirst = new Node();
		newFirst.item = item;
		newFirst.pre = null;
		newFirst.next = null;
		if(isEmpty()) {
			first = newFirst;
			last = newFirst;
		}else {
//			要建立双向链表关系，next,pre都需要说明
			newFirst.next = first;
			first.pre = newFirst;
			first = newFirst;
		}
		++size;
	}
	
//	add the item to the end
	public void addLast(Item item) {
		if(item == null)
			throw new java.lang.IllegalArgumentException("add null item.");
		Node newLast = new Node();
		newLast.item = item;
		newLast.pre = null;
		newLast.next = null;
		if(isEmpty()) {
			first = newLast;
			last = newLast;
		}else {
			newLast.pre = last;
			last.next = newLast;
			last = newLast;
		}
		++size;
	}
	
//	remove and return the item from the front
	public Item removeFirst() {
		if(isEmpty())
			throw new java.util.NoSuchElementException("Remove from an empty deque.");
		Item item = first.item;
		if(size == 1) {
			first = null;
			last = null;
		}else
			first = first.next;
		if(isEmpty())
			last = null;
		else {
			first.pre = null;
		}
		--size;
		return item;
	}
	
//	remove and return the item from the end
	public Item removeLast() {
		if(isEmpty())
			throw new java.util.NoSuchElementException("Remove from an empty deque.");
		Item item = last.item;
		if(size == 1) {
			first = null;
			last = null;
		}
		else
			last = last.pre;
		if(!isEmpty()) {
			last.next = null;
		}
		--size;
		return item;
	}
	
//  return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new java.lang.UnsupportedOperationException("can't move.");
		}
		
		public Item next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException("doesn't have Next.");
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
//	unit testing (optional)
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(0);
		deque.addLast(1);
		deque.removeLast();
		deque.removeFirst();
	}
}