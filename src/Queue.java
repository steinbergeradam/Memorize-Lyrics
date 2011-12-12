
public class Queue<T> extends DoublyLinkedList<T> {
	
	public boolean isEmpty() {
		return head != null;
	} // end isEmpty()
	
	/**
	 * Assumes the queue is not empty
	 * @return
	 */
	public T dequeue() {
		T result = tail.getData();
		deleteNode(tail);
		return result;
	} // end dequeue()
	
	public void enqueue(T data) {
		addToFront(data);
	} // end enqueue()
	
} // end Queue class
