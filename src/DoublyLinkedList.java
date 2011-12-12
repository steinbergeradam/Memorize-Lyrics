import java.util.Iterator;


public class DoublyLinkedList<T> {
	
	protected DListNode<T> head = null;
	protected DListNode<T> tail = null;
	protected int numElements = 0;
	
	public int size() {
		return this.numElements;
	} // end size()
	
	public void addToFront(T data) {
		DListNode<T> newNode = new DListNode<T>(data, null, this.head);
		
		if (head == null) {
			this.tail = newNode;
		} else {
			this.head.setPrev(newNode);
		} // end if
		
		this.head = newNode;
		this.numElements++;
	} // end addToFront()
	
	public T search(T data) {
		T result = null;
		DListNode<T> found = this.searchNode(data);
		if (found != null) {
			result = found.getData();
		} // end if
		return result;
	} // end search()
	
	private DListNode<T> searchNode(T data) {
		DListNode<T> current = null;
		for (current = this.head; current != null && !data.equals(current.getData()); current = current.getNext());
		return current;
	} // end searchNode()
	
	protected void deleteNode(DListNode<T> nodeToDelete) {
		DListNode<T> pred = nodeToDelete.getPrev();
		DListNode<T> succ = nodeToDelete.getNext();
		
		if (pred == null) {
			this.head = succ;
		} else {
			pred.setNext(succ);
		} // end if
		
		if (succ == null) {
			this.tail = pred;
		} else {
			succ.setPrev(pred);
		} // end if
	} // end deleteNode()
	
	public T delete(T data) {
		T result = null;
		DListNode<T> found = this.searchNode(data);
		if (found != null) {
			result = found.getData();
			this.deleteNode(found);
		} // end if
		return result;
	} // end delete()
	
	public String toString() {
		String result = "";
		DListNode<T> current;
		for (current = this.head; current != null; current = current.getNext()) {
			result += current.getData() + " ";
		} // end for
		return result;
	} // end toString()
	
	public Iterator<T> getIterator() {
		return new DoublyLinkedListIterator();
	} // end getIterator()
	
	private class DoublyLinkedListIterator implements Iterator<T> {
		
		private DListNode<T> nextAvailable = head;
		
		public boolean hasNext() {
			return (this.nextAvailable != null);
		} // end hasNext()
		
		public T next() {
			T result = this.nextAvailable.getData();
			this.nextAvailable = this.nextAvailable.getNext();
			return result;
		} // end next()
		
		public void remove() {
			if (this.nextAvailable == null) {
				deleteNode(tail);
			} else {
				deleteNode(this.nextAvailable.getPrev());
			} // end if
		} // end remove()
		
	} // end DoublyLinkedListIterator class
	
} // end DoublyLinkedList<T> class
